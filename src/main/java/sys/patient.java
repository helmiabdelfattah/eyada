/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sys;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *c
 * @author helmi
 */
public class patient {
   public  int id , day , month,year,age,count ,account;
   public Date birthday;
   public  String first,second, email , facebook , last , title,add1,add2,meeting,company,note,gender,phone;
    public patient(){
    
    }
    public void addtodb(patient p){
        String sql = "INSERT INTO `mydb`.`patient` ( `first_name`, `title`, `gender`, `age`, `phone`, `address_1`, `address_2`, `note`, `company`, `meeting`, `email`, `facebook`, `titlee`, `count`, `birthdate`) "
            + " VALUES ('"+p.first+"', '"+p.title+"', '"+p.gender+"', '"+p.age+"','"+p.phone+"', '"+p.add1+"', '"+p.add2+"', '"+p.note+"', '"+p.company+"', '"+p.meeting+"', '"+p.email+"' , '"+p.facebook+"', '"+p.title+"',"+p.count+",'"+p.birthday+"');";
        System.out.println(sql);
    db.exedb(sql);}
    
    
    
    public void editdb(patient p,int idaa){
        String sql = "UPDATE `mydb`.`patient` SET `first_name`='"+p.first+"', `title`='"+p.title+"', `gender`='"+p.gender+"', `age`='"+p.age+"', `phone`='"+p.phone+"', `address_1`='"+p.add1+"', `note`='"+p.note+"', `company`='"+p.company+"', `meeting`='"+p.meeting+"', `email`='"+p.email+"', `facebook`='"+p.facebook+"', `titlee`='"+p.title+"', `birthdate`='"+p.birthday+"' WHERE `patient_id`='"+idaa+"';";
        System.out.println(sql);
    db.exedb(sql);}

    @Override
    public String toString() {
        return first + " " + second+"  "+ last;
    }
 public patient getbyname(String n1 ,String n2 ,String n3) throws SQLException{
 patient p =new patient ();
 ResultSet rs = db.getdb("select * from patient where first_name = '"+n1+"' and second_name ='"+n2+"' and last_name ='"+n3+"';");
 rs.next();
 p.id=rs.getInt("patient_id");
 p.first =rs.getString("first_name");

 p.title =rs.getString("titlee");
 p.company = rs.getString("company");

 p.month=rs.getInt("month_of_birth");
 p.birthday = rs.getDate("birthdate");
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
// static String[] getchor(patient p ){
// ResultSet rs = db.getdb("")
// 
// }
}

