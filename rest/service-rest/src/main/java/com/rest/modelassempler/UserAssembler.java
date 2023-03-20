package com.rest.modelassempler;

import com.rest.controller.UserController;
import com.rest.dto.dto.UserResponseDto;
import com.rest.dto.model.User;
import org.hibernate.annotations.Comment;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.SimpleRepresentationModelAssembler;
import org.springframework.stereotype.Component;

import java.util.Objects;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class UserAssembler implements SimpleRepresentationModelAssembler<UserResponseDto> {
    @Override
    public void addLinks(EntityModel<UserResponseDto> resource) {
        Long userId = Objects.requireNonNull(resource.getContent()).getId();
        resource.add(linkTo(methodOn(UserController.class).getUser(userId)).withSelfRel());
    }

    @Override
    public void addLinks(CollectionModel<EntityModel<UserResponseDto>> resources) {
        resources.add(linkTo(methodOn(UserController.class).getAllUsers()).withSelfRel());
    }
}
