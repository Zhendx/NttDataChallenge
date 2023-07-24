package com.nttdata.bank.client.controllers;

import com.nttdata.bank.client.dto.ClientRequestDTO;
import com.nttdata.bank.client.dto.ClientResponseDTO;
import com.nttdata.bank.client.services.IClient;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/client")
public class ClientController {
    private final IClient clientService;
    @GetMapping("/list")
    public ResponseEntity<List<ClientResponseDTO>> listClients(){
        return ResponseEntity.ok(clientService.getAllClients());
    }
    @GetMapping("/{id}/view")
    public ResponseEntity<ClientResponseDTO> listClientId(@PathVariable int id){
        return ResponseEntity.ok(clientService.getById(id));
    }
    @PostMapping("/create")
    public ResponseEntity<ClientResponseDTO> createClient(@RequestBody ClientRequestDTO clientRequestDTO){
        return ResponseEntity.ok(clientService.create(clientRequestDTO));
    }
    @PutMapping("/{id}/update")
    public ResponseEntity<ClientResponseDTO> updateClient(@PathVariable int id, @RequestBody ClientRequestDTO clientRequestDTO){
        return ResponseEntity.ok(clientService.update(id, clientRequestDTO));
    }
    @DeleteMapping("/{id}/delete")
    public ResponseEntity<Void> deleteClient(@PathVariable int id){
        clientService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
