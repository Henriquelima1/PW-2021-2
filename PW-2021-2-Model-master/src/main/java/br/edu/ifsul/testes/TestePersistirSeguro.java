/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Carro;
import br.edu.ifsul.modelo.Corretor;
import br.edu.ifsul.modelo.Seguro;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Meu computador
 * 
 */
public class TestePersistirSeguro {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PW-2021-2-ModelPU");
        EntityManager em = emf.createEntityManager();
        Seguro seguro = new Seguro();
        seguro.setData(new GregorianCalendar(2020, Calendar.SEPTEMBER, 15));
        seguro.setIncioVigencia(new GregorianCalendar(2007, Calendar.SEPTEMBER, 15));
        seguro.setFimVigencia(new GregorianCalendar(2027, Calendar.SEPTEMBER, 15));
        seguro.setValorTotal(1222.00);
        seguro.setValorFipe(1000.00);
        seguro.setCarro(em.find(Carro.class, 1));
        seguro.setCorretor(em.find(Corretor.class, 1));
       
   
        em.getTransaction().begin();
        em.persist(seguro);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
