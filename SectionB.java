/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.sectionb;

/**
 *
 * @author RC_Student_lab
 */

// Parent class
class SeriesModel {
    private String id;
    private String name;


    public SeriesModel(String id, String name) {
        this.id = id;
        this.name = name;
    }
    
    public String getId() { return id; }
    public String getName() { return name; }
}

// Child class 
class RatedSeries extends SeriesModel {
    int rating; 

    // Constructor (uses super to call parent)
    public RatedSeries(String id, String name, int rating) {
        super(id, name);
        this.rating = rating;
    }

    public int getRating() { return rating; }
}

// Main app
public class SectionB {
    private RatedSeries[] seriesArray; // Array
    private int count;

    public SectionB(int size) {
        seriesArray = new RatedSeries[size];
        count = 0;
    }

    // Add new series
    public void addSeries(String id, String name, int rating) {
        if (count < seriesArray.length) {
            seriesArray[count] = new RatedSeries(id, name, rating);
            count++;
        }
    }

    // Print report
    public void generateReport() {
        System.out.println("===== SERIES REPORT =====");
        for (int i = 0; i < count; i++) {
            RatedSeries s = seriesArray[i];
            System.out.println("ID: " + s.getId() + 
                               " | Name: " + s.getName() + 
                               " | Rating: " + s.getRating() + "/5");
        }
    }

    // Demo
    public static void main(String[] args) {
        SectionB app = new SectionB(3);
        app.addSeries("101", "One Piece", 5);
        app.addSeries("102", "Naruto", 4);
        app.generateReport();
    }
}
