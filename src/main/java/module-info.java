module org.vjhe.finanzas {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.checkerframework.checker.qual;
    requires org.apache.commons.text;
    requires org.apache.commons.lang3;


    opens org.vjhe.finanzas to javafx.fxml;
    exports org.vjhe.finanzas;
    exports org.vjhe.finanzas.controladores;
    opens org.vjhe.finanzas.controladores to javafx.fxml;
}