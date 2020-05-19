/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dvdlibrary.view;

import com.dvdlibrary.dto.DVD;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author gabrieltowey
 */
public class DVDLibraryView {
    private UserIO io;
   
    public DVDLibraryView(){
        this.io = new UserIOConsoleImpl();
        io.print("Welcome to the DVD library program!");
    }
    
    
    /* Input 
    *  asks a user to input student details and returns a string of those details
    *  @return a String representing information for a DVD: 
    *  title, directorm mpaa rating, studio, date, note
    */
    
    public String addDVD(){
       String title = io.readString("\nEnter the title of the dvd: ");
       String director = io.readString("Enter the name of the director: ");
       String mpaa = io.readString("Enter the mpaa rating for the film: ");
       String studio = io.readString("Enter the studio for the dvd: ");
       String date = io.readString("enter the release date for the movie: ");
       String note = io.readString("Enter your review of the film and any takeaways you havea fter watching: ");
       io.print("The details are being processed");
       return title + "," + director + ","  + mpaa  + ","  + studio  + ","  + date  + ","  + note ;      
    }
    
    /* Output
    *  Outputs all the DVDs in the library to the View
    *  @param library - list of students 
    */
    public void viewAllDVDs(ArrayList<DVD> library){
        if(library.isEmpty()){
           io.print("\nThere are no dvds in the library");
           return;
        }
        Iterator iterator = library.listIterator();
        while(iterator.hasNext() == true){
            io.print(iterator.next().toString());
        }
        
    }
    
    /* Output
    *  Displays a single DVD to the View
    *  @param student - student record to be displayed to the screen
    */
    public void displayDVD(DVD dvd){
        io.print(dvd.toString());
    }
    
    
    /* Input: 
    * takes a title from the user to view a DVD with that title in the library
    * @return returns title of the DVD
    */
    
    
    public String viewSingleDVD(){
        String title = io.readString("Enter the title of the DVD you want to view: ");
        return title;                    
    }
    
    /*Input
    * user inputs title of dvd and dvd with that title is removed from the roster
    * @return title of dvd to be removed from the class roster
    */ 
    public String removeDVD(){
        String title = io.readString("\nEnter the title of the DVD you want to remove ");
        io.print("The details of the DVD are being processed");
        return title;           
    }
    
    /* Prints a menu for the user to the View and asks for user input
    *  Returns an int to represent the option selected from the menu. 
    *  To select each option, the user must enter the leftmost number of each option 
    */
    public int displayMenu(){
        System.out.println("\nMenu");
        System.out.println("Enter the number of the corresponding option from this menu:");
        System.out.println("====================================");
        System.out.println("1) View all DVDs");
        System.out.println("2) View a single DVD");
        System.out.println("3) Add a DVD to the library");
        System.out.println("4) Delete a DVD from the library");
        System.out.println("5) Exit the DVD library");    
        return io.readInt("Enter a number to select an option: ", 1, 5);
    }
    
    public void print(String message){
        io.print(message);
    }
}
