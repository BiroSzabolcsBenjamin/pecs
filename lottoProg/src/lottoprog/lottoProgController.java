/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package lottoprog;

import static java.lang.Integer.parseInt;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Set;
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
public class lottoProgController implements Initializable {

    @FXML
    private Label label;

    @FXML
    private TextField numOne;
    @FXML
    private TextField numTwo;
    @FXML
    private TextField numThree;
    @FXML
    private TextField numFour;
    @FXML
    private TextField numFive;

    @FXML
    private Label firstNum;
    @FXML
    private Label secondNum;
    @FXML
    private Label thirdNum;
    @FXML
    private Label fourthNum;
    @FXML
    private Label fifthNum;

    @FXML
    private Label talalatOut;
    @FXML
    private Label resultOut;

    @FXML
    private Button sorsolasBtn;

    @FXML
    private void handleButtonAction(ActionEvent event) {
        try {
            int one = Integer.parseInt(numOne.getText());
            int two = Integer.parseInt(numTwo.getText());
            int three = Integer.parseInt(numThree.getText());
            int four = Integer.parseInt(numFour.getText());
            int five = Integer.parseInt(numFive.getText());

            Set<Integer> inputSet = new HashSet<>(Arrays.asList(one, two, three, four, five));
            if (inputSet.size() < 5) {
                talalatOut.setText("Csak különböző számokat adhatsz meg!");
                return;
            }


            if (one < 1 || one > 90
                    || two < 1 || two > 90
                    || three < 1 || three > 90
                    || four < 1 || four > 90
                    || five < 1 || five > 90) {
                resultOut.setText("Csak 1 és 90 között adhatsz meg számo(ka)t!");
                return;
            }

            Random random = new Random();
            ArrayList<Integer> sorsoltSzamok = new ArrayList<>();

            while (sorsoltSzamok.size() < 5) {
                int rand = random.nextInt(90) + 1;
                if (!sorsoltSzamok.contains(rand)) {
                    sorsoltSzamok.add(rand);
                }
            }

            firstNum.setText(String.valueOf(sorsoltSzamok.get(0)));
            secondNum.setText(String.valueOf(sorsoltSzamok.get(1)));
            thirdNum.setText(String.valueOf(sorsoltSzamok.get(2)));
            fourthNum.setText(String.valueOf(sorsoltSzamok.get(3)));
            fifthNum.setText(String.valueOf(sorsoltSzamok.get(4)));

            int talalat = 0;
            for (Integer szam : inputSet) {
                if (sorsoltSzamok.contains(szam)) {
                    talalat++;
                }
            }
            
            resultOut.setText("Találatok: " + talalat);
            
            String emoji;
            switch (talalat) {
                case 0 :
                    emoji = "D:";
                    break;
                case 1:
                    emoji = ":(";
                    break;
                case 2 : 
                    emoji= ":/";
                    break;
                case 3 :
                    emoji= ":)";
                    break;
                case 4 :
                    emoji = ":D";
                    break;
                case 5 :
                    emoji= "<o>";
                    break;
                default : 
                    emoji = "";
            };

            talalatOut.setText(emoji);

        } catch (NumberFormatException e) {
            resultOut.setText("Csak számot adhatsz meg!");
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
