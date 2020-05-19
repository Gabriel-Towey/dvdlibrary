/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dvdlibrary.dto;

import java.util.ArrayList;

/**
 *
 * @author gabrieltowey
 */


public class DVD {
    
    String title;
    String director;
    String mpaa;
    String studio;
    String date;
    String note;
 
    
    public DVD(){
        this.title = "";
        this.director = "";
        this.mpaa = "";
        this.studio = "";
        this.note = "";
        this.date = "";
    }
    
    public DVD(String title, String director, String mpaa, String studio, String date, String note){
        this.title = title;
        this.director = director;
        this.mpaa = mpaa;
        this.studio = studio;
        this.date = date;
        this.note = note;
    }
    
    public DVD(String title, String director, String mpaa, String studio, String date){
        this.title = title;
        this.director = director;
        this.mpaa = mpaa;
        this.studio = studio;
        this.date = date;
        this.note = "";
    }

    //@return title of DVD
    public String getTitle() {
        return title;
    }
    
    //
    public void setTitle(String title) {
        this.title = title;
    }
    
    //@return director
    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    //@return mpaa rating for DVD
    public String getMpaa() {
        return mpaa;
    }

    public void setMpaa(String mpaa) {
        this.mpaa = mpaa;
    }

    //@return studio for film
    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    //@return user generated note on film
    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    //@return date film was made
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }      
    
    //return string in csv format: title,director,mpaa,studio,date,note
    @Override 
    public String toString(){
        return this.title + "," + this.director + "," + this.mpaa + "," + this.studio + "," + this.date + "," + this.note;
    }
    
    
    
    
}
