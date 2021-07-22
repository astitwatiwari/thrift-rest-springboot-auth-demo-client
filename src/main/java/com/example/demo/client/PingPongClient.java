package com.example.demo.client;

import com.example.demo.TAuthenticationService;
import com.example.demo.TPingPongService;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TJSONProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.THttpClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PingPongClient {
    @Value("${pingpongservice.url}")
    String pingpongserviceUrl;

    public List<Integer> ping() throws TException {
        THttpClient tHttpClient = new THttpClient(pingpongserviceUrl);
        TProtocol protocol = new TJSONProtocol(tHttpClient);
        TPingPongService.Client client= new TPingPongService.Client(protocol);
        return client.ping().getItems();
    }
}
