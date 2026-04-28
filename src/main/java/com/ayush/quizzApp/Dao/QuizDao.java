package com.ayush.quizzApp.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ayush.quizzApp.model.Quiz;

public interface QuizDao extends JpaRepository<Quiz, Integer> {
    
}
