package br.com.cliente.api.exceptions;

public enum ServiceExceptionHandlerEnum {
    EXCP204("Registro não econtrado"),
    ERRO409("Dados Invalidos"),
    ERRO409B("Dados Obrigatorios"),
    ERRO400("A requisição foi malformada, omitindo atributos obrigatórios, seja no payload ou através de atributos na URL."),
    ERRO405("Recurso com um método não suportado"),
    ERRO500("Ocorreu um erro no gateway da API ou no microsserviço");


    private final String description;

    ServiceExceptionHandlerEnum(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
