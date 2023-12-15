import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Database {
    private String userName = "root";
    private String password = "";
    private String url = "jdbc:mysql://localhost:3306/squashdatabase";
    private Statement statement;

    public Database(){
        try {
            Connection connection = DriverManager.getConnection(url,userName,password);
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public Statement getStatement(){
        return statement;
    }
}
