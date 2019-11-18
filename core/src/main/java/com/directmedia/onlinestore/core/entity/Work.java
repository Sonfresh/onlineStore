/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.directmedia.onlinestore.core.entity;

/**
 *
 * @author Administrator
 */
public class Work {
    private long id;
    private String title;
    private String genre;
    private int release;
    private String summary;
    private String urlImg;
    Artist mainArtist;

    public Work() {

    }

    public Work(String pTitle) {
            this.title = pTitle;
    }

    public Work(long pId, String pTitle, int pRelease, Artist pMainArtist, String pGenre, String pSummary, String pUrlImg) {
        this.id = pId;
        this.title = pTitle;
        this.release = pRelease;
        this.mainArtist = pMainArtist;
        this.genre = pGenre;
        this.summary = pSummary;
        this.urlImg = pUrlImg;
    }

    public long getId() {
        return id;
    }

    public String getUrlImg() {
        return urlImg;
    }

    public void setUrlImg(String urlImg) {
        this.urlImg = urlImg;
    }
    

    public void setId(long id) {
        this.id = id;
    }
    

    public String getTitle() {
            return title;
    }

    public void setTitle(String title) {
            this.title = title;
    }

    public String getGenre() {
            return genre;
    }

    public void setGenre(String genre) {
            this.genre = genre;
    }

    public int getRelease() {
            return release;
    }

    public void setRelease(int release) {
            this.release = release;
    }

    public String getSummary() {
            return summary;
    }

    public void setSummary(String summary) {
            this.summary = summary;
    }

    public Artist getMainArtist() {
            return mainArtist;
    }

    public void setMainArtist(Artist mainArtist) {
            this.mainArtist = mainArtist;
    }

    public String toString() {
            String message = this.getTitle() + "(" + this.getRelease() + ")";
            return message;
    }
}
