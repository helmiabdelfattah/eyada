/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
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
@WebServlet(name = "editpatient", urlPatterns = {"/editpatient"})
public class editpatient extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet editpatient</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet editpatient at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("ISO-8859-1");
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
             p.facebook= obj.get("facebook").toString();
             p.meeting= obj.get("meeting").toString();
             p.company= obj.get("company").toString();
             p.title= obj.get("title").toString();
             p.age= Integer.parseInt(obj.get("age").toString());
             int id = Integer.parseInt(obj.get("patId").toString());
             response.getWriter().print("name: "+p.first);
             p.editdb(p, id);
             
       }
       catch(Exception e){
       response.getWriter().print(e);
              }
       response.getWriter().print(".....");
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
