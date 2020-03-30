package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.getIcons().add(new Image("https://cdn2.iconfinder.com/data/icons/ancient-greek-mythology-monsters-and-creatures/892/dragon-001-512.png"));
        primaryStage.setTitle("Sortowanie");
        primaryStage.setScene(new Scene(root, 373, 618));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
