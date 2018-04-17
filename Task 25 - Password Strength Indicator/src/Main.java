import javafx.application.Application;
import javafx.geometry.*;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by james on 11/07/2017.
 */
public class Main extends Application {

    Stage window;
    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Login");


        //Create instance of LoginCheck class
        LoginCheck loginCheck = new LoginCheck();

        //Username TextField and Password Field
        Label credentialsLbl = new Label("Please enter your user credentials:");
        TextField username = new TextField();
        username.setPromptText("Username");
        PasswordField password = new PasswordField();
        password.setPromptText("Password");

        //Submit button
        Button login = new Button("Login");
        login.setDisable(true);
        Button newAccount = new Button("New Account");


        //Strength of Password Image
        ImageView passwordImg = new ImageView();
        passwordImg.setFitHeight(20);
        passwordImg.setFitWidth(20);
        Image fail = new Image(Main.class.getResourceAsStream("\\img\\1.png"));
        Image insecure = new Image(Main.class.getResourceAsStream("\\img\\2.png"));
        Image ok = new Image(Main.class.getResourceAsStream("\\img\\3.png"));
        Image secure = new Image(Main.class.getResourceAsStream("\\img\\4.png"));
        Image perfect = new Image(Main.class.getResourceAsStream("\\img\\5.png"));

        //Correct Username Image
        ImageView usernameImg = new ImageView();
        usernameImg.setFitWidth(20);
        usernameImg.setFitHeight(20);

        usernameImg.setImage(ok);
        passwordImg.setImage(ok);


    //Action event for username changes
        username.textProperty().addListener((o, oldValue, newValue) -> {
        boolean invalidPassword = loginCheck.passwordValidator(password.getText()) == -1;
        boolean invalidUsername = loginCheck.nameValidator(username.getText().toLowerCase()) == -1;

        if (invalidPassword || invalidUsername) {
            login.setDisable(true);
        } else {
            login.setDisable(false);
        }

        if (loginCheck.nameValidator(username.getText().toLowerCase()) == -1) {
            usernameImg.setImage(fail);
        } else {
            usernameImg.setImage(secure);
        }
    });

    //Action event for password changes
    password.textProperty().addListener((o, oldValue, newValue) -> {
        if (password.getText().isEmpty()) passwordImg.setImage(ok);
        boolean invalidPassword = loginCheck.passwordValidator(password.getText()) == -1;
        boolean invalidUsername = loginCheck.nameValidator(username.getText().toLowerCase()) == -1;

        if (invalidPassword || invalidUsername) {
            login.setDisable(true);
        } else {
            login.setDisable(false);
        }

        if (loginCheck.passwordValidator(password.getText()) == -1) passwordImg.setImage(fail);
        if (loginCheck.passwordValidator(password.getText()) == 1) {
            passwordImg.setImage(fail);
        }
        if (loginCheck.passwordValidator(password.getText()) == 2) {
            passwordImg.setImage(insecure);
        }
        if (loginCheck.passwordValidator(password.getText()) == 3) {
            passwordImg.setImage(ok);
        }
        if (loginCheck.passwordValidator(password.getText()) == 4) {
            passwordImg.setImage(secure);
        }
        if (loginCheck.passwordValidator(password.getText()) == 5) {
            passwordImg.setImage(perfect);
        }
    });

    SearchFile search = new SearchFile();
    //Actions for submit button
    login.setOnAction(e -> {
        try {
            if (search.loginCheck(username.getText().toLowerCase(), password.getText())) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Success!");
                alert.setHeaderText("Success!");
                alert.setContentText("Logged in successfully!");
                alert.setHeight(40);
                alert.setWidth(60);

                alert.showAndWait();
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Error!");
                alert.setHeaderText("Incorrect Username or Password.");
                alert.setContentText("Please check your login details and try again.");
                alert.setHeight(40);
                alert.setWidth(60);

                alert.showAndWait();
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        if (password.getText().isEmpty()) {
            password.getStyleClass().add("error");
        }
        if (username.getText().isEmpty()) {
            username.getStyleClass().add("error");
        }
    });

    newAccount.setOnAction(e -> {
        try {
            NewAccount.display();
        } catch(IOException ex) {
            ex.printStackTrace();
        }
    });

        //Layout set up
        GridPane layout = new GridPane();
        layout.setVgap(10);
        layout.setHgap(10);
        layout.add(credentialsLbl, 0,0,3,1);
        layout.addRow(1,username, usernameImg);
        layout.addRow(2, password, passwordImg);
        HBox buttons = new HBox(10);
        buttons.getChildren().addAll(login, newAccount);
        buttons.setAlignment(Pos.CENTER);
        layout.add(buttons, 0, 3,3,1);

        layout.setPadding(new Insets(30, 10, 30, 30));
        Scene scene = new Scene(layout);
        scene.getStylesheets().add("stylesheet.css");
    window.setResizable(false);
    window.setScene(scene);
    window.show();


    }

}
