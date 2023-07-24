package com.nttdata.bank.client.models.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="client")
@Getter
@Setter
public class Client extends Person{
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private int id;

    private String password;
    private Boolean state;
}
