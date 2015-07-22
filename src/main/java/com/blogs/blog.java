/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blogs;

import java.math.BigDecimal;
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
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;

/**
 * REST Web Service
 *
 * @author pankajtiwana
 */
@Stateful
@Path("blog")
public class blog {
    JsonArrayBuilder array=Json.createArrayBuilder();

    
    /**
     * Creates a new instance of blog
     */
    public blog() {
    }

    /**
     * Retrieves representation of an instance of com.blogs.blog
     * @return an instance of java.lang.String
     */
    @Path("/globalblogs")
    @GET
    @Produces("application/json")
    public String getJson(@Context HttpServletRequest request) {
        //TODO return proper representation object
        HttpSession session=request.getSession();
        String user=(String) session.getAttribute("username");
       JsonObjectBuilder build=Json.createObjectBuilder().add("myname", "pankaj")
                                                         .add("username", user);
       array.add(build);
       String myname=array.build().toString();
       return myname;
    }

    /**
     * PUT method for updating or creating an instance of blog
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
    }
}
