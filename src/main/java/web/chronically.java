/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;

/**
 *
 * @author MuhammadECE
 */
@WebServlet(name = "chronically", urlPatterns = {"/chronically"})
public class chronically extends HttpServlet {

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
             int patient_id = Integer.parseInt(obj.get("patient_id").toString());
             int chron_id = Integer.parseInt(obj.get("chronic_id").toString());
             int month = Integer.parseInt(obj.get("month").toString());
             int year = Integer.parseInt(obj.get("year").toString());
             String s = obj.get("text").toString();
             sys.db.exedb("INSERT INTO `chronically` (`patient_patient_id`, `chronic_disease_chronic_disease_id`,`text`, `month`, `year`) VALUES ('"+patient_id+"','"+chron_id+"', '"+s+"', '"+month+"', '"+year+"');");
       }
        catch(Exception e)
        {
            response.getWriter().print(e);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
   
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    //insert into chronically values (1 , 2 , 12,2012,'hi');
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
