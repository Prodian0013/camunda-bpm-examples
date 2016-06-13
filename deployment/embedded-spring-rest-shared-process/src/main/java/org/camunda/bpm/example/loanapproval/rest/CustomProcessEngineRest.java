package org.camunda.bpm.example.loanapproval.rest;

import javax.servlet.ServletContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

import org.camunda.bpm.engine.ManagementService;
import org.camunda.bpm.engine.rest.impl.DefaultProcessEngineRestServiceImpl;
import org.camunda.bpm.engine.spring.application.SpringServletProcessApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

@Path("/engine")
public class RegisterProcess extends DefaultProcessEngineRestServiceImpl {

	private ManagementService managementService;
	private SpringServletProcessApplication processApplication;	

	@GET
	@Path("/{name}/register/{deploymentId}")
	public Response registerProcessRest(@Context ServletContext servletContext, @PathParam("name") String engineName,
			@PathParam("deploymentId") String deploymentId) {

		ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(servletContext);

		processApplication = ctx.getBean("processApplication", SpringServletProcessApplication.class);
		managementService = ctx.getBean("managementService", ManagementService.class);

		managementService.registerProcessApplication(deploymentId, processApplication.getReference());

		return Response.status(200).entity("ok").build();
	}
}
