package com.quizgame.quizgame.dao;

import com.quizgame.quizgame.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizDao extends JpaRepository<Quiz, Integer> {

}
