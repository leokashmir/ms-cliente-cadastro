package br.com.cliente.api.enums;

public enum SexoEnum {
    M ("Masculino"),
    F ("Feminino");


    private final String description;

    SexoEnum(String description) {
         this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
