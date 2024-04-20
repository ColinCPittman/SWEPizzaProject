package com.projectpizza.projectpizza;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
public class NewAccountPageController {


    public PasswordField passwordInput;
    public PasswordField passwordConfirmationInput;
    public TextField phoneInput;
    public TextField addressStreetInput;
    public TextField firstNameInput;
    public TextField lastNameInput;
    public TextField addressCityInput;
    public TextField addressStateInput;
    public TextField addressZipInput;
    public Text passwordErrorText;

    public void onSubmitButtonPress(ActionEvent event) {
        if (passwordInput.getText().isEmpty() ||
                passwordConfirmationInput.getText().isEmpty() ||
                !passwordInput.getText().equals(passwordConfirmationInput.getText())) {
            passwordErrorText.setText("Passwords do not match or are invalid.");
            return;
        }
        AccountHandler.addAccountToDatabase(phoneInput.getText(),
                                                passwordInput.getText(),
                                                firstNameInput.getText(),
                                                lastNameInput.getText(),
                                                addressStreetInput.getText(),
                                                addressCityInput.getText(),
                                                addressStateInput.getText(),
                                                addressZipInput.getText());
        Session.setPhoneNumber(phoneInput.getText());

        try{
            Parent menuPageSceneRoot = FXMLLoader.load(getClass().getResource("menu-page.fxml"));
            Scene menupageScene = new Scene(menuPageSceneRoot, 800, 600);

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(menupageScene);
            stage.show();
        }catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void onBackButtonPress(ActionEvent event) {
    }
}
