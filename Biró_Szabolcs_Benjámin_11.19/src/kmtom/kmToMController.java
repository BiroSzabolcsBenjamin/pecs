/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package kmtom;

import static java.lang.Integer.parseInt;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import static javax.xml.bind.DatatypeConverter.parseDouble;

/**
 *
 * @author szabi
 */
public class kmToMController implements Initializable {

    @FXML
    private Label label;

    @FXML
    private Button resetButton;
    @FXML
    private TextField mInput;
    @FXML
    private TextField kmInput;
    @FXML
    private Button calculateMeterButton;
    @FXML
    private Button calculateKilometerButton;
    @FXML
    private Label mText;
    @FXML
    private Label kmText;

    @FXML
    private void resetButtonAction(ActionEvent event) {
        mInput.clear();
        kmInput.clear();
        mText.setText("");
        kmText.setText("");

    }

    @FXML
    private void calculateMeterButtonAction(ActionEvent event) {
        double kilometer = parseDouble(kmInput.getText());

        String kmInMeter = Double.toString(kilometer * 1000.0);

        mText.setText(kilometer + " kilométer " + kmInMeter + " méter");
    }

    @FXML
    private void calculateKilometerButtonAction(ActionEvent event) {
        double meter = parseDouble(mInput.getText());
        String meterInKm = Double.toString(meter / 1000.0);

        kmText.setText(meter + " méter " + meterInKm + " kilométer");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
