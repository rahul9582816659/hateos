package com.spring.hateos.endpoint;

import com.spring.hateos.domain.Capability;
import com.spring.hateos.service.CapabilityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/dashboard")
public class CapabilityApi {

    private CapabilityService capabilityService;

    public CapabilityApi(CapabilityService capabilityService) {
        this.capabilityService = capabilityService;
    }

    @GetMapping
    public List<Capability> getAllCapabilities(){
        return capabilityService.getAllCapabilities();
    }

    @GetMapping("/{id}")
    public Capability getCapability(@PathVariable Long id){
        return capabilityService.findCapabilityById(id);
    }

    @PostMapping
    public Object createCapability(@RequestBody Capability capability, BindingResult result) {
        if(result.hasErrors()) return capabilityService.errorMap(result);
        return capabilityService.saveCapability(capability);
    }

    @PutMapping("/{id}")
    public Object updateCapability(@PathVariable Long id, @Valid @RequestBody Capability capability, BindingResult result) {
        if(result.hasErrors()) return capabilityService.errorMap(result);
        return capabilityService.updateCapability(id,capability);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCapability(@PathVariable Long id) {
        capabilityService.deleteCapability(id);
        return new ResponseEntity<String>("Capability Deleted", HttpStatus.OK);
    }
}
