package com.butterfield.paycheckapp.database.dao;

import com.butterfield.paycheckapp.database.entity.PaycheckTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaycheckTransactionDAO extends JpaRepository<PaycheckTransaction, Long> {
}
