/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package onallo1;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;

/**
 *
 * @author szabi
 */
public class onallo1Controller implements Initializable {
    
    @FXML
    private Label labelOut;
    @FXML
    private Button selectLeft;
    @FXML
    private Button todayLeft;
    @FXML
    private Button resetLeft;
    @FXML
    private Button defaultLeft;
    @FXML
    private Button compareBtn;
    @FXML
    private Button selectRight;
    @FXML
    private Button todayRghit;
    @FXML
    private Button resetRghit;
    @FXML
    private Button defaultRghit;
    @FXML
    private DatePicker dateLeft;
    @FXML
    private DatePicker dateRight;
    
    @FXML
    private void handleSelectLeftButton(ActionEvent event) {
        String date = dateLeft.getValue().toString();
        
        labelOut.setText(date);
    }
    @FXML
    private void handleResetLeftButton(ActionEvent event) {
        dateLeft.setValue(null);
        labelOut.setText(null);
    }
    @FXML
    private void handleTodayLeftButton(ActionEvent event) {
        dateLeft.setValue(LocalDate.now());
    }
    @FXML
    private void handleDefaultLeftButton(ActionEvent event) {
        dateLeft.setValue(LocalDate.parse("2007-03-18"));
    }
    
    
    @FXML
    private void handleSelectRightButton(ActionEvent event) {
        String date = dateRight.getValue().toString();
        
        labelOut.setText(date);
    }
    @FXML
    private void handleResetRightButton(ActionEvent event) {
        dateRight.setValue(null);
        labelOut.setText(null);
    }
    @FXML
    private void handleTodayRightButton(ActionEvent event) {
        dateRight.setValue(LocalDate.now());
    }
    @FXML
    private void handleDefaultRightButton(ActionEvent event) {
        dateRight.setValue(LocalDate.parse("2007-03-18"));
    }
    
    @FXML
    private void handleCompareButton(ActionEvent event) {
        LocalDate left = dateLeft.getValue();
        LocalDate right = dateRight.getValue();
        
        if (left.isBefore(right)) {
            labelOut.setText(right.toString() + " a jobb oldali nagyobb");
        } else if (right.isBefore(left)) {
            labelOut.setText(left.toString() + " a bal oldali nagyobb");
        } else {
            labelOut.setText("Egyenlő");
        }
        
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
