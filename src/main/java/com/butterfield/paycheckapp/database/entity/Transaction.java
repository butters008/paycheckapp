package com.butterfield.paycheckapp.database.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "amount")
    private Float amount;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "recurring")
    private String recurring;

    @Column(name = "note")
    private String note;

    @OneToMany(mappedBy = "transactionId", fetch = FetchType.LAZY)
    @ToString.Exclude
    private Set<PaycheckTransaction> paycheckTransactions;
}
