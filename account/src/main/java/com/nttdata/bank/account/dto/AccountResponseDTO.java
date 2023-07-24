package com.nttdata.bank.account.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
@Getter
@Setter
public class AccountResponseDTO implements Serializable {
    private int id;

    private String account_number;
    private String account_type;
    private Double opening_balance;
    private Boolean state;
    private int idclient;
}
