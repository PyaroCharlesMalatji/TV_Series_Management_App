/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.tv_series_management_app;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author RC_Student_lab
 */

class SeriesModel{
    public String SeriesId;
    public String SeriesName;
    public String SeriesAge;
    public String SeriesNumberOfEpisode;
    
    public SeriesModel(String id, String name, String age, String episodes) {
        this.SeriesId = id;
        this.SeriesName = name;
        this.SeriesAge = age;
        this.SeriesNumberOfEpisode = episodes;
    }
    
    @Override
    public String toString(){
        return"SERIES ID: " + SeriesId +
              "SERIES NAME: " + SeriesName +
              "SERIES AGE RESTRICTION: " + SeriesAge +
              "NUMBER OF EPISODES: " + SeriesNumberOfEpisode;
    }


}

class Series{
 private  ArrayList<SeriesModel> seriesCollection; 
 private  Scanner scanner;
   
public Series(){
   scanner = new Scanner(System.in);
   seriesCollection = new ArrayList<>();
}

    public void displayMenu(){
    System.out.println("LASTEST SERIES - 2025");
    System.out.println("******************************");
    System.out.println("Enter (1) to launch menu or any other key to exit");
    String input = scanner.nextLine();
    if (!input.equals("1")) ExitSeriesApplication();

    while (true) {
        System.out.println("Please select one of the following menu item:");
        System.out.println("(1) Capture a new series.");
        System.out.println("(2) Search for a series.");
        System.out.println("(3) Update series age restriction.");
        System.out.println("(4) Delete a series.");
        System.out.println("(5) Print series report - 2025.");
        System.out.println("(6) Exit Application.");
        
        String choice = scanner.nextLine();
        switch (choice) {
            
            case "1": CaptureSeries();
            break;
            case "2": SearchSeries();
            break;
            case "3": UpdateSeries();
            break;
            case "4": DeleteSeries();
            break;
            case "5": SeriesReport();
            break;
            case "6": ExitSeriesApplication();
            break;
            default: System.out.println("Invalid option. Please try again.");
            }

        }
    }
    
    public void CaptureSeries(){
        System.out.println("CAPTURE A NEW SERIES");
        System.out.println("********************************");
        
        System.out.print("Enter the series id: ");
        String id =scanner.nextLine();
        
        System.out.print("Enter the series name: ");
        String name=scanner.nextLine();
        
        String age; //temporay here because there in no value yet
        while (true){
            System.out.print("Enter the series age restriction (2-18): ");
            age = scanner.nextLine();
            if (isValidAge(age)) break; //Don't forget to create
            System.out.println("You have entered an incorrect series age! Please re-enter");
        }
        
        System.out.print("Enter the number of episodes for " + name + ": ");
        String episodes=scanner.nextLine();
        
        SeriesModel newSeries = new SeriesModel(id, name, age, episodes);
        seriesCollection.add(newSeries);
        
        System.out.println("Series processed successfully!!!");
        System.out.println("**********************************");
    }
    
    public void SearchSeries(){
        System.out.print("Enter the series Id to search");
        String searchId = scanner.nextLine();
        
        SeriesModel foundSeries = findSeriesById(searchId); // don't forget to create a class
        System.out.println("------------------------------------");
        if (foundSeries != null) {
            System.out.println(foundSeries);
        } else {
            System.out.println("Series with Series Id: " + searchId + "was not found");
        }
        
    }
    
    public void UpdateSeries(){
        System.out.print("Enter the series id to update: ");
        String updateId = scanner.nextLine();
        
        SeriesModel seriesToUpdate = findSeriesById(updateId);// don't forget to create a class
        if (seriesToUpdate != null){
            System.out.print("Enter the new series name: ");
            String newName = scanner.nextLine();
        
        String newAge; // to create a temporary value
        while (true) {
            System.out.print("Enter the new age restriction (2-18): ");
            newAge = scanner.nextLine();
            if (isValidAge(newAge)) break; 
            System.out.println("You have entered an incorect series age! Please re-enter.");        
        }
        
        System.out.print("Enter the new number of episodes: ");
        String newEpisodes = scanner.nextLine();
        
        seriesToUpdate.SeriesName = newName;
        seriesToUpdate.SeriesAge = newAge;
        seriesToUpdate.SeriesNumberOfEpisode = newEpisodes;
        
        System.out.println("Series update successfully!");
      } else {
        System.out.println("Series with series Id: " + updateId + "was not found!");
        }
    }
    
    public void DeleteSeries(){
        System.out.print("Enter the series id to delete: ");
        String deleteId = scanner.nextLine();
        
        SeriesModel seriesToDelete = findSeriesById(deleteId);
        if (seriesToDelete !=null) {
            System.out.print("Are you sure you want to delete series" + deleteId + "? Yes(Y) to delete: ");
            String confirmation = scanner.nextLine();
            if (confirmation.equalsIgnoreCase("Y") || confirmation.equalsIgnoreCase("Yes")) {
                seriesCollection.remove(seriesToDelete);
                System.out.println("Series with the Id: " + deleteId + "was deleted!");
                
            } else {
                System.out.println("Delete opertation cancelled.");
            }
        } else {
            System.out.println("Series with Series Id: " + deleteId + "was not found!");
        }
    }
    
    public void SeriesReport(){
        System.out.println("SERIES REPORT - 2025");
        System.out.println("******************************");
        
        if(seriesCollection.isEmpty()){
            System.out.println("No series captured yet.");
        } else {
            for (int i = 0; i <seriesCollection.size(); i++) {
                System.out.println("Series " + (i + 1));
                System.out.println("-----------------------------------");
                System.out.println(seriesCollection.get(i));
                System.out.println("-----------------------------------");
            }
        }
    }
    
   public void ExitSeriesApplication(){
       System.out.println("Thank you for using the TV Series Management Application! ");
       System.exit(0);
   }
   
   boolean isValidAge(String age){ //Ask ChatGbt for help
     try{
          int ageNum = Integer.parseInt(age);
          return ageNum >= 2 && ageNum <= 18;
       } catch (NumberFormatException e){ //NumberFormatException e is there to catch the specific error that happens when a string isn’t a number
           return false;
       }
   }
   
   SeriesModel findSeriesById(String id){
       for (SeriesModel series : seriesCollection){
           if (series.SeriesId.equals(id))return series;
       }
       return null;
   }
}
    
   


public class TV_Series_Management_App {

    public static void main(String[] args) {
        Series seriesManager = new Series();
        seriesManager.displayMenu();
    }
}
