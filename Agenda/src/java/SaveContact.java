/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.mysql.jdbc.Driver;

/**
 *
 * @author aluno
 */
@WebServlet(urlPatterns = {"/SaveContact"})
public class SaveContact extends HttpServlet {

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
            out.println("<title>Servlet SaveContact</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println(request.getParameter("nome"));
            out.println("<h1>Servlet SaveContact at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
            
            String nome = request.getParameter("nome");
            String endereco = request.getParameter("endereco");
            try{
                DriverManager.registerDriver(new Driver());
                Connection mysql = DriverManager.getConnection(
                    "jdbc:mysql://localhost/agenda", 
                    "root",
                    "1q"
                    
            );
            
           String instrucao = "insert into contatos (nome, endereco) values (?, ?)";
           
                PreparedStatement ps = mysql.prepareStatement(instrucao);
                ps.setString(1, nome);
                ps.setString(2, endereco);
                //ps.setString(3, "26/10/1998");
                
                ps.execute();
                
        }catch(Exception e){
                out.println("Ocorreu um erro!");
                out.println(e.getMessage());
                
            //throw new RuntimeException(e.getMessage());
        }
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
        processRequest(request, response);
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
