package org.aarongalvez.test.controllers;

import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ResourceBundle;

import org.aarongalvez.test.App;
import org.aarongalvez.test.db.Conexion;
import org.aarongalvez.test.models.Clase;

import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

public class VentanaClaseController implements Initializable {
    @FXML
    private TableView<Clase> tblClases;
    @FXML
    private TableColumn<Clase, String> colDescripcion;
    @FXML
    private TableColumn<Clase, String> colCarrera;
    @FXML
    private TableColumn<Clase, String> colInstructor;
    @FXML
    private TableColumn<Clase, String> colHorario;
    @FXML
    private TableColumn<Clase, String> colSalon;
    @FXML
    private TableColumn<Clase, Number> colCiclo;
    @FXML
    private TableColumn<Clase, Number> colCupoMaximo;
    @FXML
    private TableColumn<Clase, Number> colCupoMinimo;

    private ObservableList<Clase> listaClases;

    private App directorEscenas;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        DateFormat horario = new SimpleDateFormat("HH:mm");

        this.listaClases = FXCollections
                .observableArrayList((List<Clase>) Conexion.getInstancia().findAll("Clase.findAll"));
        this.tblClases.setItems(this.listaClases);
        this.colSalon.setCellValueFactory(cellSalon -> cellSalon.getValue().getSalon().nombreSalon());
        this.colCiclo.setCellValueFactory(cellCiclo -> cellCiclo.getValue().ciclo());
        this.colDescripcion.setCellValueFactory(cellDescripcion -> cellDescripcion.getValue().descripcion());
        this.colCarrera.setCellValueFactory(cellCarrera -> cellCarrera.getValue().getCarrera().nombreCarrera());
        this.colCupoMinimo.setCellValueFactory(cellCupoMin -> cellCupoMin.getValue().cupoMinimo());
        this.colCupoMaximo.setCellValueFactory(cellCupoMax -> cellCupoMax.getValue().cupoMaximo());
        this.colHorario.setCellValueFactory(cellHorario -> new ReadOnlyStringWrapper(
                horario.format(cellHorario.getValue().getHorario().getHorarioInicio()) + "-"
                        + horario.format(cellHorario.getValue().getHorario().getHorarioFinal())));
        this.colInstructor.setCellValueFactory(
                cellInstructor -> new ReadOnlyStringWrapper(cellInstructor.getValue().getInstructor().getApellidos()
                        + " " + cellInstructor.getValue().getInstructor().getNombres()));

    }

    public void modificar() {
        if (this.tblClases.getSelectionModel().getSelectedItem() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Clase");
            alert.setHeaderText(null);
            alert.setContentText("Debe Seleccionar un Elemento ");
            alert.initOwner(null);
            alert.show();
        } else {
            Clase clase = this.tblClases.getSelectionModel().getSelectedItem();
            this.directorEscenas.mostrarVentanaClaseAddUpdate(clase);
        }
    }

    public void eliminar() {
        if (this.tblClases.getSelectionModel().getSelectedItem() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Clase");
            alert.setHeaderText(null);
            alert.setContentText("Debe Seleccionar un Elemento ");
            alert.initOwner(null);
            alert.show();
        } else {
            Clase clase = this.tblClases.getSelectionModel().getSelectedItem();
            Conexion.getInstancia().eliminar(clase);
            this.directorEscenas.mostrarVentanaClase();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Clase");
            alert.setHeaderText(null);
            alert.setContentText("Clase Eliminada correctamente ");
            alert.initOwner(null);
            alert.show();
        }
    }

    public void mostrarVentanaPrincipal() {
        this.directorEscenas.mostrarVentanaPrincipal();
    }

    public void mostrarVentanaClaseAddUpdate() {
        this.directorEscenas.mostrarVentanaClaseAddUpdate();
    }

    public App getDirectorEscenas() {
        return directorEscenas;
    }

    public void setDirectorEscenas(App directorEscenas) {
        this.directorEscenas = directorEscenas;
    }

}