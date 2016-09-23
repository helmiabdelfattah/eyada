/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JdbcManagment;

import common.data.Dbmanager;
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
public class PatientDao {
    
    public static void addPatient(patient p) throws SQLException{
         p.id =getMaxId()+1;
        Connection con = Dbmanager.getConnection();
         PreparedStatement st = con.prepareStatement("INSERT INTO `patient` "
            + "(`patient_id`, `first_name`, `second_name`, `last_name`, `title`,`titlee`, `gender`, `age`, `phone`, `address_1`, `address_2`, `note`, `company`, `meeting`, `day_of_birth` , `email` , `facebook`,  `count`)"
            + " VALUES ('"+p.id+"', '"+p.first+"', '"+p.second+"', '"+p.last+"', '"+p.title+"', '"+p.titlee+"', '"+p.gender+"','"+p.age+"', '"+p.phone+"', '"+p.add1+"', '"+p.add2+"', '"+p.note+"', '"+p.company+"', '"+p.meeting+"', '"+p.birthDate+"' , '"+p.email+"' , '"+p.facebook+"',"+p.count+");");
           st.executeUpdate();
        con.close();
    }
    public static List<String> getAllPatient() throws SQLException{
    Connection con = Dbmanager.getConnection();
    PreparedStatement st = con.prepareStatement("Select * from patient;");
   ResultSet rs = st.executeQuery();
  
  List<String> temp = new ArrayList<>();
   while(rs.next()){
       String n="";
       n= n+ rs.getInt(1)+"#";
      n= n+ rs.getString(2)+" ";
      n= n+ rs.getString(3)+" ";
      n= n+ rs.getString(4)+" ";
      n= n+ rs.getString(5);
      temp.add(n);
   }
    con.close();
        return temp;
    }
    
    public patient getById(int id) throws SQLException{
 patient p =new patient ();
 Connection con = Dbmanager.getConnection();
    PreparedStatement st = con.prepareStatement("select * from patient where  patient_id ="+id+";");
    ResultSet rs = st.executeQuery();
    con.close();
 rs.next();
 p.id=rs.getInt("patient_id");
 p.first =rs.getString("first_name");
 p.second = rs.getString("second_name");
 p.last = rs.getString("last_name");
 p.title =rs.getString("title");
 p.titlee =rs.getString("titlee");
 p.company = rs.getString("company");
 p.birthDate = rs.getDate("day_of_birth");
  p.email = rs.getString("email");
 p.facebook = rs.getString("facebook");
 p.age = rs.getShort("age");
 p.phone=rs.getString("phone");
 p.add1 = rs.getString("address_1");
 p.add2 = rs.getString("address_2");
 p.meeting = rs.getString("meeting");
 p.note =rs.getString("note");
 p.count=rs.getInt("count");
 p.account=rs.getInt("account");
         
 return p;
 }   
    public static int getMaxId() throws SQLException{
    int id= 0 ;
    Connection con = Dbmanager.getConnection();
    PreparedStatement st = con.prepareStatement("select max(patient_id)  from patient;");
    ResultSet rs = st.executeQuery();
     
 rs.next();
    id = rs.getInt(1);
        return  id;
    }
}
