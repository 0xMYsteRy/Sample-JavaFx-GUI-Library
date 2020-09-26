import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PView extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("PView.fxml")), 1200, 300);
        primaryStage.setTitle("Sample GUI Library");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}