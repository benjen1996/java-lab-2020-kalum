package org.aarongalvez.test.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import org.aarongalvez.test.App;
import org.aarongalvez.test.db.Conexion;
import org.aarongalvez.test.models.CareraTecnica;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.collections.FXCollections;

import java.util.List;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;

public class VentanaCarreraTecnicaController implements Initializable {

    private ObservableList<CareraTecnica> listaCareras;
    private App directorEscenas;

    @FXML
    private TableView<CareraTecnica> tblCareraTecnica;
    @FXML
    private TableColumn<CareraTecnica, String> colNombreCarera;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        listaCareras = FXCollections
                .observableArrayList((List<CareraTecnica>) Conexion.getInstancia().findAll("CareraTecnica.findAll"));
        this.tblCareraTecnica.setItems(listaCareras);

        this.colNombreCarera.setCellValueFactory(cellCarrera -> cellCarrera.getValue().nombreCarrera());

    }

    public App getDirectorEscenas() {
        return directorEscenas;
    }

    public void setDirectorEscenas(App directorEscenas) {
        this.directorEscenas = directorEscenas;
    }

    public void mostrarVentanaPrincipal() {
        this.directorEscenas.mostrarVentanaPrincipal();
    }

    public void mostrarVentanaCareraAddUpdate() {
        this.directorEscenas.mostrarVentanaCareraAddUpdate();
    }

    public void modificar() {
        if (this.tblCareraTecnica.getSelectionModel().getSelectedItem() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Carera");
            alert.setHeaderText(null);
            alert.setContentText("Debe Seleccionar un Elemento ");
            alert.initOwner(null);
            alert.show();
        } else {
            CareraTecnica carera = this.tblCareraTecnica.getSelectionModel().getSelectedItem();
            this.directorEscenas.mostrarVentanaCareraAddUpdate(carera);
        }
    }

    public void eliminar() {
        if (this.tblCareraTecnica.getSelectionModel().getSelectedItem() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Carera Tecnica");
            alert.setHeaderText(null);
            alert.setContentText("Debe Seleccionar un Elemento ");
            alert.initOwner(null);
            alert.show();
        } else {
            CareraTecnica careraTecnica = this.tblCareraTecnica.getSelectionModel().getSelectedItem();
            Conexion.getInstancia().eliminar(careraTecnica);
            this.directorEscenas.mostrarVentanaCarrera();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Carera Tecnica");
            alert.setHeaderText(null);
            alert.setContentText("Carrera eliminada correctamente ");
            alert.initOwner(null);
            alert.show();
        }
    }

}