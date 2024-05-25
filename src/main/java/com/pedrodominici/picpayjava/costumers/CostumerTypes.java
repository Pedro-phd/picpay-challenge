package com.pedrodominici.picpayjava.costumers;

public enum CostumerTypes {
    LOJISTA,
    FISICA;

    public static Boolean valid(String type) {
        try {
            CostumerTypes.valueOf(type);
            return true;
        }catch (Throwable e){
            return false;
        }
    }
}
