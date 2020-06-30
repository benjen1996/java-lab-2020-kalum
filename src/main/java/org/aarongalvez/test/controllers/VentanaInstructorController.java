package org.aarongalvez.test.controllers;

import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import org.aarongalvez.test.App;
import org.aarongalvez.test.db.Conexion;
import org.aarongalvez.test.models.Instructor;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

public class VentanaInstructorController implements Initializable {

    private App directorEscenas;
    private ObservableList<Instructor> listaInstructores;

    @FXML
    private TableView<Instructor> tblInstructor;
    @FXML
    private TableColumn<Instructor, String> colApellidos;
    @FXML
    private TableColumn<Instructor, String> colNombres;
    @FXML
    private TableColumn<Instructor, String> colTelefonos;
    @FXML
    private TableColumn<Instructor, String> colDireccion;
    @FXML
    private TableColumn<Instructor, String> colFoto;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        listaInstructores = FXCollections
                .observableArrayList((List<Instructor>) Conexion.getInstancia().findAll("Instructor.findAll"));

        this.tblInstructor.setItems(listaInstructores);

        this.colApellidos.setCellValueFactory(cellApellidos -> cellApellidos.getValue().apellidos());
        this.colNombres.setCellValueFactory(cellNombres -> cellNombres.getValue().nombres());
        this.colTelefonos.setCellValueFactory(cellTelefonos -> cellTelefonos.getValue().telefono());
        this.colDireccion.setCellValueFactory(cellDireccion -> cellDireccion.getValue().direccion());
        this.colFoto.setCellValueFactory(cellTelefono -> cellTelefono.getValue().foto());
    }

    public void mostrarVentanaInstructorAddUpdate() {
        this.directorEscenas.mostrarVentanaInstructorAddUpdate();
    }

    public void modificar() {
        if (this.tblInstructor.getSelectionModel().getSelectedItem() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Salon");
            alert.setHeaderText(null);
            alert.setContentText("Debe Seleccionar un Elemento ");
            alert.initOwner(null);
            alert.show();

        } else {
            Instructor instructor = this.tblInstructor.getSelectionModel().getSelectedItem();
            this.directorEscenas.mostrarVentanaInstructorAddUpdate(instructor);
        }
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

}