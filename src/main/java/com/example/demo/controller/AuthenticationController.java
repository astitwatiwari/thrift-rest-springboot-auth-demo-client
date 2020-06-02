package com.example.demo.controller;

import com.example.demo.service.AuthenticationService;
import org.apache.thrift.TException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/")
public class AuthenticationController {

    @Autowired
    AuthenticationService authenticationService;

    @RequestMapping(method = RequestMethod.POST, value = "/{userName}/{password}")
    public boolean authenticateUser(@PathVariable String userName, @PathVariable String password) throws TException {
        return authenticationService.authenticateUser(userName, password);
    }
}
