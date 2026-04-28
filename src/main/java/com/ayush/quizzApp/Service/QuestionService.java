package com.ayush.quizzApp.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ayush.quizzApp.Dao.QuestionDao;
import com.ayush.quizzApp.model.Question;
@Service
public class QuestionService {
  

    @Autowired
    QuestionDao questionDao;


    public List<Question> getAllQuestions() {
        return questionDao.findAll();
       
    }


    public List<Question> getQuestionsByCategory(String category) {
    
        return questionDao.findByCategory(category);
    }


    public String addQuestion(Question question) {
        questionDao.save(question);
        return "Question added successfully";
    }
    
}
