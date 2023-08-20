package com.quizgame.quizgame.service;

import com.quizgame.quizgame.dao.QuestionDao;
import com.quizgame.quizgame.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {
    @Autowired
    QuestionDao questionDao;
    public List<Question> getQuestions(){
        return  questionDao.findAll();
    }

    public List<Question> getQuestionsByCategory(String category){
        return  questionDao.findByCategory(category);
    }

    public  Question add(Question question){
        return  questionDao.save(question);

    }

    public void delete (Integer id){
        questionDao.deleteById(id);
    }
}
