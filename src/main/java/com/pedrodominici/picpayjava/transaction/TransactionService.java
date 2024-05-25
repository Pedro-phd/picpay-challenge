package com.pedrodominici.picpayjava.transaction;

import com.pedrodominici.picpayjava.authorize.AuthorizeResponse;
import com.pedrodominici.picpayjava.authorize.AuthorizeService;
import com.pedrodominici.picpayjava.authorize.exceptions.NoAuthorizeException;
import com.pedrodominici.picpayjava.costumers.CostumerRepository;
import com.pedrodominici.picpayjava.costumers.CostumerTypes;
import com.pedrodominici.picpayjava.costumers.exceptions.CostumerNotFoundException;
import com.pedrodominici.picpayjava.http.HttpClientService;
import com.pedrodominici.picpayjava.http.HttpClientServiceImpl;
import com.pedrodominici.picpayjava.transaction.DTO.TransactionRequest;
import com.pedrodominici.picpayjava.transaction.exceptions.InsufficientFundsException;
import com.pedrodominici.picpayjava.transaction.exceptions.InvalidPayerTypeException;
import com.pedrodominici.picpayjava.wallets.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestClient;

import java.math.BigDecimal;
import java.net.URI;
import java.net.http.HttpClient;

@Service
public class TransactionService {

    @Autowired
    CostumerRepository cr;

    @Autowired
    WalletRepository wr;

    @Autowired
    TransactionRepository tr;

    @Autowired
    AuthorizeService authorize;

    HttpClientService<String> httpClientService = new HttpClientServiceImpl(HttpClient.newHttpClient());


    @Transactional
    public Transaction newTransaction(TransactionRequest data){
        var payee = cr.findById(data.payee_id()).orElseThrow(() -> new CostumerNotFoundException(data.payee_id()));
        var payer = cr.findById(data.payer_id())
                .orElseThrow(() -> new CostumerNotFoundException(data.payer_id()));

        if(!CostumerTypes.valid(payer.costumer_type)){
            throw new InvalidPayerTypeException();
        }

        var payeeWallet = payee.getWallet();
        var payerWallet = payer.getWallet();
        var compareAmout = payerWallet.amout.compareTo(data.amout());

        if(compareAmout < 0) {
            throw new InsufficientFundsException();
        }


        var authorizeTransaction = authorize.AuthorizeTransaction();
        if(!authorizeTransaction){
            throw new NoAuthorizeException();
        }

        wr.save(payeeWallet.credit(data.amout()));
        wr.save(payerWallet.debit(data.amout()));


        var transaction = new Transaction();
        transaction.setPayee(payee);
        transaction.setPayer(payer);
        transaction.setAmout(data.amout());

        tr.save(transaction);

        return transaction;
    }
}
