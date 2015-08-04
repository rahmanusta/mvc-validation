package org.istanbuljug;

import javax.inject.Inject;
import javax.mvc.Models;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by usta on 03.08.2015.
 */
@Provider
public class ValidationMapper implements ExceptionMapper<ConstraintViolationException> {

    @Inject
    private Models models;

    @Override
    public Response toResponse(ConstraintViolationException exception) {
        Set<ConstraintViolation<?>> allViolations = exception.getConstraintViolations();

        Map<String, String> errorMap = new HashMap<>();

        for (ConstraintViolation<?> violation : allViolations) {
            javax.validation.Path propertyPath = violation.getPropertyPath();
            String message = violation.getMessage();
            errorMap.put(propertyPath.toString(), message);
        }

        models.put("error", errorMap);

        return Response.status(Response.Status.BAD_REQUEST).build();
    }
}
