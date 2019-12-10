/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalGroupProject;

/**
 *
 * @author AEverard
 */
public class RoomDisplay {
    
    public String bed;
    public String kitchen;
    public String coffee;
    public String accessible;
    public String status;
    public int number;
    
    public RoomDisplay(Room room)
    {
        switch (room.bedOption)
        {
            case 1: this.bed = "1 Queen Bed";
                    break;
            case 2: this.bed = "2 Queen Beds";
                    break;
            case 3: this.bed = "1 King Bed";
                    break;
        }
        switch (room.kitchenOption)
        {
            case 1: this.kitchen = "Microwave";
                    break;
            case 2: this.kitchen = "Fridge and Microwave";
                    break;
        }
        switch (room.coffeeOption)
        {
            case 1: this.coffee = "1-Cup Standard Coffee Machine";
                    break;
            case 2: this.coffee = "Keurig Hot K200 Machine";
                    break;
        }
        switch (room.accessibleOption)
        {
            case 1: this.accessible = "Standard Room";
                    break;
            case 2: this.accessible = "Enhanced Accessibility Room";
                    break;
        }
        if(room.roomStatus == false)
        {
            this.status = "Deactive";
        }
        else
        {
            this.status = "Active";
        }
        this.number = room.roomNumber;
    }
    
    public String toString()
    {
        return "Room number :" + number 
                + "\nBed option: " + bed + "\nKitchen option: " 
                + kitchen + "\nCoffee option: " + coffee 
                + "\nAccessiblity option: " + accessible
                + "\nStatus: " + status;
        
    }
    
}
