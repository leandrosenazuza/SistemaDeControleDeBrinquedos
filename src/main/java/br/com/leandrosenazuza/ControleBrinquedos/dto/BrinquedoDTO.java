package br.com.leandrosenazuza.ControleBrinquedos.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class BrinquedoDTO {
    @NotNull
    private String nome_brinquedo;

    private String marca_brinquedo;
}
