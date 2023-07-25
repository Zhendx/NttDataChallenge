package com.nttdata.bank.account.services.impl;

import com.nttdata.bank.account.dto.MovementRequestDTO;
import com.nttdata.bank.account.dto.MovementResponseDTO;
import com.nttdata.bank.account.error.AppException;
import com.nttdata.bank.account.error.ConstantError;
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
        return MovementMapper.INSTANCE.listMovementToListMovementResponse(movementRep.findAll());
    };
    @Override
    public List<MovementReportValue> getReport(int id, Date dateInitial, Date dateFinal){
        List<MovementReportValue> movementReportValueList = new ArrayList<>();
        List<MovementReport> movement = movementRep.getMovementReport(dateInitial, dateFinal, id);
        for(MovementReport movementTemp : movement){
            MovementReportValue movementReportValue = new MovementReportValue();
            movementReportValue.setDate(movementTemp.getDate());
            movementReportValue.setName(movementTemp.getName());
            movementReportValue.setAccountNumber(movementTemp.getAccountNumber());
            movementReportValue.setAccountType(movementTemp.getAccountType());
            movementReportValue.setBalance(movementTemp.getBalance());
            movementReportValue.setState(movementTemp.getState());
            movementReportValue.setTypeMovement(movementTemp.getTypeMovement());
            movementReportValue.setValue(movementTemp.getValue());
            if (movementTemp.getTypeMovement().equals("Retiro")){
                movementReportValue.setAvailableBalance(movementTemp.getBalance() - movementTemp.getValue());
            }else{
                movementReportValue.setAvailableBalance(movementTemp.getBalance() + movementTemp.getValue());
            }
            movementReportValueList.add(movementReportValue);
        }
        return movementReportValueList;
    };
    @Override
    public MovementTrans getTransaction(MovementTrans movementTrans){
        Movement movement = new Movement();
        MovementTrans movementTransResponse = new MovementTrans();
        Account account = accountRep.findByPublishedAccountNumber(movementTrans.getAccountNumber(), movementTrans.getAccountType());
        Movement movementId = movementRep.findByMovement(account.getIdclient());
        if (Objects.isNull(account)) {
            throw new AppException(ConstantError.errorApp);
        }else {
            String typeMovement = movementTrans.getTypeMovement();
            if (typeMovement.equals("Retiro")) {
                if (account.getOpeningBalance() == 0) {
                    throw new AppException(ConstantError.errorApp1);
                } else {
                    if (Objects.isNull(movementId)){
                        if (account.getOpeningBalance() >= movementTrans.getValue()){
                            double num = account.getOpeningBalance() - movementTrans.getValue();
                            movement.setBalance(num);
                            movementTransResponse.setBalance(num);
                        }
                    }else{
                        if (movementId.getBalance() >= movementTrans.getValue()){
                            double num = movementId.getBalance() - movementTrans.getValue();
                            movement.setBalance(num);
                            movementTransResponse.setBalance(num);
                        }
                    }
                }
            }else{
                if (Objects.isNull(movementId)){
                    double num = account.getOpeningBalance() + movementTrans.getValue();
                    movement.setBalance(num);
                    movementTransResponse.setBalance(num);
                }else{
                    double num = movementId.getBalance() + movementTrans.getValue();
                    movement.setBalance(num);
                    movementTransResponse.setBalance(num);
                }
            }

            movement.setTypeMovement(movementTrans.getTypeMovement());
            movement.setDate(movementTrans.getDate());
            movement.setValue(movementTrans.getValue());
            movement.setIdclient(account.getIdclient());

            movementTransResponse.setAccountNumber(movementTrans.getAccountNumber());
            movementTransResponse.setAccountType(movementTrans.getAccountType());
            movementTransResponse.setState(account.getState());
            movementTransResponse.setValue(movementTrans.getValue());
            movementTransResponse.setTypeMovement(movementTrans.getTypeMovement() + " de " + movementTrans.getValue());
            movementTransResponse.setDate(movementTrans.getDate());
        }
        movementRep.save(movement);
        return movementTransResponse;
    }
}
