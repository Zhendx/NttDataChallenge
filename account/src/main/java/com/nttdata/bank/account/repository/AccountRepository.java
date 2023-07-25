package com.nttdata.bank.account.repository;

import com.nttdata.bank.account.models.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
    @Query(value = "SELECT t FROM Account t WHERE t.accountNumber=?1 AND t.accountType=?2")
    Account findByPublishedAccountNumber(String accountNumber, String accountType);
}
