package com.nttdata.bank.account.repository;

import com.nttdata.bank.account.models.entity.Account;
import com.nttdata.bank.account.models.entity.Client;
import com.nttdata.bank.account.models.entity.Movement;
import com.nttdata.bank.account.models.entity.MovementReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface MovementRepository extends CrudRepository<Movement, Integer> {
    @Query(value = "SELECT t FROM Account t WHERE t.accountNumber=?1 AND t.accountType=?2")
    Account findByPublishedAccountNumber(String accountNumber, String accountType);
    @Query(value = "SELECT new com.nttdata.bank.account.models.entity.MovementReport(m.date, c.name, m.typeMovement, a.accountNumber, a.accountType, a.openingBalance, a.state) " +
            "FROM Movement m JOIN Client c ON c.id =  m.idclient JOIN Account a ON c.id = a.idclient " +
            "WHERE m.date BETWEEN ?1 AND ?2")
    List<MovementReport> getMovementReport(Date dateInitial, Date dateFinal, Integer id);
    @Query(value = "SELECT c FROM Client c where c.id=?1")
    Client findByClient(Integer id);
    @Query(value = "SELECT a FROM Account a where a.idclient=?1")
    Account findByAccount(Integer id);

}
