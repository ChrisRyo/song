package tw.com.jersey.mapper;

import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import tw.com.view.message.ReturnMessage;

/**
 * ConstraintViolationException mapping
 * @author zach.han
 *
 */
@Provider
public class ConstraintViolationsExceptionMapper implements ExceptionMapper<ConstraintViolationException> {

	public Response toResponse(ConstraintViolationException ex) {
		return Response.status(400).entity(new ReturnMessage (ex)
				).type(MediaType.APPLICATION_JSON).build();
	}

}
