package org.example.DAO;

import org.example.gestionEventi.Eventi;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class eventsDao {

    private final EntityManager em;

public eventsDao(EntityManager em){
    this.em = em;
}

public void save(Eventi eventi){
    EntityTransaction transaction = em.getTransaction();
    transaction.begin();
    em.persist(eventi);
    transaction.commit();
    System.out.println("evento: " + eventi.getTitolo() + "aggiunto correttamente");
}

public Eventi findById (long id){
    return em.find(Eventi.class, id);
}

public void  findByIdandDelete (long id){

    Eventi found = this.findById(id);

    if(found != null){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(found);
        transaction.commit();
        System.out.println("Evento:" +found.getTitolo() + "eliminato correttamente");
    }else{
        System.out.print("Evento con" + id + " non trovato");
    }
    }
}
