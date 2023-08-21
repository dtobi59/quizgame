package com.quizgame.quizgame.controller;

import com.quizgame.quizgame.model.Question;
import com.quizgame.quizgame.model.QuestionWrapper;
import com.quizgame.quizgame.model.Quiz;
import com.quizgame.quizgame.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    QuizService quizService;

    @PostMapping("create")
    public ResponseEntity<String> create(
            @RequestParam String category,
            @RequestParam int question_count,
            @RequestParam String title
    ){
        quizService.add(category, question_count, title);

        return new  ResponseEntity<>("Quiz Created", HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<QuestionWrapper>> get(@PathVariable int id){

        List<QuestionWrapper> questions = quizService.getQuestions(id);
        return new ResponseEntity<>(questions, HttpStatus.OK);
    }

}
