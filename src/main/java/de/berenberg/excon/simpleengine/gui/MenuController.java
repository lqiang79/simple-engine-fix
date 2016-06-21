package de.berenberg.excon.simpleengine.gui;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MenuController {

    @FXML // fx:id="mClose"
    private MenuItem mClose; // Value injected by FXMLLoader

    @FXML
    void closeApp(ActionEvent event) {
        log.debug("closeApp");
        Platform.exit();
    }

}
