package com.ayush.quizzApp.Dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ayush.quizzApp.model.Question;

public interface QuestionDao extends JpaRepository<Question, Integer> {

    List<Question> findByCategory(String category);
    
}
