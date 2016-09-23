/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import JdbcManagment.JsonConvert;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sys.db;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.json.JSONException;
import org.json.JSONObject;
import sys.choronic;
 
 
 

/**
 *
 * @author Admin
 */
@WebServlet(name = "cordis", urlPatterns = {"/cordis"})
public class cordis extends HttpServlet {

     @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       
          ResultSet rs = db.getdb("select * from chronic_disease");
          
        resp.getWriter().print(JsonConvert.getJSONFromResultSet(rs, "chronic_disease"));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
        String json = "";
        if(br != null){
            json = br.readLine();
        
       
    }
        try{
             final JSONObject obj = new JSONObject(json);
   
     
      
      choronic c  = new choronic(obj.get("name").toString(),obj.get("note").toString(), obj.get("type").toString());
       c.addtodb(c);
             
       }
       catch(JSONException | SQLException e){
       resp.getWriter().print(e);
              }
       resp.getWriter().print("success");
    }
 
}
