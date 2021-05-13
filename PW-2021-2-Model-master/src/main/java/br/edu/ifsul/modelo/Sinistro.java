/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author Meu computador
 */
@Entity
@Table(name = "sinistro")
public class Sinistro implements Serializable {
    @Id
    @SequenceGenerator(name = "seq_sinistro", sequenceName = "seq_sinistro_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_sinistro", strategy = GenerationType.SEQUENCE)    
    private Integer id;
    @NotBlank(message = "O descricao não pode ser em branco")
    
    @Column(name = "descricao", nullable = false)    
    private String descricao;
    @NotNull(message = "A data deve ser informada")
    @Column(name = "data", nullable = false)
    private Calendar data;
    @NotBlank(message = "O cidade não pode ser em branco") 
    @Length(max = 50, message = "O cidade não pode ter mais que {max} caracteres")
    @Column(name = "cidade", nullable = false, length = 50)    
    private String cidade;
    @NotBlank(message = "O estado não pode ser em branco") 
    @Length(max = 50, message = "O estado não pode ter mais que {max} caracteres")
    @Column(name = "estado", nullable = false, length = 50)    
    private String estado;
    @NotNull(message = "O seguro deve ser informado")
    @ManyToOne
    @JoinColumn(name = "seguro", referencedColumnName = "id", nullable = false)    
    private Seguro seguro;

    public Seguro getSeguro() {
        return seguro;
    }

    public void setSeguro(Seguro seguro) {
        this.seguro = seguro;
    }

    public Sinistro() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
