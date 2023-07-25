package com.nttdata.bank.account.controllers;

import com.nttdata.bank.account.services.IAccount;
import com.nttdata.bank.account.util.MockUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class AccountControllerTest {

    @BeforeEach
    void setUp() {
    }
    @InjectMocks
    AccountController accountController;
    @Mock
    private IAccount accountService;

    @Test
    void listAccounts() {
        Mockito.when(accountService.getAllAccounts())
                .thenReturn(MockUtil.buildGetAllAccountRes());
        Assertions.assertNotNull(accountController.listAccounts());
    }

    @Test
    void listAccountId() {
        Mockito.when(accountService.getById(Mockito.anyInt()))
                .thenReturn(MockUtil.buildAccountRes());
        Assertions.assertNotNull(accountController.listAccountId(1));
    }

    @Test
    void createAccount() {
        Mockito.when(accountService.create(Mockito.any()))
                .thenReturn(MockUtil.buildAccountRes());
        Assertions.assertNotNull(accountController.createAccount(MockUtil.buildAccountReq()));
    }

    @Test
    void updateAccount() {
        Mockito.when(accountService.update(Mockito.anyInt(), Mockito.any()))
                .thenReturn(MockUtil.buildAccountRes());
        Assertions.assertNotNull(accountController.updateAccount(1, MockUtil.buildAccountReq()));
    }

    @Test
    void deleteAccount() {
        Mockito.doNothing().doThrow()
                .when( this.accountService ).deleteById(Mockito.anyInt());
        Assertions.assertNotNull(accountController.deleteAccount(Mockito.anyInt()));
    }
}