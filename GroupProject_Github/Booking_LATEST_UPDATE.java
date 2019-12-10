/*
Author: Anthony Everard
Date: 11/25/19
Title: Group Project Part I: Madison Hotel, Guest Class
Purpose: Create, edit, and manage hotel bookings, connected to the Guest and Room
Classes within the  Madison Hotel program.
*/

package GroupProject;

import java.util.*;

public class Booking {
    public Room bookedRoom;
    public Guest bookingGuest;
    public int checkInYear;
    public int checkInDay;
    public int checkOutYear;
    public int checkOutDay;
    public int ID;
    public RoomService[] services;
    
    public static int nextID;
    public static ArrayList<Booking> bookings = new ArrayList<Booking>();
    
    // NEED TO INSERT THE ROOM_SERVICE INTO INTO A GUEST'S BOOKING
    
    public Booking(Guest bookingGuest, Room bookedRoom, int year, int checkIn, int checkOut) {
        this.bookedRoom = bookedRoom;
        this.bookingGuest = bookingGuest;
        this.checkInYear = year;
        if (checkOut < checkIn)
        {
            checkOutYear = year + 1;
        }
        else
        {
            checkOutYear = year;
        }
        this.checkInDay = checkIn;
        this.checkOutDay = checkOut;
        this.services = new RoomService[100];
        this.ID = nextID;
        nextID++;
        bookings.add(this);    
    }
    
    public void endBooking() {
        this.bookedRoom.freeThisRoom();
        this.bookedRoom = null;
    }
}
