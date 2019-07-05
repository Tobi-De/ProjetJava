package com.controller;

import java.util.ArrayList;

public class ArticleFamily {
    private String familyName;
    private String description;
    private static ArrayList<ArticleFamily> families = new ArrayList<>();

    public ArticleFamily(String familyName){
        this.familyName = familyName;
        this.description = "";
        families.add(this);
    }
    public ArticleFamily(String familyName, String description){
        this.familyName = familyName;
        this.description = description;
        families.add(this);
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static ArrayList<ArticleFamily> getListOfFamilies(){
        return ArticleFamily.families;
    }

}
