package com.pedrodominici.picpayjava.transaction.DTO;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record TransactionRequest(@NotBlank String payee_id, @NotBlank String payer_id, @Min(0) @NotNull BigDecimal amout) {
}
