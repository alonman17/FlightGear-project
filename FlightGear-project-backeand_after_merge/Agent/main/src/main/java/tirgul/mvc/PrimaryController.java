package tirgul.mvc;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class PrimaryController {

    @FXML
    Canvas joystick = new Canvas();

    void paint() throws IOException {
        GraphicsContext gc = joystick.getGraphicsContext2D();
        double mx = joystick.getWidth() / 2;
        double my = joystick.getHeight() / 2;
        gc.strokeOval(mx - 50, my - 50, 100, 100);
    }
}
