/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Meu computador
 */
@Entity
@Table(name = "seguro")
@Inheritance(strategy = InheritanceType.JOINED)
public class Seguro implements Serializable{
    @Id
    @SequenceGenerator(name = "seq_seguro", sequenceName = "seq_seguro_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_seguro", strategy = GenerationType.SEQUENCE)    
    private Integer id;
     @NotNull(message = "A data deve ser informada")
    @Column(name = "data", nullable = false)
    private Calendar data;
      @NotNull(message = "o incioVigencia deve ser informada")
    @Column(name = "incioVigencia", nullable = false)
    private Calendar incioVigencia;
        @NotNull(message = "o fimVigencia deve ser informada")
    @Column(name = "fimVigencia", nullable = false)
    private Calendar fimVigencia;
    @NotNull(message = "O valorTotal deve ser informado")
    @Column(name = "valorTotal", nullable = false)       
    private Double valorTotal; 
    @NotNull(message = "O valorFipe deve ser informado")
    @Column(name = "valorFipe", nullable = false)       
    private Double valorFipe;
    @ManyToOne
     @JoinColumn(name = "corretor", referencedColumnName = "id")
    private Corretor corretor ;
    @ManyToOne
     @JoinColumn(name = "carro", referencedColumnName = "id")
    private Carro carro ;

    public Corretor getCorretor() {
        return corretor;
    }

    public void setCorretor(Corretor corretor) {
        this.corretor = corretor;
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }
    
    public Seguro() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    public Calendar getIncioVigencia() {
        return incioVigencia;
    }

    public void setIncioVigencia(Calendar incioVigencia) {
        this.incioVigencia = incioVigencia;
    }

    public Calendar getFimVigencia() {
        return fimVigencia;
    }

    public void setFimVigencia(Calendar fimVigencia) {
        this.fimVigencia = fimVigencia;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Double getValorFipe() {
        return valorFipe;
    }

    public void setValorFipe(Double valorFipe) {
        this.valorFipe = valorFipe;
    }

    public void getData(GregorianCalendar gregorianCalendar) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void getIncioVigencia(GregorianCalendar gregorianCalendar) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void getFimVigencia(GregorianCalendar gregorianCalendar) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
