package org.camunda.bpm.example.loanapproval.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import org.camunda.bpm.application.ProcessApplicationRegistration;
import org.camunda.bpm.engine.rest.impl.DefaultProcessEngineRestServiceImpl;
import org.camunda.bpm.example.loanapproval.SpringApplicationContext;


@Path("/engine")
public class CustomProcessEngineRest extends DefaultProcessEngineRestServiceImpl {

	private RegisterProcessService registerProcessService;

	@GET
	@Path("/{name}/register/{deploymentId}")
	public Response registerProcessRest(@PathParam("name") String engineName,
			@PathParam("deploymentId") String deploymentId) {
		registerProcessService = (RegisterProcessService) SpringApplicationContext.getBean("registerProcessService");
		ProcessApplicationRegistration registration = registerProcessService.registerProcessApplication(deploymentId);

		if (registration == null)
			return Response.status(500).entity("Fail").build();

		return Response.status(200).entity("Success").build();
	}
}
