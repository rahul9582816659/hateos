package com.spring.hateos.service;

import com.spring.hateos.domain.Capability;
import com.spring.hateos.exception.CapabilityException;
import com.spring.hateos.repositories.CapabilityRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CapabilityService {

    private CapabilityRepository capabilityRepository;

    public CapabilityService(CapabilityRepository capabilityRepository) {
        this.capabilityRepository = capabilityRepository;
    }

    public List<Capability> getAllCapabilities() {
        return capabilityRepository.findAll();
    }

    public Capability findCapabilityById(Long id) {
        return capabilityRepository.findById(id).orElseThrow(() -> new CapabilityException("Capability with ID: " + id + " Not Found")
        );
    }

    public Capability saveCapability(Capability capability) {
        return capabilityRepository.save(capability);
    }

    public ResponseEntity<?> errorMap(BindingResult result) {
        Map<String, String> errorMap = new HashMap<>();
        for (FieldError error : result.getFieldErrors()) {
            errorMap.put(error.getField(), error.getDefaultMessage());
        }
        return new ResponseEntity<>(errorMap, HttpStatus.BAD_REQUEST);
    }

    public Capability updateCapability(Long id, Capability capability) {
        return capabilityRepository.findById(id).map(cap -> {
            cap.setTechStack(capability.getTechStack());
            cap.setNoOfDevelopers(capability.getNoOfDevelopers());
            cap.setNoOfAvailableDevelopers(capability.getNoOfAvailableDevelopers());
            return capabilityRepository.save(cap);
        }).orElseGet(() -> {
            return capabilityRepository.save(capability);
        });

    }
    public void deleteCapability(Long id) {
        capabilityRepository.delete(
                capabilityRepository.findById(id)
                        .orElseThrow(() -> new CapabilityException("Capability with ID: "+id+" Not found")
                        ));

    }
}
