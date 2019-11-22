package com.spring.hateos.repositories;

import com.spring.hateos.domain.Capability;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CapabilityRepository extends JpaRepository<Capability, Long> {
}
