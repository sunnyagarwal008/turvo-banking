package com.turvo.banking.model;

import lombok.Data;

import javax.persistence.*;

/**
 * @author Sunny
 */
@Entity
@Table(name = "counter")
@Data
public class Counter {

    public enum Priority {
        HIGH,
        NORMAL
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(unique = true)
    private int number;

    @Enumerated(EnumType.STRING)
    private Priority priority;

    @Column(name = "queue_size")
    private int queueSize;
}
