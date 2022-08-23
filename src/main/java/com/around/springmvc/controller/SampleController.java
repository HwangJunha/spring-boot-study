package com.around.springmvc.controller;

import com.around.springmvc.exception.AppError;
import com.around.springmvc.exception.SampleException;
import com.around.springmvc.model.vo.Sample;
import org.springframework.hateoas.Link;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.hateoas.EntityModel;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


@Controller
public class SampleController {

    @GetMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("name", "junha");
        return "hello";
    }


    @GetMapping("/exception")
    public String exception(){
            throw new SampleException();
    }

    @GetMapping("/hateoas")
    public ResponseEntity<EntityModel<Sample>> hateoas(){
        Sample sample = new Sample();
        sample.setName("junha");
        sample.setPerfix("Hey,");
        return ResponseEntity.ok().body(EntityModel.of(sample).add(linkTo(methodOn(SampleController.class).hateoas()).withSelfRel()));
    }

    @ExceptionHandler(SampleException.class)
    public @ResponseBody AppError sampleError(SampleException e){
        AppError appError = new AppError();
        appError.setMessage("error.app.key");
        appError.setReason("IDK IDK IDK");
        return appError;
    }
}
