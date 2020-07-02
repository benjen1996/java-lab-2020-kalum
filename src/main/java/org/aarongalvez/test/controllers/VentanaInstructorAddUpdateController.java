package org.aarongalvez.test.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.UUID;

import org.aarongalvez.test.App;
import org.aarongalvez.test.db.Conexion;
import org.aarongalvez.test.models.Instructor;

import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.fxml.FXML;

public class VentanaInstructorAddUpdateController implements Initializable {

    private App directorEscenas;

    private Instructor instructor;

    @FXML
    private TextField txtApellidos;

    @FXML
    private TextField txtNombres;
    @FXML
    private TextField txtTelefono;
    @FXML
    private TextField txtDireccion;
    @FXML
    private TextField txtFoto;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void cancelar() {
        this.directorEscenas.mostrarVentanaInstructor();
    }

    public void guardar() {
        if (txtApellidos.getText().isEmpty() || txtNombres.getText().isEmpty() || txtTelefono.getText().isEmpty()
                || txtDireccion.getText().isEmpty() || txtFoto.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Instructor");
            alert.setHeaderText(null);
            alert.setContentText("Error, Todos los campos tienen que llenarse");
            alert.initOwner(null);
            alert.show();
        } else {
            if (instructor != null) {

                instructor.setApellidos(txtApellidos.getText());
                instructor.setNombres(txtNombres.getText());
                instructor.setTelefono(txtTelefono.getText());
                instructor.setDireccion(txtDireccion.getText());
                instructor.setFoto(txtFoto.getText());
                Conexion.getInstancia().modificar(instructor);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Salon");
                alert.setHeaderText(null);
                alert.setContentText("Registo Modificado Correctamente");
                alert.initOwner(null);
                alert.show();
                this.directorEscenas.mostrarVentanaInstructor();
            } else {
                instructor = new Instructor();
                instructor.setInstructorId(UUID.randomUUID().toString());
                instructor.setApellidos(txtApellidos.getText());
                instructor.setNombres(txtNombres.getText());
                instructor.setTelefono(txtTelefono.getText());
                instructor.setDireccion(txtDireccion.getText());
                instructor.setFoto(txtFoto.getText());
                Conexion.getInstancia().agregar(instructor);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Instructor");
                alert.setHeaderText(null);
                alert.setContentText("Registo Almacenado Correctamente");
                alert.initOwner(null);
                alert.show();
                this.directorEscenas.mostrarVentanaInstructor();
            }

        }
    }

    public App getDirectorEscenas() {
        return directorEscenas;
    }

    public void setDirectorEscenas(App directorEscenas) {
        this.directorEscenas = directorEscenas;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
        this.txtApellidos.setText(instructor.getApellidos());
        this.txtNombres.setText(instructor.getNombres());
        this.txtTelefono.setText(instructor.getTelefono());
        this.txtDireccion.setText(instructor.getDireccion());
        this.txtFoto.setText(instructor.getFoto());
    }

}