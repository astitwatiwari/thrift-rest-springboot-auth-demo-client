package com.example.demo.client;

import com.example.demo.TAuthenticationService;
import com.example.demo.TQuestion;
import com.example.demo.TQuizService;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TJSONProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.THttpClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class QuizClient {
    @Value("${quizService.url}")
    String quizUrl;

    public List<TQuestion> getAllQuestions(String userId) throws TException{
        THttpClient tHttpClient = new THttpClient(quizUrl);
        TProtocol protocol = new TJSONProtocol(tHttpClient);
        TQuizService.Client client= new TQuizService.Client(protocol);
        return client.getAllQuestions(userId);
    }

    public String addQuestion(TQuestion tQuestion, String userId) throws TException{
        THttpClient tHttpClient = new THttpClient(quizUrl);
        TProtocol protocol = new TJSONProtocol(tHttpClient);
        TQuizService.Client client= new TQuizService.Client(protocol);
        return client.addQuestion(tQuestion, userId);
    }

    public String deleteQuestion(TQuestion tQuestion, String userId) throws TException{
        THttpClient tHttpClient = new THttpClient(quizUrl);
        TProtocol protocol = new TJSONProtocol(tHttpClient);
        TQuizService.Client client= new TQuizService.Client(protocol);
        return client.deleteQuestion(tQuestion, userId);
    }

    public String checkAnswerCorrectness(TQuestion tQuestion, String userId, int optionSelected) throws TException{
        THttpClient tHttpClient = new THttpClient(quizUrl);
        TProtocol protocol = new TJSONProtocol(tHttpClient);
        TQuizService.Client client= new TQuizService.Client(protocol);
        return client.checkAnswerCorrectness(tQuestion, userId, optionSelected);
    }

}
