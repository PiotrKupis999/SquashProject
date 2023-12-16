import java.util.ArrayList;
import java.util.List;

public class Court {

    private int ID;
    private ArrayList<Booking> bookings;

    public Court(){}

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public ArrayList<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(ArrayList<Booking> bookings) {
        this.bookings = bookings;
    }
}
