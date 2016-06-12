package org.camunda.bpm.example.loanapproval;

import org.camunda.bpm.engine.RuntimeService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

public class Starter implements InitializingBean {

	@Autowired
	private RuntimeService runtimeService;

	public void afterPropertiesSet() throws Exception {
		//Nothing to start since we will be doing a Post Deployment
		//runtimeService.startProcessInstanceByKey("loanApproval");
	}

	public void setRuntimeService(RuntimeService runtimeService) {
		this.runtimeService = runtimeService;
	}
}
