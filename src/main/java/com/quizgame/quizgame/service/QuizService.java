package com.quizgame.quizgame.service;

import com.quizgame.quizgame.dao.QuestionDao;
import com.quizgame.quizgame.dao.QuizDao;
import com.quizgame.quizgame.model.Question;
import com.quizgame.quizgame.model.QuestionWrapper;
import com.quizgame.quizgame.model.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuizService {

    @Autowired
    QuizDao quizDao;
    @Autowired
    QuestionDao questionDao;

    public Quiz add(String category, int question_count, String title){
        List<Question> questions = questionDao.findRandomQuestionByCategory(category,question_count);
        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        return quizDao.save(quiz);
    }

    public List<QuestionWrapper> getQuestions(int id){

        List<Question> questions = quizDao.findById(id).get().getQuestions();
        List<QuestionWrapper> wrapped_questions = new ArrayList<>();
        for (Question q:questions) {
            wrapped_questions.add(new QuestionWrapper(
                    q.getId(),
                    q.getQuestion_title(),
                    q.getOption1(),
                    q.getOption2(),
                    q.getOption3(),
                    q.getOption4()
            ));
        }
        return  wrapped_questions;
    }



}
