package eu.kunas.pm4j.fx;


import eu.kunas.pm4j.fx.base.FXBuilder;
import eu.kunas.pm4j.utils.Loader;

/**
 * Created by Kunas on 07.07.2015.
 */
public class FXComboBoxBuilder extends FXBuilder<FXComboBoxBuilder, FXComboBox> {
    public FXComboBoxBuilder(){
        this.control = (FXComboBox) new Loader().loadController("/....*.fxml");
    }
}