/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.controle;

import br.edu.ifsul.dao.AcessoriosDao;
import br.edu.ifsul.modelo.Acessorios;
import br.edu.ifsul.util.Util;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author Meu computador
 */
@Named(value = "controleAcessorios")
@ViewScoped
public class ControleAcessorios implements Serializable{
     @EJB
    private AcessoriosDao<Acessorios> dao;
    private Acessorios objeto;

    
    public ControleAcessorios(){
        
    }
    
    public String listar(){
        return "/privado/Acessorios/listar?faces-redirect=true";
    }
    
    public void novo(){
        objeto = new Acessorios();
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
    
    public AcessoriosDao<Acessorios> getDao() {
        return dao;
    }

    public void setDao(AcessoriosDao<Acessorios> dao) {
        this.dao = dao;
    }

    public Acessorios getObjeto() {
        return objeto;
    }

    public void setObjeto(Acessorios objeto) {
        this.objeto = objeto;
    }
}
