/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JdbcManagment;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.simple.JSONValue;

/**
 *
 * @author kamal
 */
public class JsonConvert {
    public static String getJSONFromResultSet(ResultSet rs,String keyName) {
    Map json = new HashMap(); 
    List list = new ArrayList();
    if(rs!=null)
    {
        try {
            ResultSetMetaData metaData = rs.getMetaData();
            while(rs.next())
            {
                Map<String,Object> columnMap = new HashMap<String, Object>();
                for(int columnIndex=1;columnIndex<=metaData.getColumnCount();columnIndex++)
                {
                    if(rs.getString(metaData.getColumnName(columnIndex))!=null)
                        columnMap.put(metaData.getColumnLabel(columnIndex),     rs.getString(metaData.getColumnName(columnIndex)));
                    else
                        columnMap.put(metaData.getColumnLabel(columnIndex), "");
                }
                list.add(columnMap);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        json.put(keyName, list);
     }
     return JSONValue.toJSONString(json);
}
    
}
