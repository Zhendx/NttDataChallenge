package com.nttdata.bank.account.mapper;

import com.nttdata.bank.account.dto.AccountRequestDTO;
import com.nttdata.bank.account.dto.AccountResponseDTO;
import com.nttdata.bank.account.models.entity.Account;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
@Mapper(componentModel = "spring")
public interface AccountMapper {
    AccountMapper INSTANCE = Mappers.getMapper(AccountMapper.class);
    Account accountRequestToAccountCreate(AccountRequestDTO accountRequestDTO);
    AccountResponseDTO accountToAccountResponse(Account account);
    List<AccountResponseDTO> listAccountToListAccountResponse(List<Account> account);
}
