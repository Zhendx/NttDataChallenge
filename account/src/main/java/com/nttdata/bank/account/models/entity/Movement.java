package com.nttdata.bank.account.models.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name="movement")
@Getter
@Setter
public class Movement {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private int id;

    @Temporal(TemporalType.DATE)
    private Date date;
    private String typeMovement;
    private Double balance;
    private Double value;
    private int idclient;
}
