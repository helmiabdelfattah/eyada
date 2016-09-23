/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sys;

import com.sun.org.apache.bcel.internal.generic.RETURN;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JCheckBox;

/**
 *
 * @author helmi
 */
public class cure {
    int id ;
    String name , category , formate ;
    

    public cure() {
    }

    public cure(int id, String name, String category,  String formate) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.formate = formate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

   
            public static int setval(boolean  a){
                if (a==true)return 1;
                else return 0;
                
            }

//INSERT INTO `mydb`.`cure` (`cure_id`, `describtion`, `t1`, `t2`, `t3`, `t4`, `t5`, `t6`, `catregory`) VALUES ('2', 'bool', '0', '1', '0', '1', '1', '1', '1');
public void addtodb(cure c){
    db.exedb(
             "INSERT INTO `cure` (`cure_id`, `describtion`, `formate`, `catregory`)"
            + "VALUES ('"+c.id+"', '"+c.name+"', '"+c.formate+"' ,'"+c.category+"')");
    }

    public String getFormate() {
        return formate;
    }

    public void setFormate(String formate) {
        this.formate = formate;
    }

    void setT1(JCheckBox jCheckBox1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public static cure getfromdb(String name) throws SQLException{
    ResultSet rs = db.getdb("select * from cure where describtion ='"+name+"';");
    rs.next();
    cure c =new cure(rs.getInt("cure_id"), rs.getString("describtion"),rs.getString("catregory"), rs.getString("format"));
//    c.id=rs.getInt("cure_id");    
    System.out.println("jsdghds"+c.id);
    return c;
    
    }
    
}