package com.nttdata.bank.account.services.impl;

import com.nttdata.bank.account.repository.AccountRepository;
import com.nttdata.bank.account.repository.MovementRepository;
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
class MovementServiceImplTest {

    @BeforeEach
    void setUp() {
    }
    @InjectMocks
    MovementServiceImpl movementService;
    @Mock
    private MovementRepository movementRep;

    @Test
    void getAllMovements() {
        Mockito.when(movementRep.findAll())
                .thenReturn(MockUtil.buildListMovement());
        assertNotNull(movementService.getAllMovements());
    }

    @Test
    void getById() {
        Mockito.when(movementRep.findById(Mockito.anyInt()))
                .thenReturn(Optional.of(MockUtil.buildMovement()));
        Assertions.assertNotNull(movementService.getById(1));
    }

    @Test
    void create() {
        Mockito.when(movementRep.save(Mockito.any()))
                .thenReturn(MockUtil.buildMovement());
        Assertions.assertNotNull(movementService.create(MockUtil.buildMovementReq()));
    }

    @Test
    void update() {
        Mockito.when(movementRep.save(Mockito.any()))
                .thenReturn(MockUtil.buildMovement());
    }

    @Test
    void deleteById() {
        Mockito.when(movementRep.findById(Mockito.anyInt()))
                .thenReturn(null);
    }
}