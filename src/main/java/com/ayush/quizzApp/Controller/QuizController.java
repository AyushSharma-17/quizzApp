package com.ayush.quizzApp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ayush.quizzApp.Service.QuizService;
import com.ayush.quizzApp.model.QuestionWrapper;



@RestController
@RequestMapping("/quiz")
public class QuizController {
       
    @Autowired
    QuizService quizService;

    //http://localhost:8080/quiz/create?category=java&numQ=5&title=Jquiz
    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestParam String category , @RequestParam int numQ,@RequestParam String title) {
        return quizService.createQuiz(category,numQ,title);
        
    }
    // http://localhost:8080/quiz/get/1
    @GetMapping("get/{id}")
    public ResponseEntity<List<QuestionWrapper>>getQuizQuestions(@PathVariable Integer id) {
        return quizService.getQuizQuestions(id);
    }
    
    
}
