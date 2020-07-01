package org.aarongalvez.test.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import org.aarongalvez.test.App;
import org.aarongalvez.test.db.Conexion;
import org.aarongalvez.test.models.Salon;

import java.util.List;

import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

public class VentanaSalonController implements Initializable {

    private ObservableList<Salon> listaSalones;
    private App directorEscenas;

    @FXML
    private TableView<Salon> tblSalon;
    @FXML
    private TableColumn<Salon, String> colSalon;
    @FXML
    private TableColumn<Salon, String> colDescripcion;
    @FXML
    private TableColumn<Salon, Number> colCapacidad;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        listaSalones = FXCollections
                .observableArrayList((List<Salon>) Conexion.getInstancia().findAll("Salon.findAll"));
        this.tblSalon.setItems(listaSalones);

        this.colSalon.setCellValueFactory(cellSalon -> cellSalon.getValue().nombreSalon());
        this.colDescripcion.setCellValueFactory(cellDescripcion -> cellDescripcion.getValue().descripcion());
        this.colCapacidad.setCellValueFactory(cellCapacidad -> cellCapacidad.getValue().capacidad());
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

    public void mostrarVentanaSalonAddUpdate() {
        this.directorEscenas.mostrarVentanaSalonAddUpdate();
    }

    public void modificar() {
        if (this.tblSalon.getSelectionModel().getSelectedItem() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Salon");
            alert.setHeaderText(null);
            alert.setContentText("Debe Seleccionar un Elemento ");
            alert.initOwner(null);
            alert.show();
        } else {
            Salon salon = this.tblSalon.getSelectionModel().getSelectedItem();
            this.directorEscenas.mostrarVentanaSalonAddUpdate(salon);

        }
    }

    public void eliminar() {
        if (this.tblSalon.getSelectionModel().getSelectedItem() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Salon");
            alert.setHeaderText(null);
            alert.setContentText("Debe Seleccionar un Elemento ");
            alert.initOwner(null);
            alert.show();
        } else {
            Salon salon = this.tblSalon.getSelectionModel().getSelectedItem();
            Conexion.getInstancia().eliminar(salon);
            this.directorEscenas.mostrarVentanaSalon();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Salon");
            alert.setHeaderText(null);
            alert.setContentText("Dato eliminado correctamente");
            alert.initOwner(null);
            alert.show();
        }
    }

}