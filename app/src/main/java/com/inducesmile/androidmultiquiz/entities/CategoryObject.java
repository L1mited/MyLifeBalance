package com.inducesmile.androidmultiquiz.entities;

public class CategoryObject {

    private int id;

    private String quizCategoryName;

    private String quizCategoryImagePath;

    public CategoryObject() {}

    public CategoryObject(int id, String quizCategoryName, String quizCategoryImagePath) {
        this.id = id;
        this.quizCategoryName = quizCategoryName;
        this.quizCategoryImagePath = quizCategoryImagePath;
    }

    public int getId(){
        return id;
    }

    public void setId(int id)   {
        this.id = id;
    }

    public String getQuizCategoryName() {
        return quizCategoryName;
    }

    public void setQuizCategoryName(String id) {
        this.quizCategoryName = id;
    }

    public String getQuizCategoryImagePath() {
        return quizCategoryImagePath;
    }

    public void setQuizCategoryImagePath(String quizCategoryImagePath) {
        this.quizCategoryImagePath = quizCategoryImagePath;
    }
}
