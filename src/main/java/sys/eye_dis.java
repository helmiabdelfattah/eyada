/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sys;

import java.sql.SQLException;

/**
 *
 * @author helmi
 */
public class eye_dis {
    String name , category , note;

    public eye_dis(String name, String category, String note) {
        this.name = name;
        this.category = category;
        this.note = note;
    }

    @Override
    public String toString() {
        return  name ;
    }
    public void addtodb(eye_dis d ) throws SQLException{
    
    db.exedb("INSERT INTO `eye_diseases` (`eye_diseases_id`, `name`, `cat`, `note`) VALUES ('"+(db.getmaxeye_disid()+1)+"', '"+d.name+"', '"+d.category+"', '"+d.note+"');");
    }
    
}
