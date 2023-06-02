package br.com.payments.models.viacep;

public record ViaCepDTO(

        String cep,
        String logradouro,
        String complemento,
        String bairro,
        String localidade,
        String uf,
        String ibge,
        String gia,
        String ddd,
        String siafi

) {
}
