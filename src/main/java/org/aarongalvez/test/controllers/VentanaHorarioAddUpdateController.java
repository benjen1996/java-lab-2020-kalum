package org.aarongalvez.test.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import org.aarongalvez.test.App;

import javafx.fxml.Initializable;

public class VentanaHorarioAddUpdateController implements Initializable {

    private App directorEscenas;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        

    }

    public App getDirectorEscenas() {
        return directorEscenas;
    }

    public void setDirectorEscenas(App directorEscenas) {
        this.directorEscenas = directorEscenas;
    }
    
}