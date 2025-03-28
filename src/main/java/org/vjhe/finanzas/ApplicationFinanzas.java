package org.vjhe.finanzas;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class ApplicationFinanzas extends Application {



    @Override
    public void start(Stage stage) throws IOException, InterruptedException {
        FXMLLoader fxmlLoader = new FXMLLoader(ApplicationFinanzas.class.getResource("principal.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.setTitle("Mis Finanzas");
        //Set tamaños minimos de la ventana
        stage.setMinHeight(672);
        stage.setMinWidth(638);
        stage.show();
    }



    public static void main(String[] args) {
        launch();
    }
}