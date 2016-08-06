/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import JdbcManagment.JsonConvert;
import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sys.db;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.sql.ResultSet;
import org.json.JSONArray;
import org.json.JSONObject;
import sys.eye_dis;
 
 

/**
 *
 * @author Admin
 */
@WebServlet(name = "eyedis", urlPatterns = {"/eyedis"})
public class eyedis extends HttpServlet {

     @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String sql ="select * from eye_diseases";
       try {if(req.getParameter("req").equals("cat")) 
           sql = "SELECT distinct cat FROM mydb.eye_diseases;";}
       catch(Exception e){}
          ResultSet rs = db.getdb(sql);
          
        resp.getWriter().print(JsonConvert.getJSONFromResultSet(rs, "eye_diseases"));
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
   
     
      
      eye_dis e = new eye_dis(obj.get("name").toString(),obj.get("category").toString().toString(), obj.get("note").toString());
       e.addtodb(e);
             
       }
       catch(Exception e){
       resp.getWriter().print(e);
              }
       resp.getWriter().print("success");
    }
 
}
