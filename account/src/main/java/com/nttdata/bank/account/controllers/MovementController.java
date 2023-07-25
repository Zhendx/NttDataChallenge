package com.nttdata.bank.account.controllers;

import com.nttdata.bank.account.dto.MovementRequestDTO;
import com.nttdata.bank.account.dto.MovementResponseDTO;
import com.nttdata.bank.account.models.entity.MovementReportValue;
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
    @GetMapping("/{id}/view")
    public ResponseEntity<MovementResponseDTO> listMovementId(@PathVariable int id){
        return ResponseEntity.ok(movementService.getById(id));
    }
    @PostMapping("/create")
    public ResponseEntity<MovementResponseDTO> createMovement(@RequestBody MovementRequestDTO movementRequestDTO){
        return ResponseEntity.ok(movementService.create(movementRequestDTO));
    }
    @PostMapping("/{id}/update")
    public ResponseEntity<MovementResponseDTO> updateMovement(@PathVariable int id, @RequestBody MovementRequestDTO movementRequestDTO){
        return ResponseEntity.ok(movementService.update(id, movementRequestDTO));
    }
    @DeleteMapping("/{id}/delete")
    public ResponseEntity<Void> deleteMovement(@PathVariable int id){
        movementService.deleteById(id);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/report")
    public ResponseEntity<List<MovementReportValue>> listMovementRangeDate(@RequestParam int id, @RequestParam Date dateInitial, @RequestParam Date dateFinal){
        return ResponseEntity.ok(movementService.getReport(id, dateInitial, dateFinal));
    }
    @PostMapping("/transaction")
    private ResponseEntity<MovementTrans> transactionMovement(@RequestBody MovementTrans movementTrans){
        return ResponseEntity.ok(movementService.getTransaction(movementTrans));
    }
}
