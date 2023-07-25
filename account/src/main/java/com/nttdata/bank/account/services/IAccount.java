package com.nttdata.bank.account.services;

import com.nttdata.bank.account.dto.AccountRequestDTO;
import com.nttdata.bank.account.dto.AccountResponseDTO;
import org.mapstruct.factory.Mappers;

import java.util.List;

public interface IAccount {
    List<AccountResponseDTO> getAllAccounts();
    AccountResponseDTO getById(int id);
    AccountResponseDTO create(AccountRequestDTO accountRequestDTO);
    AccountResponseDTO update(int id, AccountRequestDTO accountRequestDTO);
    void deleteById(int id);
}
