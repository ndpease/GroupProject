package FinalGroupProject;


public class RoomService {
    public int roomServID = 0;
    
    public String roomServDescription;
    public double roomServPrice; 
    
    public static int nextID = 0; 
    
    
    public RoomService(String roomServDescription, double roomServPrice)
    {
        this.roomServDescription = roomServDescription;
        this.roomServPrice = roomServPrice;
        this.roomServID = nextID++; 
    }
    
}

//// Add to booking class
/*
// RoomService ArrayList

    public ArrayList<RoomService> roomServices;




/// OrderRoomService() method 
    public void orderRoomService(String roomServDesc, double roomServPrice)
    {
        this.roomServices.add(new RoomService(roomServDesc, roomServPrice));
       
    }

// ShowRoomServices for a booking
    public void showRoomService()
    {
        roomServices.forEach(value -> System.out.println(value));
    }
*/
