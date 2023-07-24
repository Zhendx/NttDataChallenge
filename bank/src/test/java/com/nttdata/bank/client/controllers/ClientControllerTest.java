package com.nttdata.bank.client.controllers;

import com.nttdata.bank.client.services.IClient;
import com.nttdata.bank.client.util.MockUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ClientControllerTest {

    @BeforeEach
    void setUp() {
    }
    @InjectMocks
    ClientController clientController;
    @Mock
    private IClient clientService;

    @Test
    void listClients() {
        Mockito.when(clientService.getAllClients())
                .thenReturn(MockUtil.buildGetAllClientRes());
        Assertions.assertNotNull(clientController.listClients());
    }

    @Test
    void listClientId() {
        Mockito.when(clientService.getById(Mockito.anyInt()))
                .thenReturn(MockUtil.buildClientRes());
        Assertions.assertNotNull(clientController.listClientId(1));
    }

    @Test
    void createClient() {
        Mockito.when(clientService.create(Mockito.any()))
                .thenReturn(MockUtil.buildClientRes());
        Assertions.assertNotNull(clientController.createClient(MockUtil.buildClientReq()));
    }

    @Test
    void updateClient() {
        Mockito.when(clientService.update(Mockito.anyInt(), Mockito.any()))
                .thenReturn(MockUtil.buildClientRes());
        Assertions.assertNotNull(clientController.updateClient(1, MockUtil.buildClientReq()));
    }

    @Test
    void deleteClient() {
        Mockito.doNothing().doThrow()
                .when( this.clientService ).deleteById(Mockito.anyInt());
        Assertions.assertNotNull(clientController.deleteClient(Mockito.anyInt()));
    }
}