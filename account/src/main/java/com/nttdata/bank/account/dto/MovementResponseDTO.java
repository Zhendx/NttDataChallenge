package com.nttdata.bank.account.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
public class MovementResponseDTO {
    private int id;
    private Date date;
    private String typeMovement;
    private Double balance;
    private Double value;
    private int idclient;
}
