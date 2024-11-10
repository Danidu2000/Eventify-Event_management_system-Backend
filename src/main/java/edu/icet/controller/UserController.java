package edu.icet.controller;

import edu.icet.dto.LoginDetails;
import edu.icet.dto.LoginStatus;
import edu.icet.dto.User;
import edu.icet.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@CrossOrigin
public class UserController {
    @Autowired
    final UserService service;
    @GetMapping("/get-all")
    public List<User> getAll(){
        return service.getAll();
    }
    @PostMapping("/add-user")
    public void addUser(@RequestBody User user){
        service.add(user);
    }
    @PutMapping("/update-user")
    public void updateUser(@RequestBody User user){
        service.update(user);
    }
    @DeleteMapping("/delete-by-id/{id}")
    public void deleteUser(@PathVariable Integer id){
        service.deleteById(id);
    }
    @GetMapping("/search-by-id/{id}")
    public User searchUserById(@PathVariable Integer id){
        return service.searchById(id);
    }
    @PostMapping("/login")
    public LoginStatus login(@RequestBody LoginDetails loginDetails){
        return service.login(loginDetails);
    }
    @GetMapping("/search-by-email/{email}")
    public User searchUserByEmail(@PathVariable String email){
        return service.searchByEmail(email);
    }
}
