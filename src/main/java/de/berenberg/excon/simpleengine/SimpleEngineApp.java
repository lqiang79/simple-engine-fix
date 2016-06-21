package de.berenberg.excon.simpleengine;

import de.berenberg.excon.simpleengine.engine.EngineService;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * Created by qiangli on 21/06/16.
 */
@SpringBootApplication
public class SimpleEngineApp extends Application {

    EngineService engineService;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("gui/main.fxml"));
        primaryStage.setTitle("Simple FIX Engine");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();

        engineService = new EngineService();
        engineService.init();
    }

    public static void main(String[] args) {
        SpringApplication.run(SimpleEngineApp.class, args);
        launch(args);

    }
}
