package org.aarongalvez.test.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.UUID;

import org.aarongalvez.test.App;
import org.aarongalvez.test.db.Conexion;
import org.aarongalvez.test.models.CareraTecnica;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.fxml.FXML;

public class VentanaCareraAddUpdateController implements Initializable {
    private App directorEscenas;
    private CareraTecnica carera;
    @FXML
    private TextField txtNombreCarrera;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void cancelar() {
        this.directorEscenas.mostrarVentanaCarrera();
    }

    public void guardar() {
        if (txtNombreCarrera.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Carera");
            alert.setHeaderText(null);
            alert.setContentText("Error, Campos tienen que ser llenados");
            alert.initOwner(null);
            alert.show();
        } else {
            if (carera != null) {
                carera.setNombreCarrera(txtNombreCarrera.getText());
                Conexion.getInstancia().modificar(carera);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Carera");
                alert.setHeaderText(null);
                alert.setContentText("Registo Modificado Correctamente");
                alert.initOwner(null);
                alert.show();
                this.directorEscenas.mostrarVentanaCarrera();
            } else {
                carera = new CareraTecnica();
                carera.setCarreraId(UUID.randomUUID().toString());
                carera.setNombreCarrera(txtNombreCarrera.getText());
                Conexion.getInstancia().agregar(carera);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Carera");
                alert.setHeaderText(null);
                alert.setContentText("Registo Almacenado Correctamente");
                alert.initOwner(null);
                alert.show();
                this.directorEscenas.mostrarVentanaCarrera();

            }

        }
    }

    public App getDirectorEscenas() {
        return directorEscenas;
    }

    public void setDirectorEscenas(App directorEscenas) {
        this.directorEscenas = directorEscenas;
    }

    public CareraTecnica getCarera() {
        return carera;
    }

    public void setCarera(CareraTecnica carera) {
        this.carera = carera;
        this.txtNombreCarrera.setText(carera.getNombreCarrera());

    }

}