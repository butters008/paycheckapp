package com.butterfield.paycheckapp.database.entity;

import jakarta.persistence.*;
//import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.util.Set;
//import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="paychecks")
public class Paycheck {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

//    @NotEmpty(message = "Cannot be blank")
    @Column(name = "paycheck_name")
    private String paycheckName;

    @Column(name = "paycheck_amount")
    private Float paycheckAmount;

    @Column(name = "paycheck_date")
    private LocalDate paycheckDate;

    @Column(name = "day_name")
    private String dayName;

    @Column(name = "days_between_check")
    private Integer daysBetweenCheck;

    @OneToMany(mappedBy = "paycheckId", fetch = FetchType.LAZY)
    @ToString.Exclude
    private Set<PaycheckTransaction> paycheckTransactions;

}
