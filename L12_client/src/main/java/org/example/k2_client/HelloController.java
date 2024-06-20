package org.example.k2_client;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HelloController {

    public List<Words> wordsList = new ArrayList<>();
    public Label wordCountLabel;
    public TextField filterField;
    public ListView wordList;


    public HelloController() {
        ClientReceiver.controller = this;
    }

    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    public void onWordReceived(String message) {
        Words word = new Words(message, LocalTime.now());
        wordsList.add(word);
        Platform.runLater(() -> {
            wordCountLabel.setText(String.valueOf(wordsList.size()));
            UpdateList();}
        );
    }

    public void UpdateList(){
        DateTimeFormatter formatter;
        formatter = DateTimeFormatter.ofPattern("HH:mm:ss ");
        wordList.setItems(FXCollections.observableArrayList(
                wordsList.stream()
                        .filter((word) -> word.word.startsWith(filterField.getText()))
                        .sorted((word1, word2) -> word1.word.compareTo(word2.word))
                                .map((item) -> item.time.format(formatter) + item.word)
                        .toList()
        ));
    }

    public void onFilter() {
        Platform.runLater(() -> {
            UpdateList();
        });
    }
}

//spring intializer
//maven
//dependencies -> spring web
//testowanie postman/terminal