package com.pedrodominici.picpayjava.costumers.DTO;

import com.pedrodominici.picpayjava.costumers.CostumerTypes;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public record CostumerInputDTO(

        @NotBlank
        @Length(min = 3,message = "O comprimento deve ser de no minimo 3 letras")
        String name,

        @NotBlank @Email(message = "O e-mail deve seguir a formatação email@provider.com")
        String email,

        @NotBlank
        String document_number,

        @NotBlank
        String document_type,

        @NotBlank
        String costumer_type


) {
}
