package org.aarongalvez.test.controllers;

import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import org.aarongalvez.test.App;
import org.aarongalvez.test.db.Conexion;
import org.aarongalvez.test.models.Horario;

import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class VentanaHorarioController implements Initializable {

    private App directorEscenas;
    private ObservableList<Horario> listaHorarios;

    @FXML
    private TableView<Horario> tblHorario;
    @FXML
    private TableColumn<Horario, String> colHorarioInicio;
    @FXML
    private TableColumn<Horario, String> ColHorarioFInal;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        DateFormat horario = new SimpleDateFormat("HH:mm");
        
        listaHorarios = FXCollections
                .observableArrayList((List<Horario>) Conexion.getInstancia().findAll("Horario.findAll"));
        this.tblHorario.setItems(listaHorarios);

        this.colHorarioInicio.setCellValueFactory(cellHorarioInicio -> new ReadOnlyStringWrapper(horario.format(cellHorarioInicio.getValue().getHorarioInicio())));
        this.ColHorarioFInal.setCellValueFactory(cellHorarioFinal ->new ReadOnlyStringWrapper(horario.format(cellHorarioFinal.getValue().getHorarioFinal())));
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