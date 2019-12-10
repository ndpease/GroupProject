package GroupProjectAMEdits;

import java.util.*;

public class ValueGuest extends Guest {
    private String valueClubID;
    private int numberOfBookings;
    private double amountSpentWithHotel;
    
    public static ArrayList<ValueGuest> valueGuests = new ArrayList<ValueGuest>();
        
    public ValueGuest(String username, String password, String guestName) {
        super(username, password, guestName);
        this.amountSpentWithHotel = 0.0;
        this.numberOfBookings = 0;
        valueGuests.add(this);
    }
    
    public ValueGuest(String username, String password, String guestName, String saveNumber) {
        super(username, password, guestName);
        this.amountSpentWithHotel = 0.0;
        this.numberOfBookings = 0;
        this.valueClubID = saveNumber;
        valueGuests.add(this);
    }

    public double getAmountSpentWithHotel() {
        return amountSpentWithHotel;
    }

    public int getNumberOfBookings() {
        return numberOfBookings;
    }

    public String getSavingsNumber() {
        return valueClubID;
    }
    
    public void bookingCount(){
        numberOfBookings++;
    }
        
}


