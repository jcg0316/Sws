package team3.swS.lvoca.main;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;

public class AnotherWordBookController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private VBox popWordBook;

    @FXML
    private TableView<?> tableviewFile;

    @FXML
    private TableColumn<?, ?> fileNameCol;

    @FXML
    private Button addLvoca;

    @FXML
    void initialize() {
        assert popWordBook != null : "fx:id=\"popWordBook\" was not injected: check your FXML file 'anotherWordBook.fxml'.";
        assert tableviewFile != null : "fx:id=\"tableviewFile\" was not injected: check your FXML file 'anotherWordBook.fxml'.";
        assert fileNameCol != null : "fx:id=\"fileNameCol\" was not injected: check your FXML file 'anotherWordBook.fxml'.";
        assert addLvoca != null : "fx:id=\"addLvoca\" was not injected: check your FXML file 'anotherWordBook.fxml'.";

    }
}
