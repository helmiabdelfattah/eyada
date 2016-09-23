/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JdbcManagment;

import common.data.Dbmanager;
import common.model.Cure;
import common.model.pline;
import common.model.preciption;
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
public class PreceptionDao {
    public static void addPreciption(preciption pre  ) throws SQLException{
        try (Connection con = Dbmanager.getConnection()) {
            PreparedStatement st = con.prepareStatement("select max(prescription_id) from prescription_line;");
            ResultSet rs = st.executeQuery();
            rs.next();
            int id = rs.getInt(1)+1;
            for (pline col : pre.lines) {
                st = con.prepareStatement("INSERT INTO `prescription_line` "
                        + "(`prescription_id`, `count`, `cure`, `note`, `amount`, `place`, `duration`, `Edis`)"
                        + " VALUES ('"+id+"', '"+col.count+"','"+col.cure+"','"+col.note+"','"+col.amount+"','"+col.place+"','"+col.duration+"','"+pre.dis.name+"');");
                st.executeUpdate();
                con.close();
            }
        }}
        public static List<preciption> getPreByDis(String name) throws SQLException{
            ResultSet rs;
        try (Connection con = Dbmanager.getConnection()) {
            PreparedStatement st = con.prepareStatement("select * from prescription_line where  Edis ='"+name+"' order by  prescription_id;");
            rs = st.executeQuery();
        }
     List<preciption> temp = new ArrayList<>();
  
     while(rs.next()){
       int item=rs.getInt(1);
       preciption ps = new preciption();
       while(item ==rs.getInt(1)){
       pline pl = new pline();
       pl.count= rs.getInt(2);
      pl.cure = rs.getString(3);
     pl.note = rs.getString(4);
     pl.amount = rs.getInt(5);
     pl.place = rs.getString(6);
     pl.duration = rs.getInt(7);
      ps.lines.add(pl);
   }
     temp.add(ps);
     }
        return temp;
        }
    }
    

