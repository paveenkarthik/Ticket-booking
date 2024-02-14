

import java.sql.Connection;
import java.sql.DriverManager;

public class DB {
static Connection con;

    public static Connection database() {

        try {
            
            // Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/ticketbooking";
            String user = "root";
            String pass = "root";
            con =DriverManager.getConnection(url, user, pass);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return con;

    }
}
