package nokia.example.gradle.repositories;

import org.springframework.data.aerospike.repository.AerospikeRepository;
import org.springframework.stereotype.Repository;

import nokia.example.gradle.models.Server;

@Repository
public interface ServerRepository extends AerospikeRepository<Server, Integer> {

}
