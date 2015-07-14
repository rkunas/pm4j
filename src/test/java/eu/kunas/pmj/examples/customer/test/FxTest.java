package eu.kunas.pmj.examples.customer.test;

import eu.kunas.pm4j.fx.FXButtonBuilder;
import eu.kunas.pmj.examples.customer.pms.CustomerDialogPm;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;
import org.junit.Test;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit.ApplicationTest;

/**
 * Created by Kunas on 14.07.2015.
 */
public class FxTest extends ApplicationTest {

    CustomerDialogPm customerDialogPm = new CustomerDialogPm();

    @Override
    public void start(Stage stage) {
        Group root = new Group();
        Scene scene = new Scene(root, 800, 600);

        root.getChildren().add(new FXButtonBuilder().withBindPm(customerDialogPm.searchCommand).build().getView());
        root.getChildren().add(new FXButtonBuilder().withBindPm(customerDialogPm.searchCommand).build().getView());

        stage.setScene(scene);
        stage.show();
    }

    @Test
    public void isButtonThere() throws Exception {

        clickOn("#button",MouseButton.PRIMARY);


    }
}
