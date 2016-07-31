/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sys.db;

/**
 *
 * @author Admin
 */
@WebServlet(name = "cure", urlPatterns = {"/cure"})
public class cure extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       resp.getWriter().print("hello cure");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       try{
        sys.cure x = new sys.cure();
            x.setName(req.getParameter("name"));
              
            System.out.println(req.getParameter("name"));
            x.setId((db.getmaxcureid() + 1));
            x.setCategory(req.getParameter("category"));
            x.setFormate(req.getParameter("formate"));

            x.addtodb(x);
       }
       catch(Exception e){
       resp.getWriter().print("failed");
              }
       resp.getWriter().print("success");
    }
 
}
