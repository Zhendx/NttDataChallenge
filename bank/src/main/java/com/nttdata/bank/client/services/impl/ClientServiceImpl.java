package com.nttdata.bank.client.services.impl;

import com.nttdata.bank.client.dto.ClientRequestDTO;
import com.nttdata.bank.client.dto.ClientResponseDTO;
import com.nttdata.bank.client.error.AppException;
import com.nttdata.bank.client.error.ConstantError;
import com.nttdata.bank.client.mapper.ClientMapper;
import com.nttdata.bank.client.models.entity.Client;
import com.nttdata.bank.client.repository.ClientRepository;
import com.nttdata.bank.client.services.IClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements IClient {
    private final ClientRepository clientRep;
    @Override
    public List<ClientResponseDTO> getAllClients(){
        return ClientMapper.INSTANCE.listClientToListClientResponse(clientRep.findAll());
    };
    @Override
    public ClientResponseDTO getById(int id){
        Client client = clientRep.findById(id).orElseThrow(() -> new AppException(ConstantError.errorApp1));
        return ClientMapper.INSTANCE.clientToClientResponse(client);
    };
    @Override
    public ClientResponseDTO create(ClientRequestDTO clientRequestDTO){
        Client client = clientRep.save(ClientMapper.INSTANCE.clientRequestToClientCreate(clientRequestDTO));
        return ClientMapper.INSTANCE.clientToClientResponse(client);
    }
    @Override
    public ClientResponseDTO update(int id, ClientRequestDTO clientRequestDTO){
        Client client = clientRep.findById(id).orElseThrow(() -> new AppException(ConstantError.errorApp1));
        client.setState(clientRequestDTO.getState());
        client.setPassword(clientRequestDTO.getPassword());
        client.setName(clientRequestDTO.getName());
        client.setGender(clientRequestDTO.getGender());
        client.setAge(clientRequestDTO.getAge());
        client.setIdentification(clientRequestDTO.getIdentification());
        client.setAddress(clientRequestDTO.getAddress());
        client.setPhone(clientRequestDTO.getPhone());
        return ClientMapper.INSTANCE.clientToClientResponse(clientRep.save(client));
    }
    @Override
    public void deleteById(int id){
        clientRep.deleteById(id);
    }
}
