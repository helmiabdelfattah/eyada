/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author helmi
 */
public class Dbmanager {
    static Connection conn = null ;
    
    public static Connection getConnection(){
         
            try {
                if(conn!=null)
                conn.close();
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Dbmanager.class.getName()).log(Level.SEVERE, null, ex);
                }
                String sTempDb = "mydb.db";
                String sJdbc = "jdbc:sqlite";
                String sDbUrl = sJdbc + ":" + sTempDb;
//                      org.sqlite.JDBC .. com.mysql.jdbc.Driver
                //STEP 3: Open a connection
                System.out.println("Connecting to database...");
                
                
                return DriverManager.getConnection("jdbc:mysql://localhost/mydb.db?" +
                                   "user=root&password=");
                
                
            } catch (SQLException ex) {
                Logger.getLogger(Dbmanager.class.getName()).log(Level.SEVERE, null, ex);
            }
        return null;
       
}
}
