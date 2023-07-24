package com.nttdata.bank.client.util;

import com.nttdata.bank.client.dto.ClientRequestDTO;
import com.nttdata.bank.client.dto.ClientResponseDTO;
import com.nttdata.bank.client.models.entity.Client;
import java.util.ArrayList;
import java.util.List;

public class MockUtil {
    //Services-Person
    public static List<Client> buildListClient(){
        List<Client> listPerson = new ArrayList<>();
        listPerson.add(buildClient());
        return listPerson;
    }
    public static Client buildClient(){
        Client client = new Client();
        client.setId(1);
        client.setPassword("123456");
        client.setState(true);
        client.setName("a");
        client.setGender("Masculino");
        client.setAge(20);
        client.setIdentification("0706587425");
        client.setAddress("Avenida");
        client.setPhone("0729854685");
        return client;
    }
    public static ClientRequestDTO buildClientReq(){
        ClientRequestDTO personReq = new ClientRequestDTO();
        personReq.setId(1);
        personReq.setPassword("123456");
        personReq.setState(true);
        personReq.setName("a");
        personReq.setGender("Masculino");
        personReq.setAge(20);
        personReq.setIdentification("0706587425");
        personReq.setAddress("Avenida");
        personReq.setPhone("0729854685");
        return personReq;
    }
    //Controller-Person
    public static List<ClientResponseDTO> buildGetAllClientRes(){
        List<ClientResponseDTO> listPerson = new ArrayList<>();
        listPerson.add(buildClientRes());
        return listPerson;
    }
    public static ClientResponseDTO buildClientRes(){
        ClientResponseDTO personRes = new ClientResponseDTO();
        personRes.setId(1);
        personRes.setPassword("123456");
        personRes.setState(true);
        personRes.setName("a");
        personRes.setGender("Masculino");
        personRes.setAge(20);
        personRes.setIdentification("0706587425");
        personRes.setAddress("Avenida");
        personRes.setPhone("0729854685");
        return personRes;
    }
}
