package br.com.leandrosenazuza.ControleBrinquedos.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "TB_BRINQUEDO")
public class Brinquedo implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id_brinquedo;

    @Column
    public String nome_brinquedo;

    @Column
    public String marca_brinquedo;

    @Column
    public LocalDateTime hora_Inclusao;

}
