package com.ayush.quizzApp.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ayush.quizzApp.Dao.QuestionDao;
import com.ayush.quizzApp.Dao.QuizDao;
import com.ayush.quizzApp.model.Question;
import com.ayush.quizzApp.model.QuestionWrapper;
import com.ayush.quizzApp.model.Quiz;
import com.ayush.quizzApp.model.Response;

@Service
public class QuizService {
    @Autowired
    QuizDao quizDao;

    @Autowired
    QuestionDao questionDao;

    


    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {

        List<Question> questions= questionDao.findRandomQuestionByCategory(category,numQ);
        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions); // plural setter

quizDao.save(quiz);

return ResponseEntity.status(HttpStatus.CREATED).body("Quiz created successfully");


    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
        Optional<Quiz> quiz= quizDao.findById(id);
        List<Question> questionsFromDB= quiz.get().getQuestions();
        List<QuestionWrapper> questionsForUser= new ArrayList<>();
        for(Question q: questionsFromDB){
            QuestionWrapper qw = new QuestionWrapper(q.getId(), q.getQuestionTitle(), q.getOption1(), q.getOption2(), q.getOption3(), q.getOption4());
            questionsForUser.add(qw);
        }
        return ResponseEntity.ok(questionsForUser);
    }

    public ResponseEntity<Integer> calculateScore(Integer id, List<Response> responses) {
        Quiz quiz= quizDao.findById(id).get();
        List<Question> questions= quiz.getQuestions();
        int right=0;
        int i=0;
        for(Response r: responses){
             if(r.getResponse().equals(questions.get(i).getRightanswer())){
                right++;
             }
             i++;
        }
        return new ResponseEntity<Integer>(right, HttpStatus.OK);
    }

}
