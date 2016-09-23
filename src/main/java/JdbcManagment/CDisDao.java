/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JdbcManagment;

import common.data.Dbmanager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author helmi
 */
public class CDisDao {
     public static List<String> getAllPatient() throws SQLException{
    Connection con = Dbmanager.getConnection();
    PreparedStatement st = con.prepareStatement("select distinct(name) from Cdis;");
   ResultSet rs = st.executeQuery();
   con.close();
  List<String> temp = new ArrayList<>();
   while(rs.next()){
       String n=rs.getString(1);
      
      temp.add(n);
   }
        return temp;
    }
}
