package org.aarongalvez.test.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

@Entity
@Table(name = "carrera_tecnica")
@NamedQueries({@NamedQuery(name = "CareraTecnica.findAll", query = "select ct from CareraTecnica ct")})
public class CareraTecnica implements Serializable {

    private final StringProperty carreraId;
    private final StringProperty nombreCarrera;
    private List<Clase> clases;


    public CareraTecnica() {
        this.carreraId = new SimpleStringProperty();
        this.nombreCarrera = new SimpleStringProperty();
    }

    public CareraTecnica(String carreraId, String nombreCarrera) {
        this.carreraId = new SimpleStringProperty();
        this.nombreCarrera = new SimpleStringProperty();
        this.carreraId.set(carreraId);
        this.nombreCarrera.set(nombreCarrera);
    }

    @Id
    @Column(name = "carrera_id")
    public String getCarreraId() {
        return this.carreraId.get();
    }

    public void setCarreraId(String carreraId) {
        this.carreraId.set(carreraId);
    }

    public StringProperty carreraId() {
        return this.carreraId;
    }

    @Column(name = "nombre_carrera")
    public String getNombreCarrera() {
        return this.nombreCarrera.get();
    }

    public void setNombreCarrera(String nombreCarrera) {
        this.nombreCarrera.set(nombreCarrera);
    }
    public String toString()
    {
        return this.getNombreCarrera();
    }

    public StringProperty nombreCarrera() {
        return this.nombreCarrera;
    }


    @OneToMany(mappedBy = "carrera", fetch = FetchType.EAGER)
    public List<Clase> getClases() {
        return clases;
    }

    public void setClases(List<Clase> clases) {
        this.clases = clases;
    }

    private static final long serialVersionUID = 1L;
}