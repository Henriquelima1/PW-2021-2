/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.controle;


import br.edu.ifsul.dao.AcessoriosDao;
import br.edu.ifsul.dao.CarroDao;
import br.edu.ifsul.modelo.Acessorios;
import br.edu.ifsul.modelo.Carro;
import br.edu.ifsul.util.Util;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author Meu computador
 */
@Named(value = "controleCarro")
@ViewScoped
public class ControleCarro implements Serializable{
    @EJB
    private CarroDao<Carro> dao;
    private Carro objeto;
    @EJB
    private AcessoriosDao<Acessorios> daoAcessorios;
    
    public ControleCarro(){
        
    }
    
    public String listar(){
        return "/privado/Carro/listar?faces-redirect=true";
    }
     public String Cadastro(){
        return "/privado/Carro/formulario?faces-redirect=true";
    }
    
    public void novo(){
        objeto = new Carro();
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
    
    public CarroDao<Carro> getDao() {
        return dao;
    }

    public void setDao(CarroDao<Carro> dao) {
        this.dao = dao;
    }

    public Carro getObjeto() {
        return objeto;
    }

    public void setObjeto(Carro objeto) {
        this.objeto = objeto;
    }
    public AcessoriosDao<Acessorios> getDaoAcessorios() {
        return daoAcessorios;
    }

    public void setDaoAcessorios(AcessoriosDao<Acessorios> daoAcessorios) {
        this.daoAcessorios = daoAcessorios;
    }
}
