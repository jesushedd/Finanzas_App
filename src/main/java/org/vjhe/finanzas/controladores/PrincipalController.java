package org.vjhe.finanzas.controladores;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Control;
import javafx.stage.Stage;
import org.vjhe.finanzas.ApplicationFinanzas;

import java.io.IOException;

public class PrincipalController {
    @FXML
    private Control lanzadorVentanaGastos;


    private GastosController gastosController;

    private IngresosController ingresosController;

    @FXML
    private void abrirFormularioGasto() throws IOException {

        //obtener fxml
        FXMLLoader fxmlGasto =  new FXMLLoader(ApplicationFinanzas.class.getResource("formulario_gasto.fxml"));
        //checar si ya existe una ventana de gastos abierta
        if (gastosController != null){
            //traer al frente la ventana ya existente
            return;
        }
        Stage secondaryStage = crearStageSecundario(fxmlGasto, lanzadorVentanaGastos);
        secondaryStage.setResizable(false);
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


        //stage.setScene(new Scene(new VentanaNuevoGasto().getRoot()));

        stage.initOwner(enStagePrimario.getScene().getWindow());
        //al cerrar la ventana
        stage.setOnCloseRequest(event -> {
            System.out.println(stage.getHeight());
            System.out.println(stage.getWidth());
            gastosController = null;
        });
        return stage;
    }

    @FXML
    private void abrirFormularioIngreso() throws IOException{

    }


    private boolean ventanaSecundaria = false;
}