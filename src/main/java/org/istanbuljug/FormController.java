package org.istanbuljug;

import javax.inject.Inject;
import javax.mvc.Models;
import javax.mvc.annotation.Controller;
import javax.mvc.binding.BindingResult;
import javax.mvc.engine.ViewEngineContext;
import javax.mvc.validation.ValidationResult;
import javax.validation.*;
import javax.validation.executable.ExecutableType;
import javax.validation.executable.ValidateOnExecution;
import javax.ws.rs.*;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static javax.ws.rs.core.Response.Status.OK;

/**
 * Created by usta on 02.08.2015.
 */
@Controller
@Path("/")
public class FormController {

    @Inject
    private Models models;

    @Inject
    private ValidationResult validationResult;

//    @Inject
//    private BindingResult bindingResult;

    @GET
    public String home() {
        return "index.xhtml";
    }

    @POST
    @Path("/postdata")
    public Response postData(@Valid @BeanParam PersonBean personBean) {

        return Response.status(OK).entity("redirect:/").build();
    }
}
