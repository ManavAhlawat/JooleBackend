package com.example.ReactBackend.Controller;

import com.example.ReactBackend.Service.UserService;
import com.example.ReactBackend.TO.UserTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.security.crypto.password.PasswordEncoder;


@RestController
@CrossOrigin
public class UserController {

    @Autowired
    private UserService service;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @PostMapping("/register")
    public ResponseEntity<?> addUser(@RequestBody UserTO user){
        if(user.getUsername().equals(service.getByUserName(user.getUsername()))){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        user.setPassword(bcryptEncoder.encode(user.getPassword()));
//        user.setMemberSince(Calendar.getInstance().getTime());
        System.out.println(user);
        return new ResponseEntity<>(service.saveUser(user),HttpStatus.CREATED);
    }

    @GetMapping("/users")
    public List<UserTO> findAllUsers(){
        return service.getUsers();
    }

    @GetMapping("/userByID/{userID}")
    public UserTO findUserById(@PathVariable int userID){
        return service.getUserById(userID);
    }

    @GetMapping("/user/{userName}")
    public UserTO findUserByName(@PathVariable String userName){
        return service.getByUserName(userName);
    }

    @PutMapping("/updateUser")
    public UserTO updateUser(@RequestBody UserTO user){
        return service.updateUser(user);
    }

    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable int id){
        return ResponseEntity.ok(service.deleteUser(id));
//        return service.deleteUser(id);
    }
}
