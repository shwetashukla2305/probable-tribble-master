package com.glo.simActivation.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class SimDetails {

    @Id
    private int simId;
    @Size(min = 10, max = 10)
    private long serviceNumber;
    @Size(min = 13, max = 13)
    private long simNumber;
    private String simStatus;
}
