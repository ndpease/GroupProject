/*
Author: Stephen Pannier
Date: 11/25/19
Title: Group Project Part I: Madison Hotel, Room Class
Purpose: Create, edit, and manage hotel rooms to be used in the Madison Hotel program.
*/

package GroupProjectAMEdits;

import java.util.*;

public class Room 
{
    //Data Field Declarations
    private int roomID;
    private int roomBookQuantity;
    private boolean roomBooked;
    public int bedOption;
    public int kitchenOption;
    public int coffeeOption;
    public int accessibleOption;
    public int roomNumber;
    public double roomCostPerNight;
    public boolean roomStatus; 
    
    // Static Datafield Initialization
    public static int nextID = 0; 
    public static ArrayList<Room> rooms = new ArrayList<Room>();
    
    // Room Options are stored in these static arrays (0 position left blank) 
    public static String[] bedTypes = {null,"1 Queen Bed", "2 Queen Beds", "1 King Bed"};
    public static String[] kitchenTypes = {null,"Microwave", "Fridge and Microwave"};
    public static String[] coffeeTypes = {null,"1-Cup Standard Coffee Machine", "Keurig Hot K200 Machine"};
    public static String[] accessTypes = {null,"Standard Room", "Enhanced Accessibility Room"};
    
    // Constructor
    public Room(int bed, int kitch, int coffee, int accessibility, int roomNumber) {
        this.bedOption = bed;
        this.kitchenOption = kitch;
        this.coffeeOption = coffee;
        this.accessibleOption = accessibility;
        this.roomNumber = roomNumber;
        this.roomID = nextID++;
        this.roomBookQuantity = 0;
        rooms.add(this);
        this.roomStatus = true; 
    }
    
    public boolean bookRoom() {
        if (this.roomBooked == false) {
            this.roomBooked = true;
            this.roomBookQuantity++;
            return true;
        } 
        else { 
            return false;
        }
    }
    
    public void freeThisRoom() {
        this.roomBooked = false;
    }
    
    public String roomAnalytics() {
        // For Employee Use - Contains room number, no. of prev. bookings, and room booked status
        String roomAna = "Room Analytics\n----------------------------";
        roomAna += "\nRoom Number:\t\t" + this.roomNumber;
        roomAna += "\nPrevious Bookings:\t" + this.roomBookQuantity;
        if (this.roomBooked) {
            roomAna += "\nRoom Booked?\t\tYES";
        } 
        else {
            roomAna += "\nRoom Booked?\t\tNO";
        } 
       return roomAna;
    }
    
    public String roomDescription() { 
        String roomDesc = "Room Number " + this.roomNumber + "\n-----------------\n";
        roomDesc += "This room features the following amenities: \n";
        roomDesc += "  -- " + bedTypes[this.bedOption] +"\n";
        roomDesc += "  -- " + kitchenTypes[this.kitchenOption] +"\n";
        roomDesc += "  -- " + coffeeTypes[this.coffeeOption] +"\n";
        roomDesc += "  -- " + accessTypes[this.accessibleOption] +"\n";
        /*
        if (this.roomBooked) {
            roomDesc += "\nUnfortunately, this room is currently booked.";
        } 
        else {
            roomDesc += "\nThis room is available!";
        }*/
        return roomDesc;
    }
    
    public int getRoomBookedQuantity() {
        return this.roomBookQuantity;
    }
    
    public int getRoomID() {
        return this.roomID;
    }
    
    public int getRoomNumber() {
        return this.roomNumber;
    }
    
    public boolean setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
        return true;
    }
    public void setRoomActive()
    {
        this.roomStatus = true;
    }
    public void setRoomInactive()
    {
        this.roomStatus = false;
    }
    public void setRoomCost(double roomCost)
    {
        this.roomCostPerNight = roomCost; 
    }
    public double getRoomRevenue()
    {
        double roomRev = this.roomCostPerNight * this.roomBookQuantity;
        return roomRev; 
    }
    
    public boolean getBooked()
    {
        return this.roomBooked;
    }
}
