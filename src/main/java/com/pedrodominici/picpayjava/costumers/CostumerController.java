package com.pedrodominici.picpayjava.costumers;

import com.pedrodominici.picpayjava.costumers.DTO.CostumerInputDTO;
import com.pedrodominici.picpayjava.costumers.DTO.CostumerResponseDTO;
import com.pedrodominici.picpayjava.costumers.exceptions.CostumerInvalidFieldsException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/costumer")
@Tag(name = "Costumer | Cliente", description = "Gerenciamento dos clientes.")
public class CostumerController {

    @Autowired
    private CostumerService cs;

    @Transactional
    @PostMapping(path = "/new")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Criar novos clientes")
    public CostumerResponseDTO newUser(@RequestBody @Valid CostumerInputDTO data, BindingResult result) {
        if(!CostumerTypes.valid(data.costumer_type())) {
            result.rejectValue("costumer_type", "error", "O tipo do costumer deve ser LOJISTA ou FISICA");
        }

        if(result.hasErrors()) {
            throw new CostumerInvalidFieldsException(result);
        }

        Costumer response = cs.NewCostumer(data);
        return CostumerResponseDTO.From(response);
    }
}
