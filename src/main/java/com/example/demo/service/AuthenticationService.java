package com.example.demo.service;

import com.example.demo.client.AuthenticationClient;
import org.apache.thrift.TException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    @Autowired
    AuthenticationClient authenticationClient;

    public boolean authenticateUser(String userName, String password) throws TException {
        return authenticationClient.authenticateUser(userName, password);
    }
}
