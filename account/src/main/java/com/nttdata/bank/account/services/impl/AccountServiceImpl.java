package com.nttdata.bank.account.services.impl;

import com.nttdata.bank.account.dto.AccountRequestDTO;
import com.nttdata.bank.account.dto.AccountResponseDTO;
import com.nttdata.bank.account.mapper.AccountMapper;
import com.nttdata.bank.account.models.entity.Account;
import com.nttdata.bank.account.repository.AccountRepository;
import com.nttdata.bank.account.services.IAccount;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements IAccount {
    private final AccountRepository accountRep;
    @Override
    public List<AccountResponseDTO> getAllAccounts(){
        //return AccountMapper.INSTANCE.listAccountToListAccountResponse(accountRep.findAll());
        return null;
    };
    @Override
    public AccountResponseDTO getById(int id){
        return AccountMapper.INSTANCE.accountToAccountResponse(accountRep.findById(id).orElseGet(null));
    };
    @Override
    public AccountResponseDTO create(AccountRequestDTO accountRequestDTO){
        Account account = accountRep.save(AccountMapper.INSTANCE.accountRequestToAccountCreate(accountRequestDTO));
        return AccountMapper.INSTANCE.accountToAccountResponse(account);
    }
    @Override
    public AccountResponseDTO update(int id, AccountRequestDTO accountRequestDTO){
        Account account = accountRep.findById(id).orElseGet(Account::new);
        account.setAccountNumber(accountRequestDTO.getAccount_number());
        account.setAccountType(accountRequestDTO.getAccount_type());
        account.setOpeningBalance(accountRequestDTO.getOpening_balance());
        account.setState(accountRequestDTO.getState());
        account.setIdclient(accountRequestDTO.getIdclient());
        return AccountMapper.INSTANCE.accountToAccountResponse(accountRep.save(account));
    }
    @Override
    public void deleteById(int id){
        accountRep.deleteById((int) id);
    }

}
