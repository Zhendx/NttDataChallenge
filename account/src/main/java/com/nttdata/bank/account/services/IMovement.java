package com.nttdata.bank.account.services;

import com.nttdata.bank.account.dto.MovementRequestDTO;
import com.nttdata.bank.account.dto.MovementResponseDTO;
import com.nttdata.bank.account.models.entity.MovementReport;
import com.nttdata.bank.account.models.entity.MovementTrans;
import org.mapstruct.factory.Mappers;

import java.sql.Date;
import java.util.List;

public interface IMovement {
    IMovement INSTANCE = Mappers.getMapper(IMovement.class);
    List<MovementResponseDTO> getAllMovements();
    List<MovementReport> getAllRange(int id, Date dateInitial, Date dateFinal);
    MovementTrans update(MovementTrans movementTrans);
}
