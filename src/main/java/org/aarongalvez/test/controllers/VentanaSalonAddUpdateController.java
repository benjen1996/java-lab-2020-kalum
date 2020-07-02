package org.aarongalvez.test.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.UUID;

import javafx.fxml.FXML;
import org.aarongalvez.test.App;
import org.aarongalvez.test.db.Conexion;
import org.aarongalvez.test.models.Salon;

import javafx.scene.control.Alert;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

public class VentanaSalonAddUpdateController implements Initializable {
    private App directorEscenas;
    private Salon salon;

    @FXML
    private TextField txtSalon;
    @FXML
    private TextField txtDescripcion;
    @FXML
    private TextField txtCapacidad;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void cancelar() {
        this.directorEscenas.mostrarVentanaSalon();
    }

    public void guardar() {
        if (txtSalon.getText().isEmpty() || txtDescripcion.getText().isEmpty() || txtCapacidad.getText().isEmpty()
                || Integer.parseInt(txtCapacidad.getText()) <= 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Salon");
            alert.setHeaderText(null);
            alert.setContentText("Error, Todos los campos tienen que ser llenados para continuar");
            alert.initOwner(null);
            alert.show();
        } else {
            if (salon != null) {

                salon.setNombreSalon(txtSalon.getText());
                salon.setDescripcion(txtDescripcion.getText());
                salon.setCapacidad(Integer.parseInt(txtCapacidad.getText()));
                Conexion.getInstancia().modificar(salon);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Salon");
                alert.setHeaderText(null);
                alert.setContentText("Registo Modificado Correctamente");
                alert.initOwner(null);
                alert.show();
                this.directorEscenas.mostrarVentanaSalon();

            } else {
                salon = new Salon();
                salon.setSalonId(UUID.randomUUID().toString());
                salon.setNombreSalon(txtSalon.getText());
                salon.setDescripcion(txtDescripcion.getText());
                salon.setCapacidad(Integer.parseInt(txtCapacidad.getText()));
                Conexion.getInstancia().agregar(salon);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Salon");
                alert.setHeaderText(null);
                alert.setContentText("Registo Almacenado Correctamente");
                alert.initOwner(null);
                alert.show();
                this.directorEscenas.mostrarVentanaSalon();
            }

        }
    }

    public App getDirectorEscenas() {
        return directorEscenas;
    }

    public void setDirectorEscenas(App directorEscenas) {
        this.directorEscenas = directorEscenas;
    }

    public Salon getSalon() {
        return salon;
    }

    public void setSalon(Salon salon) {
        this.salon = salon;
        this.txtSalon.setText(salon.getNombreSalon());
        this.txtDescripcion.setText(salon.getDescripcion());
        this.txtCapacidad.setText(String.valueOf(salon.getCapacidad()));
    }

}