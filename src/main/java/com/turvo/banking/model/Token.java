package com.turvo.banking.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
 * @author Sunny
 */
@Entity
@Table(name = "token")
@Data
public class Token {

    public enum StatusCode {
        ACTIVE,
        CANCELLED,
        COMPLETED
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private int number;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "token")
    private List<TokenServiceMapping> tokenServices;

    @ManyToOne
    @JoinColumn(name = "current_counter_id")
    private Counter currentCounter;

    @ManyToOne
    @JoinColumn(name = "current_service_id")
    private Service currentService;

    @Enumerated(EnumType.STRING)
    @NotNull
    private StatusCode statusCode = StatusCode.ACTIVE;

    @NotNull
    private Date created;

}
