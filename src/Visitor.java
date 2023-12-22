import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Visitor extends User {

    private ArrayList<Booking> bookings;

    public Visitor(){
        super();
    }

    @Override
    public void showList(Database database) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Book a court");
        int i = scanner.nextInt();
        switch (i){
            case 1:
                //addCourt(database);
                break;
            case 2:
                //signUp();
                break;
            default:
                System.out.println("Invalid number");
                break;
        }
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(ArrayList<Booking> bookings) {
        this.bookings = bookings;
    }
}
