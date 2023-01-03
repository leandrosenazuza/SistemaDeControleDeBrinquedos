package br.com.leandrosenazuza.ControleBrinquedos.dto;

import javax.validation.constraints.NotNull;

public class BrinquedoDTO {
    @NotNull
    private String nome_brinquedo;

    public String getNome_brinquedo() {
        return nome_brinquedo;
    }

    public void setNome_brinquedo(String nome_brinquedo) {
        this.nome_brinquedo = nome_brinquedo;
    }
}
