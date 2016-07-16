/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JdbcManagment;

import common.data.Dbmanager;
import common.model.Cure;
import common.model.EDis;
import common.model.patient;
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
public class CureDao {
     
    public static void addCure(String name , String category , String format) throws SQLException{
        Connection con = Dbmanager.getConnection();
        PreparedStatement st = con.prepareStatement("select max(cure_id) from cure;");
       ResultSet rs = st.executeQuery();
        rs.next();
        int id = rs.getInt(1)+1;
         st = con.prepareStatement("INSERT INTO `cure` "
            + "(`cure_id`, `describtion`, `catregory`, `formate`)"
            + " VALUES ('"+id+"', '"+name+"','"+category+"','"+format+"');");
           st.executeUpdate();
        con.close();
    }
    public static List<Cure> getAllcure() throws SQLException{
    Connection con = Dbmanager.getConnection();
    PreparedStatement st = con.prepareStatement("Select * from cure;");
   ResultSet rs = st.executeQuery();
  List<Cure> temp = new ArrayList<>();
   while(rs.next()){
       Cure cure = new Cure();
       cure.id= rs.getInt(1);
      cure.name = rs.getString(2);
     cure.category = rs.getString(3);
      cure.formate = rs.getString(4);
     
      temp.add(cure);
   }
        return temp;
    }
    
    public void editCure(Cure cure) throws SQLException{
 
        try (Connection con = Dbmanager.getConnection()) {
            PreparedStatement st = con.prepareStatement("UPDATE `cure` SET `describtion`='"+cure.name+"', `catregory`='"+cure.category+"', `formate`='"+cure.formate+"' WHERE `cure_id`='"+cure.id+"';");
            st.executeUpdate();
        }
 }
    
     public static List<String> getAllCurecat() throws SQLException{
    Connection con = Dbmanager.getConnection();
    PreparedStatement st = con.prepareStatement("select distinct catregory from cure;");
   ResultSet rs = st.executeQuery();
  List<String > temp = new ArrayList<>();
   while(rs.next()){
       EDis ed = new EDis();
        
      
       
     
      temp.add(rs.getString(1));
   }
        return temp;
    }
    
}
