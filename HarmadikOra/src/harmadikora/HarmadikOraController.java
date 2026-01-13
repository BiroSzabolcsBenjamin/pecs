/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package harmadikora;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author szabi
 */
public class HarmadikOraController implements Initializable {
    
    @FXML
    private TextField textField;
    @FXML
    private TextField textField1;
    @FXML
    private TextField textField2;
    
    @FXML
    private Button button;
    @FXML
    private Button resetButton;
    @FXML
    private Button plus;
    @FXML
    private Button minus;
    @FXML
    private Button reset;
    @FXML
    private Label label;
    @FXML
    private Button button6;
    @FXML
    private Button button7;
    @FXML
    private Button button8;
    @FXML
    private Button button9;
    @FXML
    private Button osszead;
    @FXML
    private Button kivon;
    @FXML
    private Button oszt;
    @FXML
    private Button szoroz;
    @FXML
    private Button button14;
    @FXML
    private Button button15;
    @FXML
    private Button button16;

    private int counter = 0;
    
    @FXML
    private void handleButton(ActionEvent event) {
       int a = Integer.parseInt(button.getId());
       int b = Integer.parseInt(textField2.getText());
       int c = Integer.parseInt(button.getText());
       
       
       
       textField.setText("eredmeny: " + (c));
    }
    @FXML
    private void handleOsszeadButton(ActionEvent event) {
       int a = Integer.parseInt(textField1.getText());
       int b = Integer.parseInt(textField2.getText());
       
       textField.setText("eredmeny: " + (a+b));
    }
    @FXML
    private void handleKivonButton(ActionEvent event) {
       int a = Integer.parseInt(textField1.getText());
       int b = Integer.parseInt(textField2.getText());
       
       textField.setText("eredmeny: " + (a-b));
       
    }
    @FXML
    private void handleOsztButton(ActionEvent event) {
       int a = Integer.parseInt(textField1.getText());
       int b = Integer.parseInt(textField2.getText());
       
       textField.setText("eredmeny: " + (a/b));
       
    }
    @FXML
    private void handleSzorozButton(ActionEvent event) {
       int a = Integer.parseInt(textField1.getText());
       int b = Integer.parseInt(textField2.getText());
       
       textField.setText("eredmeny: " + (a*b));
       
    }
    @FXML
    private void handleResetButton(ActionEvent event) {
       textField.setText("");
       textField1.setText("");
       textField2.setText("");
       
    }
    
    
//    @FXML
//    private void handleButtonPlus(ActionEvent event) {
//       int num = Integer.parseInt(label.getText());
//       num++;
//       label.setText(Integer.toString(num));
//       
//    }
//    @FXML
//    private void handleButtonMinus(ActionEvent event) {
//       int num = Integer.parseInt(label.getText());
//       num--;
//       label.setText(Integer.toString(num));
//    }
//    @FXML
//    private void handleReset(ActionEvent event) {      
//       label.setText("0");
//    }
    
    @FXML
    private void handleButtonPlus(ActionEvent event) {
       counter++;
       label.setText(Integer.toString(counter));
       
    }
    @FXML
    private void handleButtonMinus(ActionEvent event) {

       counter--;
       label.setText(Integer.toString(counter));
    }
    @FXML
    private void handleReset(ActionEvent event) { 
        counter = 0;
       label.setText(Integer.toString(counter));
    }
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
