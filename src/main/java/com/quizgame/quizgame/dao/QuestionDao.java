package com.quizgame.quizgame.dao;

import com.quizgame.quizgame.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuestionDao extends JpaRepository<Question, Integer> {

    public List<Question> findByCategory(String category);

    @Query(value = "SELECT * FROM questions q WHERE q.category= :category ORDER BY RAND() LIMIT :question_count ", nativeQuery = true)
    public List<Question> findRandomQuestionByCategory(String category, int question_count);
}
