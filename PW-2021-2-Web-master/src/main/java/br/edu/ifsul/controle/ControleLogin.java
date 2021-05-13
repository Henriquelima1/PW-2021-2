package br.edu.ifsul.controle;


import br.edu.ifsul.dao.CorretorDao;
import br.edu.ifsul.modelo.Corretor;

import br.edu.ifsul.util.Util;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author 
 */
@Named(value = "controleLogin")
@SessionScoped
public class ControleLogin implements Serializable {
    
    private Corretor usuarioAutenticado;
    @EJB
    private CorretorDao<Corretor> dao;
    private String usuario;
    private String senha;
    
    public ControleLogin(){
        
    }
    
    public String irPaginaLogin(){
        return "/login?faces-redirect=true";
    }
    
    public String efetuarLogin(){
        try {
            HttpServletRequest request = (HttpServletRequest)
                    FacesContext.getCurrentInstance().getExternalContext().getRequest();
            request.login(this.usuario, this.senha);
            if (request.getUserPrincipal() != null){
                usuarioAutenticado = 
                        dao.getObjectByID(request.getUserPrincipal().getName());
                Util.mensagemInformacao("Login realizado com sucesso!");               
                usuario = "";
                senha = "";                        
            }            
            return "/index?faces-redirect=true";
        } catch (Exception e){
            Util.mensagemErro("Usuario ou senha inválidos! " + Util.getMensagemErro(e));
            return "/login";
        }            
    }
    
    public String logout(){
        try {
            usuarioAutenticado = null;
            HttpServletRequest request = (HttpServletRequest)
                    FacesContext.getCurrentInstance().getExternalContext().getRequest();
            request.logout();          
            return "/index?faces-redirect=true";
        } catch (Exception e){
            Util.mensagemErro("Erro ao fazer logout! " + Util.getMensagemErro(e));
            return "/index?faces-redirect=true";
        }          
    }

    public Corretor getUsuarioAutenticado() {
        return usuarioAutenticado;
    }

    public void setUsuarioAutenticado(Corretor usuarioAutenticado) {
        this.usuarioAutenticado = usuarioAutenticado;
    }

    public CorretorDao<Corretor> getDao() {
        return dao;
    }

    public void setDao(CorretorDao<Corretor> dao) {
        this.dao = dao;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    

}
