package com.professorangoti.condominio.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Proprietario {
    // O atributo id do objeto é necessário para fazer a sincronização com o
    // registro no banco de dados. Ojetos não possuem chave primária
    private Long id;

    private String nome, telefone;
}
