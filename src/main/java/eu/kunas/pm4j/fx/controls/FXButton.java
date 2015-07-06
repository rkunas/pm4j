package eu.kunas.pm4j.fx.controls;

import eu.kunas.pm4j.core.PmCommandImpl;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by Kunas on 06.07.2015.
 */
public class FXButton extends FXControl<PmCommandImpl> implements Initializable {

    @FXML
    public Button button;

    private List<FXControl> doItControls = null;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    protected void registerOnActionRefresh(final FXControl control) {
        if (this.doItControls == null) {
            this.doItControls = new ArrayList<>();
        }
        if (control != null) {
            this.doItControls.add(control);
        }
    }

    public void refresh(){
        this.button.setText(this.pm.getTitle());
        this.button.setDisable(!this.pm.getEnabled());
    }

    private void onActionRefresh() {
        if (this.doItControls != null) {
            for (final FXControl control : this.doItControls) {
                control.refresh();
            }
        }
    }

    @FXML
    private void onAction(){
        this.pm.doIt();
        onActionRefresh();
    }

}
