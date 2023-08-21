package com.quizgame.quizgame.model;

import lombok.Data;

@Data
public class QuestionWrapper {
    private Integer id;
    private String question_title;
    private String option1;
    private String option2;
    private String option3;
    private String option4;

    public QuestionWrapper(Integer id, String title, String opt1, String opt2, String opt3, String opt4){
        this.id = id;
        this.question_title = title;
        this.option1 = opt1;
        this.option2 = opt2;
        this.option3 = opt3;
        this.option4 = opt4;
    }
}
