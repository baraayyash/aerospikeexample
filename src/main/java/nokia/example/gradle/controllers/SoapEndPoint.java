package nokia.example.gradle.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import nokia.example.gradle.services.ServerService;
import nokia.example.gradle.wsdl.GetServersRequest;
import nokia.example.gradle.wsdl.GetServersResponse;
import nokia.example.gradle.wsdl.ServerSoap;

@Endpoint
public class SoapEndPoint {

	@Autowired
	ServerService serverService;
	
	@PayloadRoot(namespace="http://example.nokia/gradle/wsdl", localPart="getServersRequest")
	@ResponsePayload
	public GetServersResponse getServerResponse(@RequestPayload GetServersRequest request) {
		
		System.out.println("testLog ==================> ");
		
		GetServersResponse server = new GetServersResponse();
		ServerSoap s = new ServerSoap();
		s.setName("bara");
		server.setServer(s);
		
		return server;
		
	}
	
}
