package br.com.leandrosenazuza.ControleBrinquedos.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "TB_BRINQUEDO")
public class Brinquedo implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id_brinquedo;

    @Column
    public String nome_brinquedo;

    public int getId_brinquedo() {
        return id_brinquedo;
    }

    public void setId_brinquedo(int id_brinquedo) {
        this.id_brinquedo = id_brinquedo;
    }

    public String getNome_brinquedo() {
        return nome_brinquedo;
    }

    public void setNome_brinquedo(String nome_brinquedo) {
        this.nome_brinquedo = nome_brinquedo;
    }
}
