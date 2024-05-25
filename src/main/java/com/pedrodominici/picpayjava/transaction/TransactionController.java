package com.pedrodominici.picpayjava.transaction;

import com.pedrodominici.picpayjava.transaction.DTO.TransactionRequest;
import com.pedrodominici.picpayjava.transaction.DTO.TransactionResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping(path = "/transaction")
@Tag(name = "Transaction | Transação", description = "Realizar transações.")
public class TransactionController {

    @Autowired
    TransactionService ts;

    @PostMapping("/new")
    public ResponseEntity<TransactionResponse> transaction(@RequestBody @Valid TransactionRequest data, BindingResult validResult){
        var transaction = ts.newTransaction(data);

        var response = new TransactionResponse(transaction.getId(), transaction.payee.id, transaction.payer.id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
