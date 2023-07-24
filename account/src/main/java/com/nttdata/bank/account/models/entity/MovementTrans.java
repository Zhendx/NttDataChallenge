package com.nttdata.bank.account.models.entity;


import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class MovementTrans {
    private String account_number;
    private String account_type;
    private Double balance;
    private Double value;
    private Boolean state;
    private String type_movement;
    private Date date;
}
