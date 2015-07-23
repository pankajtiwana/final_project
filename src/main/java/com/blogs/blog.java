/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blogs;

import DataBaseCredentials.DatabaseConnection;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateful;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;

/**
 * REST Web Service
 *
 * @author pankajtiwana
 */
@Stateful
@Path("blog")
public class blog {

    Connection con = null;
    int count = 0;
    Statement smt;
    ResultSet rst;
    int a1;
    String imagepath;

    JsonArrayBuilder array = Json.createArrayBuilder();

    /**
     * Creates a new instance of blog
     *
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     * @throws java.lang.InstantiationException
     * @throws java.lang.IllegalAccessException
     */
    public blog() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        con = DatabaseConnection.getConnection();
    }

    /**
     * Retrieves representation of an instance of com.blogs.blog
     *
     * @param request
     * @return an instance of java.lang.String
     */
    @Path("/globalblogs")
    @GET
    @Produces("application/json")
    public String getJson(@Context HttpServletRequest request) {
        try{
          
            con = DatabaseConnection.getConnection();
            //TODO return proper representation object
            HttpSession session = request.getSession();
            String user = (String) session.getAttribute("username");
           String imagequery = "SELECT image_id from IMAGES where username='"+user+"'";
//
         smt = con.createStatement();
         rst = smt.executeQuery(imagequery);

            while (rst.next()) {
                count++;

                InputStream stream = rst.getBinaryStream(1);
                ByteArrayOutputStream output = new ByteArrayOutputStream();

                try {
                    a1 = stream.read();
                } catch (IOException ex) {
                        return "1mot working";
                }
                while (a1 >= 0) {
                    output.write((char) a1);
                    try {
                        a1 = stream.read();
                    } catch (IOException ex) {
                        return "2lot working";
                    }
                }
                Image myImage = Toolkit.getDefaultToolkit().createImage(output.toByteArray());
            }
            if (count == 0) {
                imagepath="images/icon.png";
                JsonObjectBuilder build = Json.createObjectBuilder().add("image", imagepath);
                    
            array.add(build);
            String img = array.build().toString();
                return img; 
            
            }
//            JsonObjectBuilder build = Json.createObjectBuilder().add("myname", "pankaj")
//                    .add("username", user);
//            array.add(build);
//            String myname = array.build().toString();

        } catch (SQLException ex) {
                        return "Exception in sql";
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(blog.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(blog.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(blog.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "did not work";
    }

    /**
     * PUT method for updating or creating an instance of blog
     *
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */

    /**
     * PUT method for updating or creating an instance of blog
     * @param filepath
     * @param contentDispositionHeader
     * @param fileInputStream
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    
    @Path("/adduser")
    @POST

    

    @Consumes(MediaType.MULTIPART_FORM_DATA)

    public String adduser( @FormDataParam("image") InputStream fileInputStream,

            @FormDataParam("image") FormDataContentDisposition contentDispositionHeader) {

 String file="";

        file =  contentDispositionHeader.getFileName();

 

        // save the file to the server

        //saveFile(fileInputStream, filePath);

 

       // String output = "File saved to server location : " + filePath;


        return file;
    }

    
    
    
    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
    }
}
