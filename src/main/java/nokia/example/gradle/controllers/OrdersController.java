package nokia.example.gradle.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aerospike.client.Key;
import com.aerospike.client.command.Buffer;

import nokia.example.gradle.models.Server;
import nokia.example.gradle.services.ServerService;


@RestController
@RequestMapping("/api/v1")
public class OrdersController {
	
	@Autowired
	ServerService serverservice;

	@GetMapping("/orders/create")
	public Integer getOrder() {
		Server server = new Server();
		
		
//		server.setId(Long.valueOf(1));
		
		Key key = new Key("servers", "demo", "10");

		System.out.println(	"---------" +	Buffer.bytesToHexString(key.digest));
		server.setKey(key);
		server.setName("test server");
		server.setRam(20);
		
		
//		serverservice.create(server);
		return 1;

	}
	
	@GetMapping("/orders")
	public List<Server> getAllServers() {
		return serverservice.getAllServers();
	}
	
}
