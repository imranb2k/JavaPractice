package com.ibapp.service.rest.resources;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by imran on 24/04/15.
 */

@Path("/status")
@Component
public class StatusResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response status() {

        StatusInfo statusInfo = new StatusInfo("Checking Service", StatusInfo.ServiceStatus.GREEN);

        return Response.ok(statusInfo).build();

    }


    public static class StatusInfo {

        public enum ServiceStatus {GREEN, RED}

        private String serviceName;
        private ServiceStatus status;

        public String getServiceName() {
            return serviceName;
        }

        public ServiceStatus getStatus() {
            return status;
        }

        @JsonCreator
        public StatusInfo (@JsonProperty("serviceName") String serviceN, @JsonProperty("serviceStatus") ServiceStatus serviceStatus) {

            this.serviceName = serviceN;
            this.status = serviceStatus;

        }

    }
}
