import java.sql.SQLException;
import java.util.Scanner;

public class Admin extends User{

    private String code = "0000";
    private static Scanner scanner;

    public Admin(){
        super();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public void showList(Database database) {
        scanner = new Scanner(System.in);

        System.out.println("1. Add new court");
        System.out.println("2. Delete a court");
        int i = scanner.nextInt();
        switch (i){
            case 1:
                addCourt(database);
                break;
            case 2:
                deleteCourt(database);
                break;
            default:
                System.out.println("Invalid number");
                break;
        }
    }
    private static void addCourt(Database database){
        System.out.println("Enter place:");
        String place = scanner.next();
        if(CourtDatabase.checkPlace(place,database)){
            Court court = new Court();
            court.setID(CourtDatabase.newCourtID(database));
            court.setPlace(place);
            CourtDatabase.addNewCourt(court,database);
        } else {
            System.out.println("This place is unvaible");
        }
    }

    private static void deleteCourt(Database database){
        System.out.println("Enter court ID:");
        int id = Integer.parseInt(scanner.next());
        if (CourtDatabase.deleteCourt(id,database)){
            System.out.println("The court has been deleted");
        } else {
            System.out.println("There is no court with ID equal to " + id);
        }
    }
}
