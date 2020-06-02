package com.example.demo.controller;

import com.example.demo.TQuestion;
import com.example.demo.service.AuthenticationService;
import com.example.demo.service.QuizService;
import org.apache.thrift.TException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    QuizService quizService;

    @RequestMapping(method = RequestMethod.GET, value = "/{userId}")
    public List<TQuestion> getAllQuestions(@PathVariable String userId) throws TException {
        return quizService.getAllQuestions(userId);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{userId}")
    public String addQuestion(@RequestBody TQuestion tQuestion, @PathVariable String userId) throws TException {
        return quizService.addQuestion(tQuestion, userId);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{userId}")
    public String deleteQuestion(@RequestBody TQuestion tQuestion, @PathVariable String userId) throws TException {
        return quizService.deleteQuestion(tQuestion, userId);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{userId}")
    public String checkAnswerCorrectness(@RequestBody TQuestion tQuestion, @PathVariable String userId, @RequestBody int optionSelected) throws TException {
        return quizService.checkAnswerCorrectness(tQuestion, userId, optionSelected);
    }

}
