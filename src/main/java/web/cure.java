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
@WebServlet(name = "cure", urlPatterns = {"/cure"})
public class cure extends HttpServlet {
     @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       
      String sql = "SELECT distinct describtion , catregory FROM mydb.cure;";
       try { if (req.getParameter("req").equals("cat")){
        sql = "SELECT distinct catregory FROM mydb.cure;";
        }
       else if(req.getParameter("req").equals("format")){ sql = "select * from cure";}}
       catch(Exception e){}
          ResultSet rs = db.getdb(sql);
          
        resp.getWriter().print(JsonConvert.getJSONFromResultSet(rs, "cure"));
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
   
     
      
        sys.cure x = new sys.cure();
            x.setName(obj.get("name").toString());
              
            x.setId((db.getmaxcureid() + 1));
            x.setCategory(obj.get("category").toString());
            x.setFormate(obj.get("formate").toString());

            x.addtodb(x);
       }
       catch(Exception e){
       resp.getWriter().print(e);
              }
       resp.getWriter().print("success");
    }
 
}
