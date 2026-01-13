/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package listak;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

/**
 *
 * @author szabi
 */
public class listakFxController implements Initializable {
    
    @FXML
    private Label label;
    @FXML
    private Button addButton;
    @FXML
    private TextField nameInput;
    @FXML
    private ListView<String> nameListView;
    @FXML
    private Label errorMsg;
    
    private ObservableList<String> nameList = FXCollections.observableArrayList();
    
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
       
        String name = nameInput.getText();
        
        if (!name.isEmpty()) {
            nameList.add(name);
            nameInput.clear();
        } else {
            errorMsg.setText("Adj meg egy értéket!");
        }
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        nameListView.setItems(nameList);
    }    
    
}
