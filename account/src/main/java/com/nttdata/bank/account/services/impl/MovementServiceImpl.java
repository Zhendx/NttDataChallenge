package com.nttdata.bank.account.services.impl;

import com.nttdata.bank.account.dto.MovementRequestDTO;
import com.nttdata.bank.account.dto.MovementResponseDTO;
import com.nttdata.bank.account.mapper.MovementMapper;
import com.nttdata.bank.account.models.entity.*;
import com.nttdata.bank.account.repository.AccountRepository;
import com.nttdata.bank.account.repository.MovementRepository;
import com.nttdata.bank.account.services.IMovement;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class MovementServiceImpl implements IMovement {
    private final MovementRepository movementRep;
    private final AccountRepository accountRep;
    @Override
    public List<MovementResponseDTO> getAllMovements(){
        //return MovementMapper.INSTANCE.listMovementToListMovementResponse(movementRep.findAll());
        return  null;
    };
    @Override
    public List<MovementReport> getAllRange(int id, Date dateInitial, Date dateFinal){
        //List<MovementReport> movementReportList = new ArrayList<>();
        List<MovementReport> movement = movementRep.getMovementReport(dateInitial, dateFinal, id);
        /*for(Movement movementTemp : movement){
            MovementReport movementReport = new MovementReport();
            movementReport.setDate(movementTemp.getDate());
            movementReport.setName(movementTemp.get());
            movementReport.setAccount_number(account.getAccount_number());
            movementReport.setAccount_type(account.getAccount_type());
            movementReport.setOpening_balance(account.getOpening_balance());
            movementReport.setState(account.getState());
            movementReport.setMovement_type(movementTemp.getValue());
            movementReport.setAvailable_balance(movementTemp.getBalance());
            movementReportList.add(movementReport);
        }*/
        return movement;
    };
    @Override
    public MovementTrans update(MovementTrans movementTrans){
        Movement movement = new Movement();
        MovementTrans movementTransResponse = new MovementTrans();
        Account account = accountRep.findByPublishedAccountNumber(movementTrans.getAccount_number(), movementTrans.getAccount_type());
        if (Objects.isNull(account)) {

        }else {
            if (movementTrans.getType_movement().equals("Retiro")) {
                if (account.getOpening_balance() == 0) {
                    System.out.println("Error; ");
                } else {
                    if (account.getOpening_balance() >= movementTrans.getValue()) {
                        double num = account.getOpening_balance() - movementTrans.getValue();
                        movement.setBalance(num);
                        movementTransResponse.setBalance(num);
                    }
                }
            }
            if (movementTrans.getType_movement().equals("Deposito")) {
                double num = account.getOpening_balance() + movementTrans.getValue();
                movement.setBalance(num);
                movementTransResponse.setBalance(num);
            }

            movement.setTypeMovement(movementTrans.getType_movement());
            movement.setDate((java.sql.Date) movementTrans.getDate());
            movement.setValue(movementTrans.getValue());
            movement.setIdclient(account.getIdclient());

            movementTransResponse.setAccount_number(movementTrans.getAccount_number());
            movementTransResponse.setAccount_type(movementTrans.getAccount_type());
            movementTransResponse.setState(account.getState());
            movementTransResponse.setValue(movementTrans.getValue());
            movementTransResponse.setType_movement(movementTrans.getType_movement() + " de " + movementTrans.getValue());
            movementTransResponse.setDate(movementTrans.getDate());
        }
        movementRep.save(movement);
        return movementTransResponse;
    }
}
