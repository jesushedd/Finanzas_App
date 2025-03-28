package org.vjhe.finanzas.controladores;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class GastosController {

    @FXML
    private TextField inputMonto;

    private DoubleProperty monto = new SimpleDoubleProperty();
}
