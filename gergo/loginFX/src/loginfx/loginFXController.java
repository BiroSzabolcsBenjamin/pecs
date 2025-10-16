/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package loginfx;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 *
 * @author szabi
 */
public class loginFXController implements Initializable {

    @FXML
    private Label outputLabel;
    @FXML
    private Button registerButton;
    @FXML
    private TextField registerName;
    @FXML
    private PasswordField registerPassword;
    @FXML
    private DatePicker birthDate;
    @FXML
    private CheckBox checkbox;

    @FXML
    private void handleRegister(ActionEvent event) {

        String name = registerName.getText();
        String password = registerPassword.getText();
        LocalDate date = birthDate.getValue();
        boolean adomentes = checkbox.isSelected();

        if (name.isEmpty() && password.isEmpty() && date == null) {
            outputLabel.setText("Kérlek add meg az összes adatot!");
        } else if (name.isEmpty()) {
            outputLabel.setText("Kérlek adj meg egy nevet");
        } else if (password.isEmpty()) {
            outputLabel.setText("Kérlek adj meg egy jelszót!");
        } else if (date == null) {
            outputLabel.setText("Kérlek adj meg egy születési dátumot");
        } else if (name.isEmpty() && password.isEmpty()) {
            outputLabel.setText("Kérlek adj meg egy nevet és jelszót");
        } else if (name.isEmpty() && date == null) {
            outputLabel.setText("Kérlek adj meg egy nevet és születési dátumot");
        } else if (password.isEmpty() && date == null) {
            outputLabel.setText("Kérlek adj meg egy jelaszót egy és születési dátumot");
        } else {
            outputLabel.setText("Sikeresen regisztrált!\n" + name + "\n" + password + "\n" + date + "\n" + adomentes);

        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
