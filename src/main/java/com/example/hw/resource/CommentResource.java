package com.example.hw.resource;

import com.example.hw.domain.Comment;
import com.example.hw.service.CommentService;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/comments")
public class CommentResource {

    @Inject
    CommentService commentService;

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response all(@PathParam("id") Integer id) {
        System.out.println("GET CALLED: Fetching all comments for post id " + id);
        return Response.ok(this.commentService.allComments(id)).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Comment create(@Valid Comment comment) {
        System.out.println("POST CALLED: Creating a new comment for post id  " + comment.getPostId());
        return this.commentService.addComment(comment);
    }
}
