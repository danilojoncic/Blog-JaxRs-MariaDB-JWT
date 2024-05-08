package com.example.hw;

import com.example.hw.repository.comment.CommentRepository;
import com.example.hw.repository.comment.CommentRepositoryInterface;
import com.example.hw.repository.post.PostRepository;
import com.example.hw.repository.post.PostRepositoryInterface;
import com.example.hw.repository.user.UserRepository;
import com.example.hw.repository.user.UserRepositoryInterface;
import com.example.hw.service.CommentService;
import com.example.hw.service.PostService;
import com.example.hw.service.UserService;
import org.glassfish.jersey.internal.inject.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;

import javax.inject.Singleton;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/api")
public class HelloApplication extends ResourceConfig {

    public HelloApplication() {
        property(ServerProperties.BV_SEND_ERROR_IN_RESPONSE, true);
        AbstractBinder binder = new AbstractBinder() {
            @Override
            protected void configure() {
                this.bind(CommentRepository.class).to(CommentRepositoryInterface.class).in(Singleton.class);
                this.bindAsContract(CommentService.class);

                this.bind(PostRepository.class).to(PostRepositoryInterface.class).in(Singleton.class);
                this.bindAsContract(PostService.class);

                this.bind(UserRepository.class).to(UserRepositoryInterface.class).in(Singleton.class);
                this.bindAsContract(UserService.class);
            }
        };
        register(binder);
        packages("com/example/hw/resource");
    }
}