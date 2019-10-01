package eu.kunas.pm4j.fx;

import com.hiraas.pm4j.core.PmCommandImpl;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Kunas on 06.07.2015.
 */
public class FXButton extends FXControl<PmCommandImpl> implements Initializable {

    @FXML
    public Button button;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @Override
    public void refresh(){
        this.button.setText(this.pm.getTitle());
        this.button.setDisable(!this.pm.getEnabled());
    }

    @FXML
    private void onAction(){
        this.pm.doIt();

        // Sich selbst Refreshen
        this.refresh();

        // Andere Refreshen
        refreshRegisteredOnAction();
    }

}
