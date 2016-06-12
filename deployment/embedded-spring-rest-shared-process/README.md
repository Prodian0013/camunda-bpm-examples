Based off embedded-spring-rest with a few minor changes.

-Uses shared process engine

-Shows how to extend the rest api using the RegisterProcessApplication after a Post Deployment

How to use it?

1. Build it with Maven
2. Deploy war to Tomcat Prepacked Distrubution
3. Test the rest http://localhost:8080/spring-rest/engine/default/process-definition
4. Deploy bpmn via Post Deploment
5. Go to Tasklist select "Start Process", select "Loan Approval", select "Start" - This should result in an error "Cannot instantiate process definition loanApproval:1:c0f782cb-30bc-11e6-ba7b-50465d7049f3: Unknown property used in expression: ${calculateInterestService}. Cause: Cannot resolve identifier 'calculateInterestService'"
6. RegisterProcessApplication using http://localhost:8080/spring-rest/engine/default/register/{deploymentId}
7. Repeat #5 to see the issue resolved! Console/Log will say "Spring Bean invoked."


