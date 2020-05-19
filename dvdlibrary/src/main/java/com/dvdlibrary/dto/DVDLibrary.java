/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dvdlibrary.dto;

import com.dvdlibrary.exception.LibraryPersistenceException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author gabrieltowey
 */
public class DVDLibrary  {
    
    private ArrayList<DVD> library;
    
    //Default Constructor
    public DVDLibrary(){
        this.library = new ArrayList();
    }
    
    //Constructor takes ArrayList as an argument
    public DVDLibrary(ArrayList library){
        this.library = library;
    }
    
    //returns the library 
    public ArrayList getLibrary() {
        return library;
    }
    
    //set library to @library
    public void setLibrary(ArrayList library) {
        this.library = library;
    }
    
    //Returns the first occurance of a DVD with the title == @title
    // throws an error if there is no title within the library with that name
    public DVD getDVD(String title) throws LibraryPersistenceException{
        for(DVD d : this.library){
            if(d.getTitle().equals(title))
                return d;
        }       
        
        throw new LibraryPersistenceException("ERROR: DVD title was not found in the collection");
    }   
    
    
    
    //appends @dvd to the end of the library
    public void add(DVD dvd) {
        this.library.add(dvd);
    }
    
    public DVD remove(String title) throws LibraryPersistenceException{
        for(DVD d : library){
            if(d.getTitle().equals(title)){
                library.remove(d);
                return d;
            }                            
        }
        
        throw new LibraryPersistenceException("ERROR: DVD title was not found in the collection");
    }
    
    //removes first occurance of @dvd from the library. Returns true or not depending on whether it was successful operation
    public boolean remove(DVD dvd) {
        return library.remove(dvd);
    }
    
    
    
    
   
   
}
