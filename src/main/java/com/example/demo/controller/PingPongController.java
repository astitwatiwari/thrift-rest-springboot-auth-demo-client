package com.example.demo.controller;

import com.example.demo.service.PingPongService;
import org.apache.thrift.TException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/thrift")
public class PingPongController {

    @Autowired
    PingPongService pingPongService;

    @RequestMapping(method = RequestMethod.GET, value = "/ping")
    public List<Integer> ping() throws TException {
        return pingPongService.ping();
    }
}
