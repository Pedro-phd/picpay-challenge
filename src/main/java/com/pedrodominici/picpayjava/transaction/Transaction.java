package com.pedrodominici.picpayjava.transaction;

import com.pedrodominici.picpayjava.costumers.Costumer;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Entity(name = "transactions")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private BigDecimal amout;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "payer_id")
    public Costumer payer;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "payee_id")
    public Costumer payee;

    @CreationTimestamp
    private Instant createdAt;
}