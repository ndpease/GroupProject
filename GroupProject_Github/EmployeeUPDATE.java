/*
Author: Nick Pease
Date: 11/25/19
Title: Group Project Part I: Madison Hotel, Employee Class
Purpose: Create, edit, and manage employee information and access to the Madison Hotel program.
*/
package GroupProjectAMEdits;

//Nick Pease worked on this

import java.util.*;

public class Employee 
{
    private int employeeID;
    private String username;
    private String password;
    private String employeeName;
    
    public static int nextID = 0;
    public static ArrayList<Employee> employees = new ArrayList<Employee>();
    
    public Employee(String username, String password, String employeeName)
    {
        this.employeeID = nextID++;
        this.username = username;
        this.password = password;
        this.employeeName = employeeName;
        employees.add(this);
    }
    
    public String getEmployeeName()
    {
        return this.employeeName;
    }
    
    public String getUsername()
    {
        return this.username;
    }
    
    public void setEmployeeName(String employeeName)
    {
        this.employeeName = employeeName;
    }
    
    public String getPassword()
    {
        return this.password;
    }
    
    public int setPassword(String oldP, String newP)
    {
        int check = 0;
        
        
            if (newP != oldP)
            {
                for (int i = 0; i < newP.length(); i++)
                {
                    if (!Character.isUpperCase(newP.charAt(i)))
                    {
                        check = 1;
                    }
                    else
                    {
                        check = 0;
                        break;
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
                        break;
                    }
                }
                if (Character.isDigit(newP.charAt(0)))
                    check = 1;
                else 
                    check = 0;
            }
        
        
        return check;
    }
    public int setPassword(String newP)
    {
        int check = 0;
            
                for (int i = 0; i < newP.length(); i++)
                {
                    if (!Character.isUpperCase(newP.charAt(i)))
                    {
                        check = 1;
                    }
                    else
                    {
                        check = 0;
                        break;
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
                        break;
                    }
                }
                if (Character.isDigit(newP.charAt(0)))
                    check = 1;
                else 
                    check = 0;
        return check;
    }
    
    public boolean checkCredentials(String username, String password)
    {
        boolean bool = true;
        if (this.username.equals(username) && this.password.equals(password))
            return bool;
        else
        {
            bool = false;
            return bool;
        }
    }
    
}
