package com.nttdata.bank.account.controllers;

import com.nttdata.bank.account.dto.MovementRequestDTO;
import com.nttdata.bank.account.dto.MovementResponseDTO;
import com.nttdata.bank.account.models.entity.MovementReport;
import com.nttdata.bank.account.models.entity.MovementTrans;
import com.nttdata.bank.account.services.IMovement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.sql.Date;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/movement")
public class MovementController {
    private final IMovement movementService;
    @GetMapping("/list")
    private ResponseEntity<List<MovementResponseDTO>> listMovements(){
        return ResponseEntity.ok(movementService.getAllMovements());
    }
    @GetMapping("/report")
    public ResponseEntity<List<MovementReport>> listMovementRangeDate(@RequestParam int id, @RequestParam Date dateInitial, @RequestParam Date dateFinal){
        return ResponseEntity.ok(movementService.getAllRange(id, dateInitial, dateFinal));
    }
    @PostMapping("/transaction")
    private ResponseEntity<MovementTrans> transactionMovement(@RequestBody MovementTrans movementTrans){
        return ResponseEntity.ok(movementService.update(movementTrans));
    }
}
