package eu.kunas.pm4j.fx;


import eu.kunas.pm4j.utils.Loader;

/**
 * Created by Kunas on 07.07.2015.
 */
public class FXComboBoxBuilder extends FXBuilder<FXComboBoxBuilder, FXComboBox> {
    public FXComboBoxBuilder() {
        this.control = new Loader<FXComboBox>().loadController("/....*.fxml");
    }

    public FXComboBoxBuilder withRegisterForRefreshOnAction(final FXControl lControl) {
        this.control.registerRefreshOnAction(lControl);
        return this;
    }
}