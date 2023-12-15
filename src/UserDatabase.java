import javax.xml.crypto.Data;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDatabase {

    public static boolean emailIsUsed(String emailOrLogin, Database database){
        boolean isUsed = false;
        try{
            ResultSet rs = database.getStatement().executeQuery("SELECT `ID`, `firstName`," +
                    "`lastName`, `phoneNumber`, `email`, `login`," +
                    "`password` FROM `visitors` WHERE `email` OR `login` = '"+emailOrLogin+"';");
            isUsed = rs.next() ;
        } catch (Exception e){
            e.printStackTrace();
        }
        return isUsed;
    }

    public static ArrayList<Visitor> getAllVisitors(Database database){
        ArrayList<Visitor> visitors = new ArrayList<Visitor>();
        try {
            ResultSet rs = database.getStatement().executeQuery("SELECT * FROM `visitors`;");
            while (rs.next()){
                Visitor visitor = new Visitor();
                visitor.setID(rs.getInt("ID"));
                visitor.setFirstName(rs.getString("firstName"));
                visitor.setLastName(rs.getString("lastName"));
                visitor.setPhoneNumber(rs.getString("phoneNumber"));
                visitor.setEmail(rs.getString("email"));
                visitor.setLogin(rs.getString("login"));
                visitor.setPassword(rs.getString("password"));
                visitors.add(visitor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return visitors;
    }
    public static int getNextID(Database database){
        int ID = 0;
        ArrayList<Visitor> visitors = getAllVisitors(database);
        if (visitors.size()!=0){
            Visitor lastVisitor = visitors.getLast();
            ID = lastVisitor.getID()+1;
        }
        return ID;
    }

    public static void addVisitor(Visitor visitor, Database database){
        String sqlCode = "INSERT INTO `visitors`(`ID`, `firstName`, `lastName`, `phoneNumber`, `email`, `login`, `password`)" +
                "VALUES ('"+visitor.getID()+"','"+visitor.getFirstName()+"','"+visitor.getLastName()+"','"+visitor.getPhoneNumber()+"'" +
                ",'"+visitor.getEmail()+"','"+visitor.getLogin()+"','"+visitor.getPassword()+"');";
        try {
            database.getStatement().execute(sqlCode);
            System.out.println("User created");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
