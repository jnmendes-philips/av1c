package ifc.edu.br.mv9webhib.dao;

import ifc.edu.br.mv9webhib.model.Pessoa;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import java.util.List;

public class DAO {
    
    EntityManagerFactory emf;
    EntityManager em;

    public DAO() {
        emf = Persistence.createEntityManagerFactory("meuPU");
        em = emf.createEntityManager();
    }
    
    public void inserir(Pessoa p) {
        EntityTransaction tx = em.getTransaction();
        
        tx.begin();
        em.persist(p);
        tx.commit();
    }
    
    public List consultar() {
        List pessoas = em.createQuery("from Pessoa", Pessoa.class).getResultList();
        return pessoas;
    }
    
}
