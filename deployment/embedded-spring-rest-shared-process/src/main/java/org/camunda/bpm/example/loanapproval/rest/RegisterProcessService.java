package org.camunda.bpm.example.loanapproval.rest;

import org.camunda.bpm.application.ProcessApplicationRegistration;
import org.camunda.bpm.engine.ManagementService;
import org.camunda.bpm.engine.spring.application.SpringServletProcessApplication;
import org.camunda.bpm.example.loanapproval.SpringApplicationContext;

public class RegisterProcessService {	
	
	private ManagementService managementService;
	private SpringServletProcessApplication processApplication;
	
	public ProcessApplicationRegistration registerProcessApplication(String deploymentId){		
			processApplication = (SpringServletProcessApplication) SpringApplicationContext.getBean("processApplication");
			managementService = (ManagementService) SpringApplicationContext.getBean("managementService");				
			return managementService.registerProcessApplication(deploymentId, processApplication.getReference());
	}
}
