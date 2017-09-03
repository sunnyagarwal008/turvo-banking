package com.abc.banking.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * @author Sunny
 */
@Entity
@Table(name = "token_service_mapping")
@Data
public class TokenServiceMapping {

    public TokenServiceMapping() {
    }

    public TokenServiceMapping(Token token, Service service) {
        this.service = service;
        this.token = token;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "service_id")
    private Service service;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "token_id")
    private Token token;

    private String comments;
}
