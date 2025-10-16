/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package masodikora;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.shape.Circle;

/**
 *
 * @author szabi
 */
public class MasodikOraController implements Initializable {
    
    @FXML
    private Button upButton;
    @FXML
    private Button rightButton;
    @FXML
    private Button leftButton;
    @FXML
    private Button buttonButton;
    @FXML
    private Circle myCircle;
    
    private double x;
    private double y;
    
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        upButton.setOnAction(e -> {
            myCircle.setCenterY(y--);
        });
        rightButton.setOnAction(e -> {
            myCircle.setCenterX(x++);
        });
        buttonButton.setOnAction(e -> {
            myCircle.setCenterY(y++);
        });
        leftButton.setOnAction(e -> {
            myCircle.setCenterX(x--);
        });  
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
