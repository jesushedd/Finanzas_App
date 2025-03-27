package org.vjhe.finanzas.controladores;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.vjhe.finanzas.ApplicationFinanzas;

import java.io.IOException;

public class PrincipalController {
    @FXML
    private Control lanzadorVentanaGastos;
    @FXML
    private Label welcomeText;




    private GastosController gastosController;

    private IngresosController ingresosController;

    @FXML
    private void abrirFormularioGasto() throws IOException {

        //obtener fxml
        FXMLLoader fxmlGasto =  new FXMLLoader(ApplicationFinanzas.class.getResource("formulario_gasto.fxml"));
        //checar si ya existe una ventana de gastos abierta
        if (gastosController != null){
            return;
        }
        Stage secondaryStage = crearStageSecundario(fxmlGasto, lanzadorVentanaGastos);
        secondaryStage.show();
    }
    /*
    * Carga la escena del fxml
    * Asigna el controlador de la nueva ventana
    * Esteablece a la ventada de @enStagePrimario como dueño del nueva ventana*/
    private Stage crearStageSecundario(FXMLLoader fxmlLoader, Control enStagePrimario) throws IOException{
        Stage stage = new Stage();
        stage.setScene(new Scene(fxmlLoader.load()));
        gastosController = fxmlLoader.getController();
        stage.initOwner(enStagePrimario.getScene().getWindow());
        //al cerrar la ventana
        stage.setOnCloseRequest(event -> {
            gastosController = null;
        });
        return stage;
    }

    @FXML
    private void abrirFormularioIngreso() throws IOException{

    }


    private boolean ventanaSecundaria = false;
}