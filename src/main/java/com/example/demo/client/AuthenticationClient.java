package com.example.demo.client;

import com.example.demo.TAuthenticationService;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TJSONProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.THttpClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationClient {
    @Value("${authenticationService.url}")
    String authenticationUrl;

    public boolean authenticateUser(String userName, String password) throws TException {
        THttpClient tHttpClient = new THttpClient(authenticationUrl);
        TProtocol protocol = new TJSONProtocol(tHttpClient);
        TAuthenticationService.Client client= new TAuthenticationService.Client(protocol);
        return client.authenticateUser(userName, password);
    }
}
