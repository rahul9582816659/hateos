package com.spring.hateos.data;

import com.spring.hateos.domain.Capability;
import com.spring.hateos.repositories.CapabilityRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InitialDataLoad {

    @Bean
    CommandLineRunner loadDb(CapabilityRepository capabilityRepository) {
        return args -> {
            capabilityRepository.save(new Capability("Angular", 100, 50));
            capabilityRepository.save(new Capability("Java", 70, 20));
            capabilityRepository.save(new Capability("H2", 200, 100));
        };
    }
}
