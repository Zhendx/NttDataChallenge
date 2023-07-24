package com.nttdata.bank.client.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
@Getter
@Setter
public class ClientRequestDTO implements Serializable {
    private int id;
    private String password;
    private Boolean state;
    private String name;
    private String gender;
    private Integer age;
    private String identification;
    private String address;
    private String phone;
}
