/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Seguro;
import java.io.Serializable;
import javax.ejb.Stateful;

/**
 *
 * @author Meu computador
 */
@Stateful
public class SeguroDao<TIPO> extends DAOGenerico<Seguro> implements Serializable {

    public SeguroDao() {
        super();
        classePersistente = Seguro.class;
    }
    
}
