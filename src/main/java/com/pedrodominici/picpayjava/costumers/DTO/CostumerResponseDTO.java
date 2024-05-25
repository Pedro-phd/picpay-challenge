package com.pedrodominici.picpayjava.costumers.DTO;

import com.pedrodominici.picpayjava.costumers.Costumer;

public record CostumerResponseDTO(String id) {
    public static CostumerResponseDTO From(Costumer data){
        return new CostumerResponseDTO(data.getId());
    }
}
