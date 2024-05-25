package com.pedrodominici.picpayjava.costumers;


import com.pedrodominici.picpayjava.costumers.DTO.CostumerInputDTO;
import com.pedrodominici.picpayjava.wallets.Wallet;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Transaction;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;
import java.util.List;

@Entity(name = "costumers")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Costumer {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    public String id;
    @Column()
    public String name;
    @Column(unique = true)
    public String email;
    @Column(unique = true)
    public String document_number;
    public String document_type;
    public String costumer_type;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "wallet_id")
    private Wallet wallet;

    @CreationTimestamp
    private Instant createdAt;
}
