import javax.xml.crypto.Data;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CourtDatabase {

    public static void addNewCourt(Court court, Database database){
        // adding new record for courtDatabase
        String sqlCode = "INSERT INTO `courts`(`id`, `place`) VALUES ('"+court.getID()+"','"+court.getPlace()+"');";
        try {
            database.getStatement().execute(sqlCode);
            System.out.println("New court added");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // creating new table for this court
        String tableName = "court"+court.getID();
        try {
            database.getStatement().execute("CREATE TABLE "+tableName+" (ID int, visitorID int, date date, startTime time,hours int);");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Court> getAllCourts(Database database){
        ArrayList<Court> courts = new ArrayList<>();
        try {
            ResultSet rs = database.getStatement().executeQuery("SELECT * FROM `courts`;");
            while (rs.next()){
                Court court = new Court();
                court.setID(rs.getInt("id"));
                court.setPlace(rs.getString("place"));
                courts.add(court);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return courts;
    }

    public static int newCourtID(Database database){
        int id = 0;
        if(getAllCourts(database).size()!=0){
            id = getAllCourts(database).getLast().getID()+1;
        }
        return id;
    }

    public static boolean checkPlace(String place, Database database){
        try {
            ResultSet rs = database.getStatement().executeQuery("SELECT * FROM `courts` WHERE `place` = '"+place+"';");
            if(rs.next()){
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public static boolean deleteCourt(int ID, Database database){
        // deleting record for courtDatabase
        try {
            ResultSet rs = database.getStatement().executeQuery("SELECT * FROM `courts` WHERE `ID` = "+ID+";");
            if(rs.next()){
                PreparedStatement ps = database.getConnection().prepareStatement("DELETE FROM `courts` WHERE ID = "+ID+";");
                ps.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        // deleting court's table
        String tableName = "court"+ID;
        try {
            database.getStatement().execute("DROP TABLE `squashdatabase`."+tableName+";");
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static void addBooking(){}

}
