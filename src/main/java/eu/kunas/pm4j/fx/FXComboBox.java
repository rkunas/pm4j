package eu.kunas.pm4j.fx;

import eu.kunas.pm4j.core.PmAttrImpl;
import eu.kunas.pm4j.core.PmOption;
import eu.kunas.pm4j.fx.base.FXControl;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

/**
 * Created by Kunas on 07.07.2015.
 */
public class FXComboBox extends FXControl<PmAttrImpl> {

    @FXML
    private Label label;

    @FXML
    private ComboBox<PmOption> comboBox;

    @Override
    public void refresh() {
        label.setText(pm.getTitle());
    }
}
