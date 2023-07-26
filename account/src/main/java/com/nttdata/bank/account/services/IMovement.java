package com.nttdata.bank.account.services;

import com.nttdata.bank.account.dto.MovementRequestDTO;
import com.nttdata.bank.account.dto.MovementResponseDTO;
import com.nttdata.bank.account.models.entity.MovementReportValue;
import com.nttdata.bank.account.models.entity.MovementTrans;


import java.sql.Date;
import java.util.List;

public interface IMovement {
    List<MovementResponseDTO> getAllMovements();
    MovementResponseDTO getById(int id);
    MovementResponseDTO create(MovementRequestDTO movementRequestDTO);
    MovementResponseDTO update(int id, MovementRequestDTO movementRequestDTO);
    void deleteById(int id);
    List<MovementReportValue> getReport(int id, Date dateInitial, Date dateFinal);
    MovementTrans getTransaction(MovementTrans movementTrans);
}
