package eu.kunas.pm4j.fx;

import eu.kunas.pm4j.core.PmAttrImpl;
import eu.kunas.pm4j.core.PmOption;
import eu.kunas.pm4j.fx.base.FXControl;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.util.StringConverter;

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
        comboBox.getItems().addAll(pm.getOptionSet().getOptions());
        if (pm.getValue() != null) {
            comboBox.getSelectionModel().clearSelection();
            String enumerable = (String) pm.getValue();
            comboBox.getSelectionModel().select(pm.getOptionSet().findOptionForIdString(enumerable));
        } else {
            comboBox.getSelectionModel().clearSelection();
        }

        label.setText(pm.getTitle());
    }

    private final StringConverter stringConverter = new StringConverter() {
        @Override
        public String toString(final Object t) {
            PmOption option = (PmOption) t;
            return ((PmOption) t).getPmTitle();
        }

        @Override
        public Object fromString(final String string) {

            return null;

        }
    };
}
