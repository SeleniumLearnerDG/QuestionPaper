package com.bean;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class QuestionPaper {
    private String question;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String suggestion;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        question = question;
    }

    public QuestionPaper(String question, String options1, String options2, String options3, String options4, String suggestion) {
        this.question = question;
        this.option1 = options1;
        this.option2 = options2;
        this.option3 = options3;
        this.option4 = options4;
        this.suggestion = suggestion;
    }

    public QuestionPaper(String question, String options1, String options2, String options3, String options4) {
        this(question,options1,options2,options3,options4,null);
    }


    public QuestionPaper(String question, String options1, String options2, String options3) {
        this(question,options1,options2,options3,null,null);
    }

    public QuestionPaper(String question, String options1, String options2) {
       this(question,options1,options2,null,null,null);
    }

    public String getOptions1() {
        return option1;
    }

    public void setOptions1(String options1) {
        this.option1 = options1;
    }

    public String getOptions2() {
        return option2;
    }

    public void setOptions2(String options2) {
        this.option2 = options2;
    }

    public String getOptions3() {
        return option3;
    }

    public void setOptions3(String options3) {
        this.option3 = options3;
    }

    public String getOptions4() {
        return option4;
    }

    public void setOptions4(String options4) {
        this.option4 = options4;
    }

    public String getSuggestion() {
        return suggestion;
    }

    public void setSuggestion(String suggestion) {
        this.suggestion = suggestion;
    }
}
