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
public class choronic {
    String name  ,note,type;

    public choronic(String name, String note, String type) {
        this.name = name;
        this.note = note;
        this.type = type;
    }

     

    @Override
    public String toString() {
        return name ;
    }
    public void addtodb(choronic c) throws SQLException{
    db.exedb("INSERT INTO `mydb`.`chronic_disease` (`note`, `name`, `type`) VALUES ('"+this.note+"', '"+this.name+"', '"+this.type+"');"
);
    }
}
