package com.turvo.banking.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author Sunny
 */
@Entity
@Table(name = "service")
@Data
public class Service {

    public enum Type {
        PREMIUM,
        REGULAR
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @Column(unique = true)
    private String name;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Type type;

    @Column(name = "next_service_id")
    private Long nextServiceId;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "service_counter_mapping", joinColumns = @JoinColumn(name = "service_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "counter_id", referencedColumnName = "id"))
    private List<Counter> counters;

}
