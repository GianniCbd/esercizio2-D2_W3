package org.example;

import org.example.DAO.eventsDao;
import org.example.gestionEventi.Eventi;
import org.example.gestionEventi.enumeratori.tipoEvento;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Application {
    public static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");

    public static void main(String[] args) {

        EntityManager em = emf.createEntityManager();
        eventsDao ev = new eventsDao(em);

        Eventi evento1 = new Eventi("Matrimonio", "cerimonia", 2023,100, tipoEvento.PRIVATO);
        Eventi evento2 = new Eventi("Compleanno", "festa", 2023,25, tipoEvento.PRIVATO);
        Eventi evento4 = new Eventi("Apertura locale", "cerimonia", 2023,200, tipoEvento.PUBBLICO);

        ev.save(evento1);
        ev.save(evento2);
        ev.save(evento4);


        long id = 200;
        Eventi evento1FromDb = ev.findById(id);
        if(evento1FromDb != null){
            System.out.println(evento1FromDb);
        }else{
        System.out.println("evento" + id + "non trovato");
        }
        ev.findById(200);
        ev.findByIdandDelete(3);

        em.close();
        emf.close();
    }
}
