package sample;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.control.Label;
import javafx.scene.control.ComboBox;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
// audio
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Mixer;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

import javafx.geometry.Orientation;

public class Main extends Application{

    public static void main(String[] args) {

        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        ObservableList<String> devices = FXCollections.observableArrayList("Нооовавп", "митмлдитло", "уцеукшщешщ выаоллп оваплдво");

        Mixer.Info[] mixerInfo = AudioSystem.getMixerInfo();
        for (Mixer.Info info : mixerInfo) {
            String deviceName = info.getName();
            byte[] bytes = deviceName.getBytes("ISO-8859-1"); // <- from
            String value = new String(bytes, "Windows-1251"); // <- to
            devices.add(value);
        }

        ComboBox<String> langsComboBox = new ComboBox<String>(devices);
        //langsComboBox.setValue("Devices"); // устанавливаем выбранный элемент по умолчанию

        Label lbl = new Label();

        // получаем выбранный элемент
        langsComboBox.setOnAction(event -> lbl.setText(langsComboBox.getValue()));

        FlowPane root = new FlowPane(10, 10, langsComboBox, lbl);

        Scene scene = new Scene(root, 600, 300);

        stage.setScene(scene);
        stage.setTitle("ComboBox in JavaFX");
        stage.show();
    }
}