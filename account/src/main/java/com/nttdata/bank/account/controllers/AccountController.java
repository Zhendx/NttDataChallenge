package com.nttdata.bank.account.controllers;

import com.nttdata.bank.account.dto.AccountRequestDTO;
import com.nttdata.bank.account.dto.AccountResponseDTO;
import com.nttdata.bank.account.services.IAccount;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/account")
public class AccountController {
    private final IAccount accountService;
    @GetMapping("/list")
    public ResponseEntity<List<AccountResponseDTO>> listAccounts(){
        return ResponseEntity.ok(accountService.getAllAccounts());
    }
    @GetMapping("/{id}/view")
    public ResponseEntity<AccountResponseDTO> listAccountId(@PathVariable int id){
        return ResponseEntity.ok(accountService.getById(id));
    }
    @PostMapping("/create")
    public ResponseEntity<AccountResponseDTO> createAccount(@RequestBody AccountRequestDTO accountRequestDTO){
        return ResponseEntity.ok(accountService.create(accountRequestDTO));
    }
    @PutMapping("/{id}/update")
    public ResponseEntity<AccountResponseDTO> updateAccount(@PathVariable int id, @RequestBody AccountRequestDTO accountRequestDTO){
        return ResponseEntity.ok(accountService.update(id, accountRequestDTO));
    }
    @DeleteMapping("/{id}/delete")
    public ResponseEntity<Void> deleteAccount(@PathVariable int id){
        accountService.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
