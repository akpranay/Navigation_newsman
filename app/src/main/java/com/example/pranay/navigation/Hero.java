package com.example.pranay.navigation;

/**
 * Created by Pranay on 3/21/2018.
 */

public class Hero {

    public static final String TABLE_NAME = "bookmark";

    public static final String COLUMN_H = "HEADLINES";
    public static final String COLUMN_L = "LINKS";
    public static final String COLUMN_B="BOOK";

    private String headlines,links,summary, bio;

    public Hero(String headlines,String links, String bio, String summary) {
        this.headlines=headlines;
        this.summary=summary;
        this.links=links;
        this.bio = bio;
    }

    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + COLUMN_H + " TEXT,"
                    + COLUMN_L + " TEXT,"
                    + COLUMN_B + "TEXT"
                    + ")";




    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }


    public String getHeadlines() {
        return headlines;
    }

    public void setHeadlines(String headlines) {
        this.headlines = headlines;
    }


    public String getLinks() {
        return links;
    }

    public void setLinks(String realName) {
        this.links = links;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}