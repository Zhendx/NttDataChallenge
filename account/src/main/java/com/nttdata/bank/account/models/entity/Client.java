package com.nttdata.bank.account.models.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
@Entity
@Getter
@Setter
@Table(name="client")
public class Client {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private int id;
    private String password;
    private Boolean state;
    private String name;
    private String gender;
    private int age;
    private String identification;
    private String address;
    private String phone;

}
