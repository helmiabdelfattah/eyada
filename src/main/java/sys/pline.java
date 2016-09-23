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
public class pline {
    String cure , note,place;
    int id, amount , count , duration;

    public pline(String cure, String note, String place, int id, int amount, int count, int duration) {
        this.cure = cure;
        this.note = note;
        this.place = place;
        this.id = id;
        this.amount = amount;
        this.count = count;
        this.duration = duration;
    }
    
    public void addtodb(pline p) throws SQLException{
    
    db.exedb("INSERT INTO `prescription_line` (`prescription_line_id`, `count`, `cure`, `note`, `amount`, `place`, `duration`,`prescription_prescription_id`) VALUES ('"+p.id+"', '"+p.count+"', '"+p.cure+"', '"+p.note+"', '"+p.amount+"', '"+p.place+"', '"+p.duration+"', '"+(db.getmaxper()+1)+"');");
    }
}
