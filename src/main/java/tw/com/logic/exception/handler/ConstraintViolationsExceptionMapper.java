package tw.com.logic.exception.handler;

import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import tw.com.logic.exception.ErrorMessage;

@Provider
public class ConstraintViolationsExceptionMapper implements
    ExceptionMapper<ConstraintViolationException> {

  public Response toResponse(ConstraintViolationException ex) {
    // TODO: use ServerProperties.BV_SEND_ERROR_IN_RESPONSE
    return Response.status(500).entity(new ErrorMessage(ex)).type(MediaType.APPLICATION_JSON)
        .build();
  }

}
