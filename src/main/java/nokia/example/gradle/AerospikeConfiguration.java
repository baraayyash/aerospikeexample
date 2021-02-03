package nokia.example.gradle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.aerospike.convert.MappingAerospikeConverter;
import org.springframework.data.aerospike.core.AerospikeExceptionTranslator;
import org.springframework.data.aerospike.core.AerospikeTemplate;
import org.springframework.data.aerospike.mapping.AerospikeMappingContext;
import org.springframework.data.aerospike.query.QueryEngine;
import org.springframework.data.aerospike.query.cache.IndexRefresher;
import org.springframework.data.aerospike.repository.config.EnableAerospikeRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.aerospike.client.AerospikeClient;
import com.aerospike.client.policy.ClientPolicy;


@Configuration
@EnableTransactionManagement
@EnableAerospikeRepositories(basePackages = "nokia.example.gradle.repositories")
public class AerospikeConfiguration {

	@Bean
	public AerospikeTemplate aerospikeTemplate(AerospikeClient aerospikeClient,
            MappingAerospikeConverter mappingAerospikeConverter,
            AerospikeMappingContext aerospikeMappingContext,
            AerospikeExceptionTranslator aerospikeExceptionTranslator,
            QueryEngine queryEngine, IndexRefresher indexRefresher) {
		
        return new AerospikeTemplate(aerospikeClient(),
        		"test",
                mappingAerospikeConverter,
                aerospikeMappingContext,
                aerospikeExceptionTranslator, queryEngine, indexRefresher);
	}

	@Bean
	public AerospikeClient aerospikeClient() {
		ClientPolicy clientPolicy = new ClientPolicy();
		clientPolicy.failIfNotConnected = true;
		
		return new AerospikeClient(clientPolicy, "172.28.128.3", 3000);
	}
}
