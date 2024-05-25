package com.pedrodominici.picpayjava.costumers;

import com.pedrodominici.picpayjava.costumers.DTO.CostumerInputDTO;
import com.pedrodominici.picpayjava.wallets.Wallet;
import com.pedrodominici.picpayjava.wallets.WalletRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLIntegrityConstraintViolationException;

@Service
public class CostumerService {

    @Autowired
    private CostumerRepository cr;

    @Autowired
    private WalletRepository wr;

    @Transactional
    public Costumer NewCostumer(CostumerInputDTO data) {
        Wallet newWallet = new Wallet();
        Costumer costumer = new Costumer();

        wr.save(newWallet);

        BeanUtils.copyProperties(data, costumer);
        costumer.setWallet(newWallet);

        cr.save(costumer);


        return costumer;
    }


}
