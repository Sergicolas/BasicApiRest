package com.scz.BasicApiRest.application;

import com.scz.BasicApiRest.models.UserRegister;
import com.scz.BasicApiRest.repository.UserRegisterRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/api")
@CrossOrigin(origins = "*")
@Api(value="API REST User Register")
public class UserRegisterController {

    @Autowired
    UserRegisterRepository userRegisterRepository;

    @GetMapping("/users")
    @ApiOperation(value="Return a list of Users")
    public List<UserRegister> findAllUsers(){
        return userRegisterRepository.findAll();
    }


    @GetMapping("/user/{id}")
    @ApiOperation(value="Return a single User")
    public UserRegister findUserById(@PathVariable(value = "id") long id){
        return userRegisterRepository.findUserById(id);
    }

    @PostMapping("/user")
    @ApiOperation(value="Register a new User")
    public UserRegister saveUser(@RequestBody UserRegister userRegister){
        return userRegisterRepository.save(userRegister);
    }

    @PutMapping("/user")
    @ApiOperation(value="Update an User")
    public UserRegister updateUser(@RequestBody UserRegister userRegister){
        return userRegisterRepository.save(userRegister);
    }

    @DeleteMapping("/user/{id}")
    @ApiOperation(value="Delete an User by id")
    public void deleteUser(@PathVariable(value = "id") long id){
        userRegisterRepository.deleteById(id);
    }
}
