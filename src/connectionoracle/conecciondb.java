
package connectionoracle;

import java.sql.Connection;
import java.sql.DriverManager;

public class conecciondb {
   
    public static Connection conectar(){
        Connection cn=null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","prueba2","Luis1234");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cn;
    
    }
    
}
