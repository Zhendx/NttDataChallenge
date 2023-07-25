package com.nttdata.bank.account.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ErrorApp {

    private String code;
    private String message;
}
