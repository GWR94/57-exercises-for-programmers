import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import static java.awt.SystemColor.window;

/**
 * Created by james on 03/08/2017.
 */
public class Main extends Application {
    int numberOfGuesses = 0;
    int numberToGuess = 0;

    public void start(Stage primaryStage) throws Exception {
        Stage window = new Stage();
        window.setTitle("Guess My Number!");

        Label instructionsLbl = new Label("Try to guess a random number!");
        Label difficultyLbl = new Label("Please select a dificulty:");
        ToggleGroup difficultyGroup = new ToggleGroup();
        RadioButton easyBtn = new RadioButton("Easy");
        easyBtn.setToggleGroup(difficultyGroup);
        RadioButton normalBtn = new RadioButton("Medium");
        normalBtn.setToggleGroup(difficultyGroup);
        RadioButton hardBtn = new RadioButton("Hard");
        hardBtn.setToggleGroup(difficultyGroup);

        Label guessLbl = new Label("Number to guess: ");
        TextField guessTxt = new TextField();
        guessTxt.setPrefWidth(50);
        Button guessBtn = new Button("Guess!");
        guessBtn.setDisable(true);
        Button resetBtn = new Button("Reset");
        Label outputLbl = new Label("Please pick a number!");
        Label numberOfGuessesLbl = new Label();

        HBox rButtonsLayout = new HBox(10);
        rButtonsLayout.getChildren().addAll(easyBtn, normalBtn, hardBtn);

        HBox guessLayout = new HBox(5);
        guessLayout.getChildren().addAll(guessLbl, guessTxt);
        guessLayout.setAlignment(Pos.CENTER);

        HBox buttonsLayout = new HBox(15);
        buttonsLayout.getChildren().addAll(resetBtn, guessBtn);
        buttonsLayout.setAlignment(Pos.CENTER);

        easyBtn.setOnAction(e-> {
            numberToGuess = (int) (Math.random() * 10) + 1;
            easyBtn.setDisable(true);
            normalBtn.setDisable(true);
            hardBtn.setDisable(true);
            guessBtn.setDisable(false);
        });

        normalBtn.setOnAction(e-> {
            numberToGuess = (int) (Math.random() * 100) + 1;
            easyBtn.setDisable(true);
            normalBtn.setDisable(true);
            hardBtn.setDisable(true);
            guessBtn.setDisable(false);
        });

        hardBtn.setOnAction(e-> {
            numberToGuess = (int) (Math.random() * 1000) + 1;
            System.out.println(numberToGuess);
            easyBtn.setDisable(true);
            normalBtn.setDisable(true);
            hardBtn.setDisable(true);
            guessBtn.setDisable(false);
        });

        resetBtn.setOnAction(e-> {
            easyBtn.setDisable(false);
            normalBtn.setDisable(false);
            hardBtn.setDisable(false);
            numberOfGuesses = 0;
            guessTxt.setText("");
            easyBtn.setSelected(false);
            normalBtn.setSelected(false);
            hardBtn.setSelected(false);
            guessBtn.setDisable(true);
            numberOfGuessesLbl.setText("");
            outputLbl.setText("");
        });

        guessBtn.setOnAction(e-> {
            try {
                int guess = Integer.parseInt(guessTxt.getText());
                if (guess == numberToGuess) {
                    numberOfGuesses++;
                    if(numberOfGuesses == 1) {
                        outputLbl.setText("You're a mind reader!");
                        numberOfGuessesLbl.setText(numberOfGuesses + " guesses.");
                    }
                    else if(numberOfGuesses >= 2 && numberOfGuesses <= 4) {
                        outputLbl.setText("Most impressive!");
                        numberOfGuessesLbl.setText(numberOfGuesses + " guesses.");
                    }
                    else if(numberOfGuesses >= 5 && numberOfGuesses <= 7) {
                        outputLbl.setText("You can do better than that!");
                        numberOfGuessesLbl.setText(numberOfGuesses + " guesses.");
                    }
                    else {
                        outputLbl.setText("Better luck next time.");
                        numberOfGuessesLbl.setText(numberOfGuesses + " guesses.");
                    }
                }
                else {
                    if(guess > numberToGuess) {
                        outputLbl.setText("Too high! Try again.");
                        numberOfGuesses++;
                    }
                    else if(guess < numberToGuess) {
                        outputLbl.setText("Too low! Try again.");
                        numberOfGuesses++;
                    }
                }
            } catch(NumberFormatException ex) {
                outputLbl.setText("Invalid number!");
                numberOfGuesses++;
            }
        });


        GridPane layout = new GridPane();
        layout.setPadding(new Insets(30));
        layout.setHgap(10);
        layout.setVgap(10);
        layout.addRow(0, instructionsLbl);
        layout.addRow(1, difficultyLbl);
        layout.addRow(2, rButtonsLayout);
        layout.addRow(3, guessLayout);
        layout.addRow(4, buttonsLayout);
        layout.addRow(5, outputLbl);
        layout.addRow(6, numberOfGuessesLbl);
        layout.setHalignment(guessBtn, HPos.CENTER);
        layout.setHalignment(difficultyLbl, HPos.CENTER);
        layout.setHalignment(outputLbl, HPos.CENTER);
        layout.setHalignment(numberOfGuessesLbl, HPos.CENTER);

        layout.setAlignment(Pos.CENTER);
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.show();
    }
}
