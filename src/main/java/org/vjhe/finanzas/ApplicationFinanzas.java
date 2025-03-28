package org.vjhe.finanzas;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.vjhe.finanzas.controladores.GastosController;
import org.vjhe.finanzas.controladores.PrincipalController;
import org.vjhe.finanzas.modelo.ViewModel;

import java.io.IOException;

public class ApplicationFinanzas extends Application {
    private Parent rootPrincipal;
    private Parent rootGastos;
    private ViewModel modelo;
    private PrincipalController principalController;
    private GastosController gastosController;
    private Stage secondaryStage;


    @Override
    public void start(Stage primaryStage) throws IOException {

        modelo = new ViewModel();
        //Cargar controlador y escena principal
        FXMLLoader loaderPrincipal = new FXMLLoader(ApplicationFinanzas.class.getResource("principal.fxml"));
        rootPrincipal = loaderPrincipal.load();
        principalController = loaderPrincipal.getController();
        principalController.setModelo(modelo);
        Scene principalScene = new Scene(rootPrincipal);

        //Cargar controlador y escena secundaria
        FXMLLoader loaderGastos = new FXMLLoader(ApplicationFinanzas.class.getResource("formulario_gasto.fxml"));
        rootGastos = loaderGastos.load();
        gastosController  = loaderGastos.getController();
        gastosController.setViewModel(modelo);
        gastosController.setChoiceBox();

        Scene gastosScene = new Scene(rootGastos);

        //configurar ventana secundaria
        secondaryStage = new Stage();
        secondaryStage.setResizable(false);
        secondaryStage.initOwner(primaryStage);

        //Asiganr listener para mostrar scena Nuevo Gasto si el modelo lo requiere
        modelo.ventanaGastosPoperty().addListener((observable, oldValue, newValue) -> {
            if (newValue){
                secondaryStage.setScene(gastosScene);
                secondaryStage.setOnCloseRequest(event -> {
                    modelo.setVentanaGastos(false);
                });
                secondaryStage.setTitle("Nuevo Egreso");
                secondaryStage.show();
            } else secondaryStage.close();
        });

        //configurar y mostrar ventana pricipal
        primaryStage.setScene(principalScene);
        primaryStage.setTitle("Mis Finanzas");
        primaryStage.setMinHeight(672);
        primaryStage.setMinWidth(638);
        primaryStage.show();
    }



    public static void main(String[] args) {
        launch();
    }
}