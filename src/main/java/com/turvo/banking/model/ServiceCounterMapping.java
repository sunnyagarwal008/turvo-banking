package com.turvo.banking.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * @author Sunny
 */
@Entity
@Table(name = "service_counter_mapping")
@Data
public class ServiceCounterMapping {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "service_id")
    private Service service;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "counter_id")
    private Counter counter;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Customer.Type type;
}
