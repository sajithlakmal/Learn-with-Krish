import com.sun.jdi.connect.spi.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {
    private  static  volatile DBManager dbManager = new DBManager();
    public  static  volatile Connection connection;
    public static DBManager getDbManager() {
        if (dbManager == null){
            synchronized (DBManager.class){
                if (dbManager == null){
                    dbManager= new DBManager();
                }
            }
        }

        return dbManager;
    }

    private DBManager(){
        if (dbManager!= null){
            throw  new RuntimeException("Please use getDBManager method");
        }
    }

    public Connection getConnection(){
        if (connection == null){
            synchronized (DBManager.class){
                if(connection == null){
                    String url = "jdbc:derby:memory:sample;create=true";
                    try {
                        connection = (Connection) DriverManager.getConnection(url);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
       return  connection ;
    }

}
