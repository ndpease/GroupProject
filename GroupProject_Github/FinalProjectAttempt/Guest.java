/*
Author: Connor Hotaling
Date: 11/25/19
Title: Group Project Part I: Madison Hotel, Guest Class
Purpose: Create, edit, and manage guest information and access to the Madison Hotel program.
*/

package FinalGroupProject;

//Connor Hotaling worked on this

import java.util.*;

public class Guest {
    private int guestID;
    private String username;
    private String password;
    private String guestName;
    
    public static int nextID = 0;
    public static ArrayList<Guest> guests = new ArrayList<Guest>();
    
    public Guest(String username, String password, String guestName) {
        this.username = username;
        this.password = password;
        this.guestName = guestName;
        this.guestID = nextID++;
        guests.add(this);
    }
    
    public boolean checkCredentials(String username, String password) {
        boolean check = true;
        if (this.username.equals(username) && this.password.equals(password))
            return check;
        else {
            return false;
        }
    }
    
    public String getGuestName() {
        return this.guestName;
    }
    
    public String getUsername() {
        return this.username;
    }
    
    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }
    public void setUsername(String username)
    {
        this.username = username;
    }
    
    public String getPassword()
    {
        return this.password;
    }
    
    public int setPassword(String oldP, String newP)
    {
        int check = 0;
        
            //error case 3
            if (!newP.equals(oldP))
            {
                //Error case 1
                for (int i = 0; i < newP.length(); i++)
                {
                    if (!Character.isUpperCase(newP.charAt(i)))
                    {
                        check = 1;
                    }
                    else
                    {
                        check = 0;
                    }
                    
                }
                for (int i = 0; i < newP.length(); i++)
                {
                    if (!Character.isDigit(newP.charAt(i)))
                    {
                        check = 1;
                    }
                    else
                    {
                        check = 0;
                    }
                }
                if (check == 1)
                    return 1;
                //end error case 1
                
                //error case 2
                if (Character.isDigit(newP.charAt(0)))
                {
                    return 2;
                }
            }
            else
            {
                return 3;
            }
        if (check == 0)
        {
            this.password = newP;
            return check;
        }
        
        return check;
    }
    public int setPassword(String newP)
    {
        int check = 0;
            
                //error case 1
                for (int i = 0; i < newP.length(); i++)
                {
                    if (!Character.isUpperCase(newP.charAt(i)))
                    {
                        check = 1;
                    }
                    else
                    {
                        check = 0;
                    }
                    
                }
                for (int i = 0; i < newP.length(); i++)
                {
                    if (!Character.isDigit(newP.charAt(i)))
                    {
                        check = 1;
                    }
                    else
                    {
                        check = 0;
                    }
                }
                if (check == 1)
                    return 1;
                
                //end error case 1
                
                //error case 2
                if (Character.isDigit(newP.charAt(0)))
                {
                    return 2;
                }
                
                else 
                    check = 0;
                
        if (check == 0)
        {
            this.password = newP;
        }
        
        return check;
    }
    
    public void setBlankPassword()
    {
        this.password = "";
    }
    
    public void setBlankUsername()
    {
        this.username = "";
    }
}
