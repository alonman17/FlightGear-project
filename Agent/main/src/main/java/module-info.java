module tirgul.mvc {
    requires javafx.controls;
    requires javafx.fxml;

    opens tirgul.mvc to javafx.fxml;
    exports tirgul.mvc;
}
