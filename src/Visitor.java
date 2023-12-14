import java.util.ArrayList;
import java.util.List;

public class Visitor extends User {

    private ArrayList<Booking> bookings;

    public Visitor(){
        super();
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(ArrayList<Booking> bookings) {
        this.bookings = bookings;
    }
}
