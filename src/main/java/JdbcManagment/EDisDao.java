/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JdbcManagment;

import common.data.Dbmanager;
import common.model.Cure;
import common.model.EDis;
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
public class EDisDao {
    
     
    public static void addEDis(String name , String category) throws SQLException{
        try (Connection con = Dbmanager.getConnection()) {
            PreparedStatement st = con.prepareStatement("select max(eye_diseases_id) from eye_diseases;");
            ResultSet rs = st.executeQuery();
            rs.next();
            int id = rs.getInt(1)+1;
            st = con.prepareStatement("INSERT INTO `eye_diseases` "
                    + "(`eye_diseases_id`, `name`, `cat`)"
                    + " VALUES ('"+id+"', '"+name+"','"+category+"');");
            st.executeUpdate();
        }
    }
    public static List<EDis> getAllDis() throws SQLException{
    Connection con = Dbmanager.getConnection();
    PreparedStatement st = con.prepareStatement("Select * from eye_diseases;");
   ResultSet rs = st.executeQuery();
  List<EDis> temp = new ArrayList<>();
   while(rs.next()){
       EDis ed = new EDis();
        
      ed.name = rs.getString(2);
     ed.Dcategory = rs.getString(3);
       
     
      temp.add(ed);
   }
        return temp;
    }
    
    
     public static List<String> getAllDiscat() throws SQLException{
    Connection con = Dbmanager.getConnection();
    PreparedStatement st = con.prepareStatement("select distinct cat from eye_diseases;");
   ResultSet rs = st.executeQuery();
  List<String > temp = new ArrayList<>();
   while(rs.next()){
       EDis ed = new EDis();
        
      
       
     
      temp.add(rs.getString(1));
   }
        return temp;
    }
    public void editCure(Cure cure) throws SQLException{
 
        try (Connection con = Dbmanager.getConnection()) {
            PreparedStatement st = con.prepareStatement("UPDATE `cure` SET `describtion`='"+cure.name+"', `catregory`='"+cure.category+"', `formate`='"+cure.formate+"' WHERE `cure_id`='"+cure.id+"';");
            st.executeUpdate();
        }
 }   
    
}
