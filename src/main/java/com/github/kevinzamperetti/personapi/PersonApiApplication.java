package com.github.kevinzamperetti.personapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PersonApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(PersonApiApplication.class, args);
    }

    //TODO Fase-01
    //TODO criar dto para post sem id, lembrar como faz o mapper de dto para entity
    //TODO criar entidade para endereço e relacionamentos

    //TODO Fase-02
    //TODO configurar swagger

    //TODO ver alguma integração com api externa para praticar (talvez uma api de testar se municipio ou cep(se colocar na entidade campo para isso) existe
    //testar usar esta API https://servicodados.ibge.gov.br/api/docs/localidades ou http://educacao.dadosabertosbr.com/api/cidades/rs
    //pegar UF e verificar se existe e verificar se Cidade informada pertence ao município

}
