
package credentials;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import DataBaseCredentials.DatabaseConnection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author pankajtiwana
 */
@WebServlet(name = "UserCredentials", urlPatterns = {"/UserCredentials"})

public class UserCredentials extends HttpServlet {

    Connection con = null;
    Statement smt;
    ResultSet result;
    DatabaseConnection connection = new DatabaseConnection();

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
        PrintWriter out = response.getWriter();
        try {
            con = DatabaseConnection.getConnection();
        } catch (SQLException e) {
            out.close();
        } catch (ClassNotFoundException e) {
            out.close();
        } catch (InstantiationException e) {
            out.close();
        } catch (IllegalAccessException e) {
            out.close();
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

        PrintWriter out = response.getWriter();
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try {
            smt = con.createStatement();

        } catch (SQLException ex) {
            Logger.getLogger(UserCredentials.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            result = smt.executeQuery("select username from USERS where password='" + password + "'");

            while (result.next()) {
                String us = result.getString("username");

                if (us.equals(username)) {
                    out.print("succcessss");
                } else {
                    out.print("false");
                }
            }
            if (!result.next()) {
                out.write("false");
            } else {

            }

        } catch (SQLException ex) {
            out.write("ghfghfhffg");
            Logger.getLogger(UserCredentials.class.getName()).log(Level.SEVERE, null, ex);
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
