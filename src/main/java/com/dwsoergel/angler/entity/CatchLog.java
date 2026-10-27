package com.dwsoergel.angler.entity;

import org.hibernate.annotations.GenericGenerator;
import jakarta.persistence.*;
import java.util.Objects;

@Entity(name = "CatchLog")
@Table(name = "catch_logs")
public class CatchLog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    private String species;

    private double weight;

    @ManyToOne
    private User user;

    public CatchLog() {
    }

    public CatchLog(String species, double weight, User user) {
        this.species = species;
        this.weight = weight;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CatchLog catchLog = (CatchLog) o;
        return Double.compare(catchLog.weight, weight) == 0 &&
                Objects.equals(species, catchLog.species);
    }

    public int hashCode() {
        return Objects.hash(species, weight);
    }
}
