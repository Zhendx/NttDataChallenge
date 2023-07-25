package com.nttdata.bank.account.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
@Getter
@Setter
public class AccountRequestDTO implements Serializable {
    private int id;

    private String accountNumber;
    private String accountType;
    private Double openingBalance;
    private Boolean state;
    private int idclient;
}
