package com.nttdata.bank.client.models.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@MappedSuperclass
@Table(name="person")
@Getter
@Setter
public class Person {

    private String name;
    private String gender;
    private Integer age;
    private String identification;
    private String address;
    private String phone;

}
