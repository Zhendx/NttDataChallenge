package com.nttdata.bank.account.services.impl;

import com.nttdata.bank.account.repository.AccountRepository;
import com.nttdata.bank.account.util.MockUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class AccountServiceImplTest {

    @BeforeEach
    void setUp() {
    }
    @InjectMocks
    AccountServiceImpl accountService;
    @Mock
    private AccountRepository accountRep;

    @Test
    void getAllAccounts() {
        Mockito.when(accountRep.findAll())
                .thenReturn(MockUtil.buildListAccount());
        assertNotNull(accountService.getAllAccounts());
    }

    @Test
    void getById() {
        Mockito.when(accountRep.findById(Mockito.anyInt()))
                .thenReturn(Optional.of(MockUtil.buildAccount()));
        Assertions.assertNotNull(accountService.getById(1));
    }

    @Test
    void create() {
        Mockito.when(accountRep.save(Mockito.any()))
                .thenReturn(MockUtil.buildAccount());
        Assertions.assertNotNull(accountService.create(MockUtil.buildAccountReq()));
    }

    @Test
    void update() {
        Mockito.when(accountRep.save(Mockito.any()))
                .thenReturn(MockUtil.buildAccount());
        Assertions.assertNotNull(accountService.update( 1 ,MockUtil.buildAccountReq()));
    }

    @Test
    void deleteById() {
        Mockito.when(accountRep.findById(Mockito.anyInt()))
                .thenReturn(null);
    }
}