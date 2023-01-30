package com.javaservlet.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/product")
public class ProductService {
    public ProductService() {
        super();
    }
    @Path("/{code}")
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public String getDetail(@PathParam("code") String code) {
        int productCode = 0;
        try {
            productCode = Integer.parseInt(code);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String name = "May bay";
        return "{" + "'name':'" + name+"'" + "'code':'" + code + "'}";
    }
}
