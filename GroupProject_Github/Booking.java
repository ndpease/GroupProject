/*
Author: Anthony Everard
Date: 11/25/19
Title: Group Project Part I: Madison Hotel, Guest Class
Purpose: Create, edit, and manage hotel bookings, connected to the Guest and Room
Classes within the  Madison Hotel program.
*/

package GroupProjectAMEdits;

import java.util.*;

public class Booking {
    public Room bookedRoom;
    public Guest bookingGuest;
    public int bookingYear;
    public int checkInDay;
    public int checkOutDay;
    public int ID;
    
    public static int nextID;
    public static ArrayList<Booking> bookings = new ArrayList<Booking>();
    
    public Booking(Guest bookingGuest, Room bookedRoom, int year, int checkIn, int checkOut) {
        this.bookedRoom = bookedRoom;
        this.bookingGuest = bookingGuest;
        this.bookingYear = year;
        this.checkInDay = checkIn;
        this.checkOutDay = checkOut;
        this.ID = nextID;
        nextID++;
        bookings.add(this);    
    }
    
    public void endBooking() {
        this.bookedRoom.freeThisRoom();
        this.bookedRoom = null;
    }
}
