package org.example.gestionEventi;


import org.example.gestionEventi.enumeratori.tipoEvento;

import javax.persistence.*;

@Entity
@Table(name = "events")
public class Eventi {
@Id
@GeneratedValue
private Long Id;
@Column (name = "titolo")
    private String title;
    @Column (name = "descrizione")
    private String description;
    @Column (name = "dataEVento")
    private int eventDay;
    @Column (name = "numeroPartecipanti")
    private int numberGuest;


@Enumerated(EnumType.STRING)
    private tipoEvento event;

public Eventi(){};

    public Eventi(String title, String description, int eventDay, int numberGuest, tipoEvento event) {
        this.title = title;
        this.description = description;
        this.eventDay = eventDay;
        this.numberGuest = numberGuest;
        this.event = event;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getTitolo() {
        return title;
    }

    public void setTitolo(String titolo) {
        this.title = titolo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getEventDay() {
        return eventDay;
    }

    public void setEvent(tipoEvento event) {
        this.event = event;
    }

    public int getNumberCustomers() {
        return numberGuest;
    }

    public void setNumberCustomers(int numberCustomers) {
        this.numberGuest = numberCustomers;
    }

    public tipoEvento getEvent() {
        return event;
    }

    public void setEventDay(int eventDay) {
        this.eventDay = eventDay;
    }


    @Override
    public String toString() {
        return "Evento{" +
                "id=" + Id +
                ", titolo='" + title + '\'' +
                ", descrizione=" + description +
                ", giorno evento='" + eventDay + '\'' +
                ", tipoEvento=" + event +
                ", numeroMassimoPartecipanti=" + numberGuest +
                '}';
}}
