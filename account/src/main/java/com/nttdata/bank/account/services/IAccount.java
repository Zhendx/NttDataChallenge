package com.nttdata.bank.account.services;

import com.nttdata.bank.account.dto.AccountRequestDTO;
import com.nttdata.bank.account.dto.AccountResponseDTO;
import org.mapstruct.factory.Mappers;

import java.util.List;

public interface IAccount {
    IAccount INSTANCE = Mappers.getMapper(IAccount.class);
    List<AccountResponseDTO> getAllAccounts();
    AccountResponseDTO getById(int id);
    AccountResponseDTO create(AccountRequestDTO personRequestDTO);
    AccountResponseDTO update(int id, AccountRequestDTO personRequestDTO);
    void deleteById(int id);
}
