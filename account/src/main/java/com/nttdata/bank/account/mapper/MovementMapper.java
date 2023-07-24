package com.nttdata.bank.account.mapper;

import com.nttdata.bank.account.dto.MovementRequestDTO;
import com.nttdata.bank.account.dto.MovementResponseDTO;
import com.nttdata.bank.account.models.entity.Movement;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MovementMapper {
    MovementMapper INSTANCE = Mappers.getMapper(MovementMapper.class);
    Movement movementRequestToMovementCreate(MovementRequestDTO movementRequestDTO);
    MovementResponseDTO movementToMovementResponse(Movement movement);
    List<MovementResponseDTO> listMovementToListMovementResponse(List<Movement> movement);
}
