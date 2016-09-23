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
import org.json.JSONObject;
 
 

/**
 *
 * @author Admin
 */
@WebServlet(name = "report", urlPatterns = {"/report"})
public class report extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       
          ResultSet rs = db.getdb("select * from report");
          
        resp.getWriter().print(JsonConvert.getJSONFromResultSet(rs, "report"));
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
   
     
      
      
           
            db.exedb("insert into report values ('"+obj.get("type").toString()+"' , '"+obj.get("note").toString()+"');");
       }
       catch(Exception e){
       resp.getWriter().print(e);
              }
       resp.getWriter().print("success");
    }
 
}
