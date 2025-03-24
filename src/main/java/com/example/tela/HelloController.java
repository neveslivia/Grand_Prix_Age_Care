package com.example.tela;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import java.io.IOException;

public class HelloController {

    public Label handleLabelClick;

    @FXML
    private void TelaCadastro() {
        try {
            // Certifique-se de que o caminho para o arquivo FXML "TelaInicial.fxml" está correto
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Cadastro.fxml"));
            Parent root = loader.load();

            // Cria uma nova janela (Stage)
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Tela Inicial");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace(); // Para depuração, imprime o erro no console
        }
    }
    @FXML
    private Button handleBottomTelainicial;

    @FXML
    private void handleButtonClick() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("TelaInicial.fxml"));
            Parent root = loader.load();

            // Obtém a referência do Stage atual
            Stage stage = (Stage) handleBottomTelainicial.getScene().getWindow();  // Corrigido aqui
            stage.setScene(new Scene(root));
            stage.setTitle("Tela Inicial");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void TelaLogin() {
        try {
            // Certifique-se de que o caminho para o arquivo FXML "TelaInicial.fxml" está correto
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Login.fxml"));
            Parent root = loader.load();

            // Cria uma nova janela (Stage)
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Tela Login");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace(); // Para depuração, imprime o erro no console
        }
    }

    @FXML
    private Button handleBottomLogTelainicial;

    @FXML
    private void handleButtonClicks() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("TelaInicial.fxml"));
            Parent root = loader.load();

            // Obtém a referência do Stage atual
            Stage stage = (Stage) handleBottomLogTelainicial.getScene().getWindow();  // Corrigido aqui
            stage.setScene(new Scene(root));
            stage.setTitle("Tela Inicial");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
