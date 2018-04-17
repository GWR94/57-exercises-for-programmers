import javafx.geometry.*;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Created by HP on 05/07/2017.
 */
public class NewAccount {

    public static void display() throws IOException {
        //Creating new stage for alert box
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Create Account");

        //Buttons
        Button createBtn = new Button("Create Account");
        Button cancelBtn = new Button("Cancel");

        //Input variables
        Label instructions = new Label("Please complete registration form:");
        Label usernameLbl = new Label("Username:");
        TextField username = new TextField();
        username.setPromptText("Username");
        Label passwordLbl = new Label("Password:");
        PasswordField password = new PasswordField();
        password.setPromptText("Password");
        Label fNameLbl = new Label("First Name:");
        TextField fName = new TextField();
        fName.setPromptText("First Name");
        Label sNameLbl = new Label("Surname:");
        TextField sName = new TextField();
        sName.setPromptText("Surname");
        Label emailLbl = new Label("Email:");
        TextField email = new TextField();
        email.setPromptText("Email");

        //Images
        Image fail = new Image(Main.class.getResourceAsStream("\\img\\1.png"));
        Image insecure = new Image(Main.class.getResourceAsStream("\\img\\2.png"));
        Image ok = new Image(Main.class.getResourceAsStream("\\img\\3.png"));
        Image secure = new Image(Main.class.getResourceAsStream("\\img\\4.png"));
        Image perfect = new Image(Main.class.getResourceAsStream("\\img\\5.png"));

        //Password Strength Indicator
        ImageView passwordImg = new ImageView();
        passwordImg.setFitHeight(20);
        passwordImg.setFitWidth(20);
        passwordImg.setImage(ok);

        //Username check image
        ImageView usernameImg = new ImageView();
        usernameImg.setFitWidth(20);
        usernameImg.setFitHeight(20);
        usernameImg.setImage(ok);

        //Email Img
        ImageView emailImg = new ImageView();
        emailImg.setFitHeight(20);
        emailImg.setFitWidth(20);

        //First name Img
        ImageView fnameImg = new ImageView();
        fnameImg.setFitWidth(20);
        fnameImg.setFitHeight(20);
        fnameImg.setImage(ok);
        //Surname img
        ImageView snameImg = new ImageView();
        snameImg.setFitWidth(20);
        snameImg.setFitHeight(20);
        snameImg.setImage(ok);

        HBox buttons = new HBox(10);
        buttons.getChildren().addAll(createBtn, cancelBtn);
        buttons.setAlignment(Pos.CENTER);


        GridPane layout = new GridPane();
        layout.add(instructions, 0,0, 3,1);
        layout.addRow(1, usernameLbl, username, usernameImg);
        layout.addRow(2, passwordLbl, password, passwordImg);
        layout.addRow(3, fNameLbl, fName, fnameImg);
        layout.addRow(4, sNameLbl, sName, snameImg);
        layout.addRow(5, emailLbl, email, emailImg);
        layout.add(buttons, 0,6, 3,1);
        layout.setHgap(10);
        layout.setVgap(10);
        layout.setPadding(new Insets(15));

        CreateAccount newAccount = new CreateAccount();
        SearchFile search = new SearchFile();
        LoginCheck login = new LoginCheck();

        //Tooltip Setups
        Tooltip tooShortTip = new Tooltip("Username needs to be longer than 5 characters\nand include no spaces or special characters.");
        tooShortTip.setTextAlignment(TextAlignment.CENTER);
        Tooltip takenTip = new Tooltip("Username taken!");
        Tooltip usernameTip = new Tooltip("Usernames must be more than 5 characters long\n" +
                                            "They must also not contain special characters");
        usernameTip.setTextAlignment(TextAlignment.CENTER);
        Tooltip passwordTip = new Tooltip("Passwords must be at least 6 characters,\n" +
                                            "preferably including numbers and special characters\n" +
                                            "for added security!");
        passwordTip.setTextAlignment(TextAlignment.CENTER);
        Tooltip fNameTip = new Tooltip("Enter first name");
        Tooltip sNameTip = new Tooltip("Enter surname");
        Tooltip emailTip = new Tooltip("Enter email address (optional)");
        Tooltip emailTakenTip = new Tooltip("That email address is already registered!\n" +
                                                "Please log in using using the details" +
                                                "\nassociated with that email");
        emailTakenTip.setTextAlignment(TextAlignment.CENTER);
        Tooltip invalidEmailTip = new Tooltip("Please insert a valid email address");
        Tooltip invalidNameTip = new Tooltip("Name must be at least 2 characters long");

        //Assigning Tooltips to fields
        username.setTooltip(usernameTip);
        password.setTooltip(passwordTip);
        fName.setTooltip(fNameTip);
        sName.setTooltip(sNameTip);
        email.setTooltip(emailTip);

        //Action event for username
        username.textProperty().addListener((o, oldValue, newValue) -> {
            try {
                boolean invalidPassword = login.passwordValidator(password.getText()) == -1;
                boolean invalidUsername = login.usernameValidator(username.getText().toLowerCase()) == -1;
                boolean emailUsed = search.emailTaken(email.getText()) == -1;
                boolean usernameTaken = search.usernameTaken(username.getText().toLowerCase()) == -1;
                boolean invalidFName = login.nameValidator(fName.getText()) == -1;
                boolean invalidSName = login.nameValidator(sName.getText()) == -1;

                if (invalidPassword || invalidUsername || emailUsed || usernameTaken || invalidFName || invalidSName) {
                    createBtn.setDisable(true);
                } else {
                    createBtn.setDisable(false);
                }
                if(usernameTaken) {
                   username.setId("error");
                   username.setTooltip(takenTip);
                   usernameImg.setImage(fail);
                }
                else if(invalidUsername) {
                    username.setId("error");
                    username.setTooltip(tooShortTip);
                    usernameImg.setImage(fail);
                }
                else {
                    usernameImg.setImage(secure);
                    username.setId(null);
                    username.setTooltip(usernameTip);
                }
            } catch(IOException e) {
                e.printStackTrace();
            }
        });

        password.textProperty().addListener((o, oldValue, newValue) -> {
            try {
                boolean invalidPassword = login.passwordValidator(password.getText()) == -1;
                boolean invalidUsername = login.usernameValidator(username.getText().toLowerCase()) == -1;
                boolean emailUsed = search.emailTaken(email.getText()) == -1;
                boolean usernameTaken = search.usernameTaken(username.getText().toLowerCase()) == -1;
                boolean invalidFName = login.nameValidator(fName.getText()) == -1;
                boolean invalidSName = login.nameValidator(sName.getText()) == -1;

                if (invalidPassword || invalidUsername || emailUsed||usernameTaken || invalidFName || invalidSName) {
                    createBtn.setDisable(true);
                } else {
                    createBtn.setDisable(false);
                }
                if (login.passwordValidator(password.getText()) == -1) {
                    passwordImg.setImage(fail);
                    password.setId("error");
                }
                else if (login.passwordValidator(password.getText()) == 1) {
                    passwordImg.setImage(fail);
                    password.setId("error");
                }
                else if (login.passwordValidator(password.getText()) == 2) {
                    passwordImg.setImage(insecure);
                    password.setId(null);
                }
                else if (login.passwordValidator(password.getText()) == 3) {
                    passwordImg.setImage(ok);
                    password.setId(null);
                }
                else if (login.passwordValidator(password.getText()) == 4) {
                    passwordImg.setImage(secure);
                    password.setId(null);
                }
                else if (login.passwordValidator(password.getText()) == 5) {
                    passwordImg.setImage(perfect);
                    password.setId(null);
                }
            } catch(IOException e) {
                e.printStackTrace();
            }
        });

        fName.textProperty().addListener((o, oldValue, newValue) -> {
            try {
                boolean invalidPassword = login.passwordValidator(password.getText()) == -1;
                boolean invalidUsername = login.usernameValidator(username.getText().toLowerCase()) == -1;
                boolean emailUsed = search.emailTaken(email.getText()) == -1;
                boolean usernameTaken = search.usernameTaken(username.getText().toLowerCase()) == -1;
                boolean invalidFName = login.nameValidator(fName.getText()) == -1;
                boolean invalidSName = login.nameValidator(sName.getText()) == -1;

                if (invalidPassword || invalidUsername || emailUsed||usernameTaken || invalidFName || invalidSName) {
                    createBtn.setDisable(true);
                } else {
                    createBtn.setDisable(false);
                }
                if(invalidFName) {
                    fnameImg.setImage(fail);
                    fName.setId("error");
                    fName.setTooltip(invalidNameTip);
                } else {
                    fnameImg.setImage(secure);
                    fName.setId(null);
                    fName.setTooltip(fNameTip);
                }
            } catch(IOException e) {
                e.printStackTrace();
            }
        });

        sName.textProperty().addListener((o, oldValue, newValue) -> {
             try {
                 boolean invalidPassword = login.passwordValidator(password.getText()) == -1;
                 boolean invalidUsername = login.usernameValidator(username.getText().toLowerCase()) == -1;
                 boolean emailUsed = search.emailTaken(email.getText()) == -1;
                 boolean usernameTaken = search.usernameTaken(username.getText().toLowerCase()) == -1;
                 boolean invalidFName = login.nameValidator(fName.getText()) == -1;
                 boolean invalidSName = login.nameValidator(sName.getText()) == -1;

                 if (invalidPassword || invalidUsername || emailUsed||usernameTaken || invalidFName || invalidSName) {
                     createBtn.setDisable(true);
                 } else {
                     createBtn.setDisable(false);
                 }
                 if(invalidSName) {
                     snameImg.setImage(fail);
                     sName.setId("error");
                     sName.setTooltip(invalidNameTip);
                 } else {
                     snameImg.setImage(secure);
                     sName.setId(null);
                     sName.setTooltip(fNameTip);
                 }
             } catch(IOException e) {
                 e.printStackTrace();
             }
        });

        email.textProperty().addListener((o, oldValue, newValue) -> {
            try {
                boolean invalidPassword = login.passwordValidator(password.getText()) == -1;
                boolean invalidUsername = login.usernameValidator(username.getText().toLowerCase()) == -1;
                boolean emailUsed = search.emailTaken(email.getText()) == -1;
                boolean incorrectEmail = !validate(email.getText());
                boolean usernameTaken = search.usernameTaken(username.getText().toLowerCase()) == -1;
                boolean invalidFName = login.nameValidator(fName.getText()) == -1;
                boolean invalidSName = login.nameValidator(sName.getText()) == -1;



                if (invalidPassword || invalidUsername || emailUsed||usernameTaken || invalidFName || invalidSName || incorrectEmail) {
                    createBtn.setDisable(true);
                } else {
                    createBtn.setDisable(false);
                }

                if(email.getText().isEmpty()) {
                    email.setId(null);
                    emailImg.setImage(null);
                }
                else if (emailUsed) {
                emailImg.setImage(fail);
                email.setId("error");
                email.setTooltip(emailTakenTip);
                }
                else if(incorrectEmail) {
                    emailImg.setImage(fail);
                    email.setId("error");
                    email.setTooltip(invalidEmailTip);
                }
                else {
                    emailImg.setImage(secure);
                    email.setId(null);
                }
            } catch(IOException e) {
                e.printStackTrace();
            }
        });


        //Action events for "Create Account" Button:
        //If there is no email address registered, "unspecified" will be input into the system
        createBtn.setOnAction(e -> {
            String emailToSend = email.getText();
            if (email.getText().isEmpty()) {
                emailToSend = "unspecified";
            }
            //All of the fields will then be saved into storage so the user can log in through the login screen
            newAccount.addRecords(username.getText().toLowerCase(), password.getText(), fName.getText(), sName.getText(), emailToSend);
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Success!");
            alert.setHeaderText("Success! Account successfully created.");
            alert.setContentText("Welcome to the community " + fName.getText() + " " + sName.getText() + "!");
            alert.setHeight(40);
            alert.setWidth(60);

            alert.showAndWait();
            window.close();
        });

        cancelBtn.setOnAction(e -> window.close());

        //Set layout for new alert

        //Set Scene
        Scene scene = new Scene(layout);
        scene.getStylesheets().add("stylesheet.css");
        //Set and show window
        window.setScene(scene);
        window.showAndWait();
    }

    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public static boolean validate(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.find();
    }


}