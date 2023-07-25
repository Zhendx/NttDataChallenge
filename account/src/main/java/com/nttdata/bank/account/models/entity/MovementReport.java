package com.nttdata.bank.account.models.entity;

import lombok.*;

import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
public class MovementReport {
    private Date date;
    private String name;
    private String accountType;
    private String accountNumber;
    private String typeMovement;
    private Double balance;
    private Boolean state;
    private Double value;

}
