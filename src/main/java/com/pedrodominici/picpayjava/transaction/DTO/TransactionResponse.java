package com.pedrodominici.picpayjava.transaction.DTO;

import java.util.UUID;

public record TransactionResponse(UUID id, String payee_id, String payer_id) {
}
