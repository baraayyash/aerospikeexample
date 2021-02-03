package nokia.example.gradle.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nokia.example.gradle.models.Server;
import nokia.example.gradle.repositories.ServerRepository;

@Service
public class ServerService {

	@Autowired
	ServerRepository serverRepository;
	
	public Server create(Server server) {
		
//		System.out.println(" -----------------> " + server.getId());
		
		return serverRepository.save(server);
	}
	
	public List<Server> getAllServers() {
		List<Server> servers = new ArrayList<>();
		serverRepository.findAll().forEach(servers::add);
		return servers;
	}
	
}
