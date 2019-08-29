package eu.kunas.pm4j;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class HelloWorld extends Application {

    WebView webView;

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) {
        primaryStage.setTitle("JavaFX WebView Example");

        webView = new WebView();

        webView.getEngine().load("http://www.hiraav.com");

        VBox vBox = new VBox(webView);
        Scene scene = new Scene(vBox, 960, 600);
        Button button = new Button();
        button.setText("gehe zu");
        button.setOnAction(action->{
            WebEngine en = webView.getEngine();
            System.out.println(en.getDocument());
            Document doc = en.getDocument();

            NodeList list = doc.getElementsByTagName("input");

            System.out.println(list);
        });

        vBox.getChildren().add(button);
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
