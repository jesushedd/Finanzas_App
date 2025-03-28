module org.vjhe.finanzas {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.sql;


    opens org.vjhe.finanzas to javafx.fxml;
    exports org.vjhe.finanzas;
    exports org.vjhe.finanzas.controladores;
    opens org.vjhe.finanzas.controladores to javafx.fxml;
}