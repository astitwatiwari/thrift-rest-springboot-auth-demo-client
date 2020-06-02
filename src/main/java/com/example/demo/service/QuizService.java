package com.example.demo.service;

import com.example.demo.TQuestion;
import com.example.demo.client.AuthenticationClient;
import com.example.demo.client.QuizClient;
import org.apache.thrift.TException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {

    @Autowired
    QuizClient quizClient;

    public List<TQuestion> getAllQuestions(String userId) throws TException {
        return quizClient.getAllQuestions(userId);
    }

    public String addQuestion(TQuestion tQuestion, String userId) throws TException {
        return quizClient.addQuestion(tQuestion, userId);
    }

    public String deleteQuestion(TQuestion tQuestion, String userId) throws TException {
        return quizClient.deleteQuestion(tQuestion, userId);
    }

    public String checkAnswerCorrectness(TQuestion tQuestion, String userId, int optionSelected) throws TException {
        return quizClient.checkAnswerCorrectness(tQuestion, userId, optionSelected);
    }
}
