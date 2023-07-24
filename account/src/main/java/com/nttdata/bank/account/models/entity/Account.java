package com.nttdata.bank.account.models.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="account")
@Getter
@Setter
public class Account {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private int id;

    private String account_number;
    private String account_type;
    private Double opening_balance;
    private Boolean state;
    private int idclient;
}
