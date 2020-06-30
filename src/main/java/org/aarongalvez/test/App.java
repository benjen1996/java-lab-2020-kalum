package org.aarongalvez.test;

import java.io.IOException;
import java.io.InputStream;

import org.aarongalvez.test.controllers.VentanaSalonAddUpdateController;
import org.aarongalvez.test.controllers.VentanaCareraAddUpdateController;
import org.aarongalvez.test.controllers.VentanaCarreraTecnicaController;
import org.aarongalvez.test.controllers.VentanaClaseController;
import org.aarongalvez.test.controllers.VentanaHorarioController;
import org.aarongalvez.test.controllers.VentanaInstructorAddUpdateController;
import org.aarongalvez.test.controllers.VentanaInstructorController;
import org.aarongalvez.test.controllers.VentanaPrincipalController;
import org.aarongalvez.test.controllers.VentanaSalonController;
import org.aarongalvez.test.models.CareraTecnica;
import org.aarongalvez.test.models.Instructor;
import org.aarongalvez.test.models.Salon;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.Initializable;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;

public class App extends Application {
    private Stage escenarioPrincipal;
    private final String PAQUETE_VISTAS = "/org/aarongalvez/test/Views/";

    public static void main(String[] args) {

        launch(args);

    }

    @Override
    public void start(Stage escenarioPrincipal) throws Exception {

        this.escenarioPrincipal = escenarioPrincipal;
        this.escenarioPrincipal.setTitle("Kalum v1.0.0");
        mostrarVentanaPrincipal();
        this.escenarioPrincipal.show();
    }

    public void mostrarVentanaPrincipal() {
        try {
            VentanaPrincipalController ventanaPrincipalView = (VentanaPrincipalController) cambiarEscena(
                    "VentanaPrincipalView.fxml", 640, 400);
            ventanaPrincipalView.setDirectorEscenas(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void mostrarVentanaSalon() {
        try {
            VentanaSalonController ventanaSalonView = (VentanaSalonController) cambiarEscena("SalonView.fxml", 640,
                    400);
            ventanaSalonView.setDirectorEscenas(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void mostrarVentanaSalonAddUpdate() {
        try {
            VentanaSalonAddUpdateController ventanaSalonAddUpdate = (VentanaSalonAddUpdateController) cambiarEscena(
                    "VentanaSalonAddUpdateView.fxml", 640, 400);
            ventanaSalonAddUpdate.setDirectorEscenas(this);

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    public void mostrarVentanaSalonAddUpdate(Salon salon) {
        try {
            VentanaSalonAddUpdateController ventanaSalonAddUpdate = (VentanaSalonAddUpdateController) cambiarEscena(
                    "VentanaSalonAddUpdateView.fxml", 640, 400);
            ventanaSalonAddUpdate.setDirectorEscenas(this);
            ventanaSalonAddUpdate.setSalon(salon);

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    public void mostrarVentanaCarrera() {
        try {
            VentanaCarreraTecnicaController ventanaCarreraView = (VentanaCarreraTecnicaController) cambiarEscena(
                    "CarreraTecnicaView.fxml", 640, 400);
            ventanaCarreraView.setDirectorEscenas(this);

        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public void mostrarVentanaCareraAddUpdate() {
        try {
            VentanaCareraAddUpdateController ventanacareraAddUpdate = (VentanaCareraAddUpdateController) cambiarEscena(
                    "VentanaCareraAddUpdateView.fxml", 640, 400);
            ventanacareraAddUpdate.setDirectorEscenas(this);

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    public void mostrarVentanaCareraAddUpdate(CareraTecnica carera) {
        try {
            VentanaCareraAddUpdateController ventanacareraAddUpdate = (VentanaCareraAddUpdateController) cambiarEscena(
                    "VentanaCareraAddUpdateView.fxml", 640, 400);
            ventanacareraAddUpdate.setDirectorEscenas(this);
            ventanacareraAddUpdate.setCarera(carera);

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    public void mostrarVentanaInstructor() {
        try {
            VentanaInstructorController ventanaInstructorView = (VentanaInstructorController) cambiarEscena(
                    "InstructorView.fxml", 640, 400);
            ventanaInstructorView.setDirectorEscenas(this);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void mostrarVentanaInstructorAddUpdate() {
        try {
            VentanaInstructorAddUpdateController ventanaInstructorAddUpdate = (VentanaInstructorAddUpdateController) cambiarEscena(
                    "VentanaInstructorAddUpdate.fxml", 645, 500);
            ventanaInstructorAddUpdate.setDirectorEscenas(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void mostrarVentanaInstructorAddUpdate(Instructor instructor) {
        try {
            VentanaInstructorAddUpdateController ventanaInstructorAddUpdate = (VentanaInstructorAddUpdateController) cambiarEscena(
                    "VentanaInstructorAddUpdate.fxml", 645, 500);
            ventanaInstructorAddUpdate.setDirectorEscenas(this);
            ventanaInstructorAddUpdate.setInstructor(instructor);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void mostrarVentanaHorario() {
        try {
            VentanaHorarioController ventanaHorarioView = (VentanaHorarioController) cambiarEscena("HorarioView.fxml",
                    640, 400);
            ventanaHorarioView.setDirectorEscenas(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void mostrarVentanaClase() {
        try {
            VentanaClaseController ventanaClaseView = (VentanaClaseController) cambiarEscena("ClaseView.fxml", 781,
                    519);
            ventanaClaseView.setDirectorEscenas(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Initializable cambiarEscena(String escena, int ancho, int alto) throws IOException {
        Initializable resultado = null;
        FXMLLoader cargadorFXML = new FXMLLoader();
        InputStream archivoFXML = App.class.getResourceAsStream(PAQUETE_VISTAS + escena);
        cargadorFXML.setBuilderFactory(new JavaFXBuilderFactory());
        cargadorFXML.setLocation(App.class.getResource(PAQUETE_VISTAS + escena));
        Scene miEscena = new Scene((AnchorPane) cargadorFXML.load(archivoFXML), ancho, alto);
        this.escenarioPrincipal.setScene(miEscena);
        this.escenarioPrincipal.sizeToScene();
        resultado = (Initializable) cargadorFXML.getController();
        return resultado;
    }
}
