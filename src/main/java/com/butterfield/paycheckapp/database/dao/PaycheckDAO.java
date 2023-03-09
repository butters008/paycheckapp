package com.butterfield.paycheckapp.database.dao;

import com.butterfield.paycheckapp.database.entity.Paycheck;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PaycheckDAO extends JpaRepository<Paycheck, Long>  {
    Paycheck findById(@Param("id") Integer id);
}
