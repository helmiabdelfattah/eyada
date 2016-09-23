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
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;
import sys.db;

/**
 *
 * @author MuhammadECE
 */
@WebServlet(name = "patient", urlPatterns = {"/patient"})
public class patient extends HttpServlet {

    private String first;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {ResultSet rs = db.getdb("select * from patient");
          
        response.getWriter().print(JsonConvert.getJSONFromResultSet(rs, "patient"));
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
        String json = "";
        if(br != null){
            json = br.readLine();
        
       
    }
        try{
             final JSONObject obj = new JSONObject(json);
             sys.patient p = new sys.patient();
             
             p.first = obj.get("name").toString();
             p.gender =  obj.get("sex").toString();
             p.phone = obj.get("mobile").toString();
             p.add1 =  obj.get("address").toString();
             p.note = obj.get("note").toString();
             p.email = obj.get("email").toString();
             String tmp = obj.get("year").toString();
             java.util.Date date = new SimpleDateFormat("yyyy-MM-dd").parse(tmp);
             
             p.birthday= new java.sql.Date (date.getTime());
             response.getWriter().print(p.birthday);
             p.facebook= obj.get("facebook").toString();
             p.meeting= obj.get("meeting").toString();
             p.company= obj.get("company").toString();
             p.title= obj.get("title").toString();
             p.age= Integer.parseInt(obj.get("age").toString());
             p.addtodb(p);
             
       }
       catch(Exception e){
       response.getWriter().print(e);
              }
       response.getWriter().print(".....");
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
