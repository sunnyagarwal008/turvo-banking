package com.turvo.banking.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author Sunny
 */
@Entity
@Table(name = "customer")
@Data
public class Customer {

    public enum Type {
        PREMIUM,
        REGULAR
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    private String name;

    @NotNull
    @Column(unique = true)
    private String mobile;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Type type = Type.REGULAR;

    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;

    private Date created;
}
