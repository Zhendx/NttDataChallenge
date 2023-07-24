package com.nttdata.bank.account.repository;

import com.nttdata.bank.account.models.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
    @Query(value = "SELECT t FROM Account t WHERE t.account_number=?1 AND t.account_type=?2")
    Account findByPublishedAccountNumber(String accountNumber, String accountType);
}
