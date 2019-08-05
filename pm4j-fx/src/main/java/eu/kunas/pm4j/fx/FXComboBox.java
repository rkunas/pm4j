package eu.kunas.pm4j.fx;

import com.hiraas.pm4j.core.PmAttrImpl;
import com.hiraas.pm4j.core.PmOption;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.util.StringConverter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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

        comboBox.setConverter(stringConverter);
        comboBox.getItems().clear();
        comboBox.valueProperty().set(null);
        comboBox.getItems().addAll(pm.getPmOptions());
        if (pm.getValue() != null) {

            comboBox.getSelectionModel().clearSelection();

            String enumerable = (String) pm.getValue();

            Iterator<PmOption> it = pm.getPmOptions().iterator();
            while (it.hasNext()) {
                PmOption pmOption = it.next();
                if (enumerable.equals(pmOption.getValue())) {
                    comboBox.getSelectionModel().select(pmOption);
                }
            }
        } else {
            comboBox.getSelectionModel().clearSelection();
        }
        label.setText(pm.getTitle());
    }

    private final StringConverter stringConverter = new StringConverter() {
        @Override
        public String toString(final Object t) {
            PmOption option = (PmOption) t;
            return ((PmOption) t).getLabel();
        }

        @Override
        public Object fromString(final String string) {

            return null;

        }
    };

    @FXML
    void onAction(ActionEvent event) {

        if (comboBox.getSelectionModel().getSelectedItem() != null) {
            pm.setValue(comboBox.getSelectionModel().getSelectedItem().getValue());
        } else {
            pm.setValue(null);
        }

        refreshRegisteredOnAction();
    }
}
