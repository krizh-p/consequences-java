module com.krizhp.consequences {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.krizhp.consequences to javafx.fxml;
    exports com.krizhp.consequences;
}