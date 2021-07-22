package com.example.demo.service;

import com.example.demo.client.PingPongClient;
import org.apache.thrift.TException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PingPongService {
    @Autowired
    PingPongClient pingPongClient;

    public List<Integer> ping() throws TException {
        List<Integer> finalResponse = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            List<Integer> response = pingPongClient.ping();
            finalResponse.addAll(response);
        }
        return finalResponse;
    }
}
