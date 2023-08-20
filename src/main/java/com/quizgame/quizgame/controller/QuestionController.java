package com.quizgame.quizgame.controller;

import com.quizgame.quizgame.model.Question;
import com.quizgame.quizgame.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("questions")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @GetMapping("")
    public List<Question> questions(){
        return questionService.getQuestions();
    }

    @GetMapping("category/{category}")
    public List<Question> getQuestionsByCategory(@PathVariable String category){
        return  questionService.getQuestionsByCategory(category);
    }

    @PostMapping("/add")
    public Question store(@RequestBody Question question){
        return  questionService.add(question);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
        questionService.delete(id);
        return "one(1) Question Successfully Deleted!";
    }
}
