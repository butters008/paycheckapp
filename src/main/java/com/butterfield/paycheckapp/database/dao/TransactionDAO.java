package com.butterfield.paycheckapp.database.dao;


import com.butterfield.paycheckapp.database.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionDAO extends JpaRepository<Transaction, Long> {
    Transaction findById(@Param("id") Integer id);
}
