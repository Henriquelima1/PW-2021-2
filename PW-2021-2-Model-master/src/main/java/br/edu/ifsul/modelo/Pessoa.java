/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author Meu computador
 */
@Entity
@Table(name = "pessoa")
public class Pessoa implements Serializable{
     @Id
    @SequenceGenerator(name = "seq_pessoa", sequenceName = "seq_pessoa_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_pessoa", strategy = GenerationType.SEQUENCE)    
    private Integer id;
     @NotBlank(message = "O nome não pode ser em branco")
    @Length(max = 50, message = "O nome não pode ter mais que {max} caracteres")
    @Column(name = "nome", nullable = false, length = 50)    
    private String nome;
     @NotBlank(message = "O cpf não pode ser em branco")
    @Length(max = 50, message = "O cpf não pode ter mais que {max} caracteres")
    @Column(name = "cpf", nullable = false, length = 50)    
    private String cpf;
     @NotBlank(message = "O rg não pode ser em branco")
    @Length(max = 50, message = "O rg não pode ter mais que {max} caracteres")
    @Column(name = "rg", nullable = false, length = 50)    
    private String rg;
     @NotBlank(message = "O email não pode ser em branco")
    @Length(max = 50, message = "O email não pode ter mais que {max} caracteres")
    @Column(name = "email", nullable = false, length = 50)    
    private String email;
     @NotBlank(message = "O telefone não pode ser em branco")
    @Length(max = 50, message = "O telefone não pode ter mais que {max} caracteres")
    @Column(name = "telefone", nullable = false, length = 50)    
    private String telefone;
     

    public Pessoa() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
