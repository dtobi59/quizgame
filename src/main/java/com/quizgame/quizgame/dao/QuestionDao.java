package com.quizgame.quizgame.dao;

import com.quizgame.quizgame.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionDao extends JpaRepository<Question, Integer> {

    public List<Question> findByCategory(String category);
}
