import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Created by james on 04/08/2017.
 */
public class Main extends Application {

    public void start(Stage primaryStage) throws Exception {
        Stage window = new Stage();
        window.setTitle("Heart Rate Monitor");

        Label ageLbl = new Label("How old are you?");
        TextField ageTxt = new TextField();
        Label restBPM = new Label("What is your resting pulse?");
        TextField restTxt = new TextField();
        Label targetLbl = new Label("What is your target intensity?");
        Label heartRateLbl = new Label("Invalid data");

        Slider intensitySlider = new Slider(55, 95, 55);
        intensitySlider.setBlockIncrement(5);
        intensitySlider.setMajorTickUnit(75);
        intensitySlider.setShowTickMarks(true);
        intensitySlider.setShowTickLabels(true);
        intensitySlider.setMinorTickCount(55);
        intensitySlider.setMajorTickUnit(95);


        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10));
        layout.getChildren().addAll(ageLbl, ageTxt, restBPM, restTxt, targetLbl, intensitySlider, heartRateLbl);
        layout.setAlignment(Pos.CENTER);

        ageTxt.textProperty().addListener((o, oldVal, newVal) -> {
            try {
                Integer.parseInt(ageTxt.getText());
                ageTxt.setId(null);
            } catch(NumberFormatException ex) {
                ageTxt.setId("error");
            }

            try {
                int age = Integer.parseInt(ageTxt.getText());
                int bpm = Integer.parseInt(restTxt.getText());
                double targetHeartRate = (((220 - age)-bpm) * intensitySlider.getValue()/100) + bpm;
                heartRateLbl.setText((int)intensitySlider.getValue() + "% intensity = " + (int)targetHeartRate + " bpm");

            } catch(NumberFormatException e) {
                heartRateLbl.setText("Invalid data");
            }
        });

        restTxt.textProperty().addListener((o, oldVal, newVal) -> {
            try {
                Integer.parseInt(restTxt.getText());
                restTxt.setId(null);
            } catch(NumberFormatException ex) {
                restTxt.setId("error");
            }

            try {
                int age = Integer.parseInt(ageTxt.getText());
                int bpm = Integer.parseInt(restTxt.getText());
                double targetHeartRate = (((220 - age)-bpm) * intensitySlider.getValue()/100) + bpm;
                heartRateLbl.setText((int)intensitySlider.getValue() + "% intensity = " + (int)targetHeartRate + " bpm");

            } catch(NumberFormatException e) {
                heartRateLbl.setText("Invalid data");
            }
        });






        intensitySlider.valueProperty().addListener(e -> {
                try {
                    int age = Integer.parseInt(ageTxt.getText());
                    int bpm = Integer.parseInt(restTxt.getText());
                    double targetHeartRate = (((220 - age)-bpm) * intensitySlider.getValue()/100) + bpm;
                    heartRateLbl.setText((int)intensitySlider.getValue() + "% intensity = " + (int)targetHeartRate + " bpm");

                } catch(NumberFormatException ex) {
                    heartRateLbl.setText("Invalid data");
                }
        });

        Scene scene = new Scene(layout);
        scene.getStylesheets().add("style.css");
        window.setScene(scene);
        window.show();

    }
}
