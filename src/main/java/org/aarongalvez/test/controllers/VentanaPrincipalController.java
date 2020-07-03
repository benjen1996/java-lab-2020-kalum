package org.aarongalvez.test.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import org.aarongalvez.test.App;
import javafx.fxml.Initializable;

public class VentanaPrincipalController implements Initializable {

    private App directorEscenas;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void mostrarVentanaSalon() {
        this.directorEscenas.mostrarVentanaSalon();

    }

    public void mostrarVentanaCarrera() {
        this.directorEscenas.mostrarVentanaCarrera();
    }

    public void mostrarVentanaInstructor() {
        this.directorEscenas.mostrarVentanaInstructor();
    }

    public void mostrarVentanaHorario() {
        this.directorEscenas.mostrarVentanaHorario();
    }

    public void mostrarVentanaClase() {
        this.directorEscenas.mostrarVentanaClase();
    }

    public App getDirectorEscenas() {
        return directorEscenas;
    }

    public void setDirectorEscenas(App directorEscenas) {
        this.directorEscenas = directorEscenas;
    }

}