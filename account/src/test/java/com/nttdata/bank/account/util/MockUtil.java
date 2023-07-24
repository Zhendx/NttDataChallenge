package com.nttdata.bank.account.util;

import com.nttdata.bank.account.dto.AccountRequestDTO;
import com.nttdata.bank.account.dto.AccountResponseDTO;
import com.nttdata.bank.account.models.entity.Account;
import java.util.ArrayList;
import java.util.List;

public class MockUtil {
    //Services-Person
    public static List<Account> buildListAccount(){
        List<Account> listPerson = new ArrayList<>();
        listPerson.add(buildAccount());
        return listPerson;
    }
    public static Account buildAccount(){
        Account account = new Account();
        account.setId(1);
        account.setAccount_type("Ahorro");
        account.setAccount_number("281516");
        account.setOpening_balance(3205.00);
        account.setState(true);
        account.setIdclient(1);
        return account;
    }
    public static AccountRequestDTO buildAccountReq(){
        AccountRequestDTO accountReq = new AccountRequestDTO();
        accountReq.setId(1);
        accountReq.setAccount_type("Ahorro");
        accountReq.setAccount_number("281516");
        accountReq.setOpening_balance(3205.25);
        accountReq.setState(true);
        return accountReq;
    }
    //Controller-Person
    public static List<AccountResponseDTO> buildGetAllAccountRes(){
        List<AccountResponseDTO> listPerson = new ArrayList<>();
        listPerson.add(buildAccountRes());
        return listPerson;
    }
    public static AccountResponseDTO buildAccountRes(){
        AccountResponseDTO accountReq = new AccountResponseDTO();
        accountReq.setId(1);
        accountReq.setAccount_type("Ahorro");
        accountReq.setAccount_number("281516");
        accountReq.setOpening_balance(3205.00);
        accountReq.setState(true);
        return accountReq;
    }
}