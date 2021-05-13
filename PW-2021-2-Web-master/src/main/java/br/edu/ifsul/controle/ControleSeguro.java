/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.controle;

import br.edu.ifsul.dao.SeguroDao;
import br.edu.ifsul.modelo.Cobertura;
import br.edu.ifsul.modelo.Seguro;
import br.edu.ifsul.util.Util;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author Meu computador
 */

@Named(value = "controleSeguro")
@ViewScoped
public class ControleSeguro implements Serializable{
    
     @EJB
     private SeguroDao<Seguro> dao;
     private Seguro objeto;
     private Cobertura cobertura;
        
    public String listar(){
        return "/privado/Seguro/listar?faces-redirect=true";
    }
    
    public void novo(){
        objeto = new Seguro();
    }
    
    public void alterar(Object id){
        try {
            objeto = dao.getObjectByID(id);
        } catch (Exception e){
            Util.mensagemInformacao("Erro ao recuperar objeto: " + Util.getMensagemErro(e));
        }
    }
    
    public void excluir(Object id){
        try {
            objeto = dao.getObjectByID(id);
            dao.remove(objeto);
            Util.mensagemInformacao("Objeto removido com sucesso!");
        } catch (Exception e){
            Util.mensagemInformacao("Erro ao remover objeto: " + Util.getMensagemErro(e));
        }
    }
    
    public void salvar(){
        try {
            if (objeto.getId() == null){
                dao.persist(objeto);
            } else {
                dao.merge(objeto);
            }
            Util.mensagemInformacao("Objeto persistido com sucesso!");
        } catch (Exception e){
            Util.mensagemInformacao("Erro ao salvar objeto: " + Util.getMensagemErro(e));
        }
    }

    public SeguroDao<Seguro> getDao() {
        return dao;
    }

    public void setDao(SeguroDao<Seguro> dao) {
        this.dao = dao;
    }

    public Seguro getObjeto() {
        return objeto;
    }

    public void setObjeto(Seguro objeto) {
        this.objeto = objeto;
    }
    
}
