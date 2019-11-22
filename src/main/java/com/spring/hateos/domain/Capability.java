package com.spring.hateos.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
public class Capability {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String techStack;
    private Integer noOfDevelopers;
    private Integer noOfAvailableDevelopers;

    public Capability(String techStack, Integer noOfDevelopers, Integer noOfAvailableDevelopers) {
        this.techStack = techStack;
        this.noOfDevelopers = noOfDevelopers;
        this.noOfAvailableDevelopers = noOfAvailableDevelopers;
    }
}
