package org.aarongalvez.test.controllers;

import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.ResourceBundle;
import java.util.UUID;

import org.aarongalvez.test.App;
import org.aarongalvez.test.db.Conexion;
import org.aarongalvez.test.models.Horario;

import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.fxml.FXML;

public class VentanaHorarioAddUpdateController implements Initializable {

    @FXML
    private TextField txtHorarioInicio;

    @FXML
    private TextField txtHorarioFinal;

    private App directorEscenas;
    private Horario horarios;
    private DateFormat horarioFormat = new SimpleDateFormat("HH:mm");

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void guardar() {
        Date hoInicio;
        Date hoFinal;
        String inicioH = txtHorarioInicio.getText();
        String finalH = txtHorarioFinal.getText();

        if (txtHorarioInicio.getText().isEmpty() || txtHorarioFinal.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Clase");
            alert.setHeaderText(null);
            alert.setContentText("Error, Todos los campos tienen que ser llenados para continuar");
            alert.initOwner(null);
            alert.show();

        } else {
            if (horarios != null) {

                try {

                    hoInicio = horarioFormat.parse(inicioH);
                    hoFinal = horarioFormat.parse(finalH);
                    horarios.setHorarioInicio(hoInicio);
                    horarios.setHorarioFinal(hoFinal);

                } catch (ParseException e) {

                    e.printStackTrace();
                }
                Conexion.getInstancia().modificar(horarios);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Horario");
                alert.setHeaderText(null);
                alert.setContentText("Registo Modificado Correctamente");
                alert.initOwner(null);
                alert.show();
                this.directorEscenas.mostrarVentanaHorario();

            } else {

                horarios = new Horario();
                horarios.setHorarioId(UUID.randomUUID().toString());
                try {
                    hoInicio = horarioFormat.parse(inicioH);
                    hoFinal = horarioFormat.parse(finalH);
                    horarios.setHorarioInicio(hoInicio);
                    horarios.setHorarioFinal(hoFinal);

                } catch (ParseException e) {

                    e.printStackTrace();
                }
                Conexion.getInstancia().agregar(horarios);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Horario");
                alert.setHeaderText(null);
                alert.setContentText("Registo Almacenado Correctamente");
                alert.initOwner(null);
                alert.show();
                this.directorEscenas.mostrarVentanaHorario();

            }
        }
    }

    public void cancelar() {
        this.directorEscenas.mostrarVentanaHorario();
    }

    public App getDirectorEscenas() {
        return directorEscenas;
    }

    public void setDirectorEscenas(App directorEscenas) {
        this.directorEscenas = directorEscenas;
    }

    public Horario getHorarios() {
        return horarios;
    }

    public void setHorarios(Horario horarios) {
        Date hoInicio;
        Date hoFinal;
        String inicioH = txtHorarioInicio.getText();
        String finalH = txtHorarioFinal.getText();
        this.horarios = horarios;
        try {

            hoInicio = horarioFormat.parse(inicioH);
            hoFinal = horarioFormat.parse(finalH);
            horarios.setHorarioInicio(hoInicio);
            horarios.setHorarioFinal(hoFinal);

        } catch (ParseException e) {

            e.printStackTrace();
        }
    }

}