package com.rest.modelassempler;

import com.rest.controller.SubscriptionController;
import com.rest.controller.UserController;
import com.rest.dto.dto.SubscriptionResponseDto;
import com.rest.dto.dto.UserResponseDto;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.SimpleRepresentationModelAssembler;
import org.springframework.stereotype.Component;

import java.util.Objects;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class SubscriptionAssembler implements SimpleRepresentationModelAssembler<SubscriptionResponseDto> {
    @Override
    public void addLinks(EntityModel<SubscriptionResponseDto> resource) {
        Long userId = Objects.requireNonNull(resource.getContent()).getId();
        resource.add(linkTo(methodOn(SubscriptionController.class).getSubscription(userId)).withSelfRel());
    }

    @Override
    public void addLinks(CollectionModel<EntityModel<SubscriptionResponseDto>> resources) {
        resources.add(linkTo(methodOn(SubscriptionController.class).getAllSubscription()).withSelfRel());
    }
}
