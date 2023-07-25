package com.nttdata.bank.account.util;

import com.nttdata.bank.account.dto.AccountRequestDTO;
import com.nttdata.bank.account.dto.AccountResponseDTO;
import com.nttdata.bank.account.dto.MovementRequestDTO;
import com.nttdata.bank.account.dto.MovementResponseDTO;
import com.nttdata.bank.account.models.entity.Account;
import com.nttdata.bank.account.models.entity.Movement;
import com.nttdata.bank.account.models.entity.MovementReport;
import com.nttdata.bank.account.models.entity.MovementReportValue;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MockUtil {
    //Services-Account
    public static List<Account> buildListAccount(){
        List<Account> listPerson = new ArrayList<>();
        listPerson.add(buildAccount());
        return listPerson;
    }
    public static Account buildAccount(){
        Account account = new Account();
        account.setId(1);
        account.setAccountType("Ahorro");
        account.setAccountNumber("281516");
        account.setOpeningBalance(3205.00);
        account.setState(true);
        account.setIdclient(1);
        return account;
    }
    public static AccountRequestDTO buildAccountReq(){
        AccountRequestDTO accountReq = new AccountRequestDTO();
        accountReq.setId(1);
        accountReq.setAccountType("Ahorro");
        accountReq.setAccountNumber("281516");
        accountReq.setOpeningBalance(3205.25);
        accountReq.setState(true);
        return accountReq;
    }
    //Controller-Account
    public static List<AccountResponseDTO> buildGetAllAccountRes(){
        List<AccountResponseDTO> listPerson = new ArrayList<>();
        listPerson.add(buildAccountRes());
        return listPerson;
    }
    public static AccountResponseDTO buildAccountRes(){
        AccountResponseDTO accountRes = new AccountResponseDTO();
        accountRes.setId(1);
        accountRes.setAccountType("Ahorro");
        accountRes.setAccountNumber("281516");
        accountRes.setOpeningBalance(3205.00);
        accountRes.setState(true);
        return accountRes;
    }
    //////////////////////////////////////////////////////////////////////
    //Services-Movement
    public static List<Movement> buildListMovement(){
        List<Movement> listMovement = new ArrayList<>();
        listMovement.add(buildMovement());
        return listMovement;
    }
    public static Movement buildMovement(){
        var date = new Date();
        Movement movement = new Movement();
        movement.setId(1);
        movement.setDate(date);
        movement.setBalance(2000.0);
        movement.setTypeMovement("Ahorro");
        movement.setValue(20.0);
        movement.setIdclient(1);
        return movement;
    }
    public static MovementRequestDTO buildMovementReq(){
        var date = new Date();
        MovementRequestDTO movementReq = new MovementRequestDTO();
        movementReq.setId(1);
        movementReq.setDate(date);
        movementReq.setBalance(2000.0);
        movementReq.setTypeMovement("Ahorro");
        movementReq.setValue(20.0);
        movementReq.setIdclient(1);
        return movementReq;
    }
    //Controller-Account
    public static List<MovementResponseDTO> buildGetAllMovementRes(){
        List<MovementResponseDTO> listMovement = new ArrayList<>();
        listMovement.add(buildMovementRes());
        return listMovement;
    }
    public static MovementResponseDTO buildMovementRes(){
        var date = new Date();
        MovementResponseDTO movementRes = new MovementResponseDTO();
        movementRes.setId(1);
        movementRes.setDate(date);
        movementRes.setBalance(2000.0);
        movementRes.setTypeMovement("Ahorro");
        movementRes.setValue(20.0);
        movementRes.setIdclient(1);
        return movementRes;
    }
}
