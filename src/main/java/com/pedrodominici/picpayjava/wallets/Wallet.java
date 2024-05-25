package com.pedrodominici.picpayjava.wallets;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.Instant;

@Entity(name = "wallets")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Wallet {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    public String id;
    public BigDecimal amout;

    @CreationTimestamp
    private Instant createdAt;

    public Wallet debit(BigDecimal value){
        var w = new Wallet();
        w.setId(id);
        w.setAmout(amout.subtract(value));
        return w;
    }

    public  Wallet credit(BigDecimal value){
        var w = new Wallet();
        w.setId(id);
        w.setAmout(amout.add(value));
        return w;
    }
}
