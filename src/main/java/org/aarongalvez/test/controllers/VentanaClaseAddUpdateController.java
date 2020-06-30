package org.aarongalvez.test.controllers;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.UUID;

import org.aarongalvez.test.App;
import org.aarongalvez.test.db.Conexion;
import org.aarongalvez.test.models.CareraTecnica;
import org.aarongalvez.test.models.Clase;
import org.aarongalvez.test.models.Horario;
import org.aarongalvez.test.models.Instructor;
import org.aarongalvez.test.models.Salon;

import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

public class VentanaClaseAddUpdateController implements Initializable {

    @FXML
    private ComboBox<CareraTecnica> cmbCarreraTecnica;
    @FXML
    private TextField txtDescripcion;
    @FXML
    private TextField txtCupoMax;
    @FXML
    private TextField txtCupoMin;
    @FXML
    private TextField txtCiclo;
    @FXML
    private ComboBox<Instructor> cmbInstructor;
    @FXML
    private ComboBox<Horario> cmbHorario;
    @FXML
    private ComboBox<Salon> cmbSalon;

    private App directorEscenas;

    private ObservableList<CareraTecnica> carrerasTecnicas;
    private ObservableList<Instructor> instructores;
    private ObservableList<Horario> horarios;
    private ObservableList<Salon> salones;
    private Clase clase = null;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        carrerasTecnicas = FXCollections.observableArrayList
        ((List<CareraTecnica>)Conexion.getInstancia().findAll("CareraTecnica.findAll"));
        this.cmbCarreraTecnica.setItems(carrerasTecnicas);
        instructores = FXCollections.observableArrayList((List<Instructor>)Conexion.getInstancia().findAll("Instructor.findAll"));
        this.cmbInstructor.setItems(instructores);
        horarios = FXCollections.observableArrayList((List<Horario>)Conexion.getInstancia().findAll("Horario.findAll"));
        this.cmbHorario.setItems(horarios);
        salones = FXCollections.observableArrayList((List<Salon>)Conexion.getInstancia().findAll("Salon.findAll"));
        this.cmbSalon.setItems(salones);

    }

    public void agregar()
    {
        if (clase == null) {
            clase = new Clase();
            clase.setClaseId(UUID.randomUUID().toString());
            clase.setDescripcion(txtDescripcion.getText());
            clase.setCupoMaximo(Integer.parseInt(txtCupoMax.getText()));
            clase.setCupoMinimo(Integer.parseInt(txtCupoMin.getText()));
            clase.setCiclo(Integer.parseInt(txtCiclo.getText()));
            clase.setCarrera(this.cmbCarreraTecnica.getSelectionModel().getSelectedItem());
            clase.setInstructor(this.cmbInstructor.getSelectionModel().getSelectedItem());
            clase.setHorario(this.cmbHorario.getSelectionModel().getSelectedItem());
            clase.setSalon(this.cmbSalon.getSelectionModel().getSelectedItem());
            Conexion.getInstancia().agregar(clase);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Carera");
            alert.setHeaderText(null);
            alert.setContentText("Registo Modificado Correctamente");
            alert.initOwner(null);
            alert.show();
            this.directorEscenas.mostrarVentanaClase();

        }
    }


    public void cancelar() {
        this.directorEscenas.mostrarVentanaClase();
    }

    public App getDirectorEscenas() {
        return directorEscenas;
    }

    public void setDirectorEscenas(App directorEscenas) {
        this.directorEscenas = directorEscenas;
    }

}