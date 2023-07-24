package com.nttdata.bank.client.mapper;

import com.nttdata.bank.client.dto.ClientRequestDTO;
import com.nttdata.bank.client.dto.ClientResponseDTO;
import com.nttdata.bank.client.models.entity.Client;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
@Mapper(componentModel = "spring")
public interface ClientMapper {
    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);
    Client clientRequestToClientCreate(ClientRequestDTO clientRequestDTO);
    ClientResponseDTO clientToClientResponse(Client client);
    List<ClientResponseDTO> listClientToListClientResponse(List<Client> client);
}
