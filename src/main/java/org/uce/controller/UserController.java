package org.uce.controller;

import org.uce.entity.User;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/api/users")
@Produces(MediaType.APPLICATION_JSON)
public class UserController {

    @GET
    public List<User> getAllUsers() {
        return User.listAll();
    }

    @GET
    @Path("/{id}")
    public Response getUserById(@PathParam("id") Long id) {
        User user = User.findById(id);
        if (user == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("Usuario no encontrado").build();
        }
        return Response.ok(user).build();
    }

    @GET
    @Path("/search")
    public Response searchUser(@QueryParam("email") String email, @QueryParam("username") String username) {
        if (email != null && !email.isEmpty()) {
            User user = User.find("email", email).firstResult();
            if (user == null) {
                return Response.status(Response.Status.NOT_FOUND).entity("Usuario no encontrado").build();
            }
            return Response.ok(user).build();
        }
        if (username != null && !username.isEmpty()) {
            User user = User.find("username", username).firstResult();
            if (user == null) {
                return Response.status(Response.Status.NOT_FOUND).entity("Usuario no encontrado").build();
            }
            return Response.ok(user).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).entity("Debe proporcionar email o username").build();
    }
}
