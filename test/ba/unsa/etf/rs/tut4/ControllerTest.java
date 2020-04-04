package ba.unsa.etf.rs.tut4;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(ApplicationExtension.class)
class ControllerTest {
    @Start
    public void start (Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/shop.fxml"));
        stage.setTitle("Kasa");
        stage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        stage.show();
        stage.toFront();
    }

    @Test
    void ArtikalTabTest(FxRobot robot){
        Button btnIzbaci1 = robot.lookup("#btnIzbaci").queryAs(Button.class);
        TextArea beforeFld = robot.lookup("#beforeIzbaciArea").queryAs(TextArea.class);
        TextArea afterFld = robot.lookup("#afterIzbaciArea").queryAs(TextArea.class);
        assertNotNull(btnIzbaci1);
        assertNotNull(beforeFld);
        assertNotNull(afterFld);
    }
}
