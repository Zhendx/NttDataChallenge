package com.nttdata.bank.client.services.impl;

import com.nttdata.bank.client.repository.ClientRepository;
import com.nttdata.bank.client.util.MockUtil;
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
class ClientServiceImplTest {

    @BeforeEach
    void setUp() {
    }
    @InjectMocks
    ClientServiceImpl clientService;
    @Mock
    private ClientRepository clientRep;

    @Test
    void getAllClients() {
        Mockito.when(clientRep.findAll())
                .thenReturn(MockUtil.buildListClient());
        assertNotNull(clientService.getAllClients());
    }

    @Test
    void getById() {
        Mockito.when(clientRep.findById(Mockito.anyInt()))
                .thenReturn(Optional.of(MockUtil.buildClient()));
        Assertions.assertNotNull(clientService.getById(1));
    }

    @Test
    void create() {
        Mockito.when(clientRep.save(Mockito.any()))
                .thenReturn(MockUtil.buildClient());
        Assertions.assertNotNull(clientService.create(MockUtil.buildClientReq()));
    }

    @Test
    void update() {
        Mockito.when(clientRep.save(Mockito.any()))
                .thenReturn(MockUtil.buildClient());
        Assertions.assertNotNull(clientService.update( 1 ,MockUtil.buildClientReq()));
    }

    @Test
    void deleteById() {
        Mockito.when(clientRep.findById(Mockito.anyInt()))
                .thenReturn(null);
    }
}