package com.inducesmile.androidmultiquiz.entities;

public class QuestionObject {

    private int id;

    private int categoryId;

    private String question;

    private String options;

    public QuestionObject(){}


    public QuestionObject(int categoryId, String question, String options) {
        this.categoryId = categoryId;
        this.question = question;
        this.options = options;
    }

    public QuestionObject(int id, int categoryId, String question, String options) {
        this.id = id;
        this.categoryId = categoryId;
        this.question = question;
        this.options = options;
    }

    public int getId() {
        return id;
    }

    public void setId (int id) {
        this.id = id;
    }

    public int getCategoryId (){
        return categoryId;
    }

    public void setCategoryId(int id){
        this.categoryId = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getOptions() {
        return options;
    }

    public void setOptions(String options) {
        this.options = options;
    }

    public String[] convertOptionsToStringArray(String options) {
        String[] allOptions = options.split(",");
        return allOptions;
    }


}
