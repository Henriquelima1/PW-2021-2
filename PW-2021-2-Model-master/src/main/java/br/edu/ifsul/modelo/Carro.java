/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "carro")
@Inheritance(strategy = InheritanceType.JOINED)
public class Carro implements Serializable{
    
    @Id
    @SequenceGenerator(name = "seq_carro", sequenceName = "seq_carro_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_carro", strategy = GenerationType.SEQUENCE)    
    private Integer id;
    @NotBlank(message = "O placa não pode ser em branco") 
    @Length(max = 50, message = "O placa não pode ter mais que {max} caracteres")
    @Column(name = "placa", nullable = false, length = 50)    
    private String placa;
    @NotBlank(message = "O renavam não pode ser em branco")
    @Length(max = 50, message = "O renavam não pode ter mais que {max} caracteres")
    @Column(name = "renavam", nullable = false, length = 50)    
    private String renavam;
    @NotBlank(message = "O modelo não pode ser em branco")
    @Length(max = 50, message = "O modelo não pode ter mais que {max} caracteres")
    @Column(name = "modelo", nullable = false, length = 50)    
    private String modelo;
    @NotBlank(message = "O fabricante não pode ser em branco")
    @Length(max = 50, message = "O fabricante não pode ter mais que {max} caracteres")
    @Column(name = "fabricante", nullable = false, length = 50)    
    private String fabricante;
    @NotNull(message = "O anoFabricacao deve ser informado")
    @Column(name = "anoFabricacao", nullable = false)       
    private Integer anoFabricacao ;
    @NotNull(message = "O anoModelo deve ser informado")
    @Column(name = "anoModelo", nullable = false)       
    private Integer anoModelo ;
    @ManyToOne
    @JoinColumn(name= "pessoa", referencedColumnName= "id", nullable= false)
    private Pessoa pessoa;
@ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "carro_acessorios", 
            joinColumns = 
                    @JoinColumn(name = "carro", referencedColumnName = "id", nullable = false), 
            inverseJoinColumns =  @JoinColumn(name = "acessorios", referencedColumnName = "id", nullable = false))
    private Set<Acessorios> acessorios = new HashSet<>();

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Set<Acessorios> getAcessorios() {
        return acessorios;
    }

    public void setAcessorios(Set<Acessorios> acessorios) {
        this.acessorios = acessorios;
    }
    public Carro() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getRenavam() {
        return renavam;
    }

    public void setRenavam(String renavam) {
        this.renavam = renavam;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public Integer getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(Integer anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public Integer getAnoModelo() {
        return anoModelo;
    }

    public void setAnoModelo(Integer anoModelo) {
        this.anoModelo = anoModelo;
    }
    
    
   
}
