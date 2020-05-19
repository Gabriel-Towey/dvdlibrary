/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dvdlibrary.dao;

import com.dvdlibrary.dto.DVD;
import com.dvdlibrary.dto.DVDLibrary;
import com.dvdlibrary.exception.LibraryPersistenceException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author gabrieltowey
 */
public class DVDao implements IDVDao {
    
    DVDLibrary library;
    PrintWriter out;
    Scanner in;
    String filePath;
    
    // Constructor 
    // Takes in the filepath as a String and attempts to access it. Will throw an IOException if the file cannot be accessed
    public DVDao(String filePath) throws LibraryPersistenceException{
        this.filePath = filePath;
        try{
            this.out = new PrintWriter(new FileWriter(filePath));
            this.in = new Scanner(new BufferedReader(new FileReader(filePath)));
            this.library = new DVDLibrary();
        }
        catch(IOException io){
            throw new LibraryPersistenceException("ERROR in the persistence of the DVD library ");
        }     
    }
    
    @Override
    public ArrayList getLibrary(){
        return library.getLibrary();
    }
    
    /* Allows for the edit of a specific field within the DVD object
    * @title of the dvd to edit
    * @field of the dvd to edit
    * @edit is the information to be added to changed within the respective field
    */ 
    public void editDVD(String title, String field, String edit) throws LibraryPersistenceException{
        try{
            DVD dvd = library.getDVD(title);
            switch(field){
                case "title":
                    dvd.setTitle(edit);
                    break;
                case "director":
                    dvd.setDirector(edit);
                    break;
                case "mpaa":
                    dvd.setMpaa(edit);
                    break;
                case "studio":
                    dvd.setStudio(edit);
                    break;
                case "date":
                    dvd.setDate(edit);
                    break;
                case "note":
                    dvd.setNote(edit);
                    break;                                     
            }
        }
        catch(LibraryPersistenceException lpe){
            throw lpe;
        }
    }
    
    /* Appends a DVD onto the library
    *  
    */
    @Override
    public void addDVD(DVD dvd) {
        library.add(dvd);
    }
    
    /*removes first occurance of DVD with @title in library 
    *
    */
    @Override
    public DVD removeDVD(String title) throws LibraryPersistenceException{
        try{
            return library.remove(title);
        }
        catch(LibraryPersistenceException lpe){
            throw lpe;
        }
    }
    
    /*  returns the dvd found using its title 
    * @return the first occurance of the dvd with @title
    */
    @Override
    public DVD find(String title) throws LibraryPersistenceException{
        try{
            return library.getDVD(title);
        }
        catch(LibraryPersistenceException lpe){
            throw lpe;
        }
    }
    
    /* Saves the @dvdLibrary to a file in csv format
    *  
    */
    @Override
    public void save(ArrayList<DVD> dvdLibrary){     
        for(DVD d : dvdLibrary){
            out.println(d.toString());
        }
        out.flush();
    }
    
    //Sets the Library to the ArrayList<DVD> @dvdLibrary
    public void setLibrary(ArrayList<DVD> library){
        this.library.setLibrary(library);
    }
    
    /* Constructs an ArrayList of DVDs from each Line of a file
    *  @return the library of DVDs 
    */
    @Override
    public ArrayList<DVD> load(){
        ArrayList<DVD> library = new ArrayList();
        String[] dvd;
        while(in.hasNextLine()){
            dvd = in.nextLine().split(",");
            library.add(new DVD(dvd[0], dvd[1], dvd[2], dvd[3], dvd[4], dvd[5]));
        }
        return library;
        
    }

    
    
}
