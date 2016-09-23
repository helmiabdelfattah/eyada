/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sys;

import com.mysql.jdbc.ResultSetImpl;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author helmi
 */
public class eyerecord {
    int t1,t2,t3,t4,t5,t6,t7,t8,t9,t10;
    Date datee = new Date(System.currentTimeMillis());
           
   
    public void adtodb(eyerecord d){
    db.exedb("INSERT INTO `sight_record` (`date`, `r1`, `r2`, `r3`, `r4`, `r5`, `r6`, `r7`, `r8`, `r9`, `r0`, `patient_patient_id`) VALUES ('"+d.datee+"', '"+d.t1+"', '"+d.t2+"', '"+d.t3+"', '"+d.t4+"', '"+d.t5+"', '"+d.t6+"', '"+d.t7+"', '"+d.t8+"', '"+d.t9+"', '"+d.t10+"', '"+visit.pv.id+"');");
    }
   
}
