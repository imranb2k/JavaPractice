package com.ibapp.service.rest.resources;

import com.ibapp.domain.Register;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

public class RestUtil {

	private static final Logger LOG = LoggerFactory.getLogger(Register.class);
	private static ObjectMapper MAPPER = new ObjectMapper();

	public static <T> T readAsObjectOf(Class<T> clazz, String value) throws Exception {
		try {
			return MAPPER.readValue(value, clazz);
		} catch (Exception e) {
			LOG.error("Error reading value as Object returning null : "+clazz.getName()+" - "+value  ,e);
			return null;
		}
	}
	
	public static Response sendInternalServerErrorResponse(){
		return Response.status(Status.INTERNAL_SERVER_ERROR).entity("Server encountered an error ").build();
	}
	
	public static Response sendSuccessResponse(){
		return Response.status(200).build();
	}
}
