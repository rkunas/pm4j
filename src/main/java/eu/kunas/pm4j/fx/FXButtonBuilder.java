package eu.kunas.pm4j.fx;

import eu.kunas.pm4j.fx.base.FXBuilder;
import eu.kunas.pm4j.fx.base.FXControl;
import eu.kunas.pm4j.utils.Loader;

/**
 * Created by Kunas on 06.07.2015.
 */
public class FXButtonBuilder extends FXBuilder<FXButtonBuilder,FXButton> {

    public FXButtonBuilder() {
        this.control = new Loader<FXButton>().loadController("/eu/kunas/pm4j/javafxsample/controls/MyButton.fxml");
    }

    public FXButtonBuilder withRegisterOnAction(final FXControl lControl) {
        this.control.registerOnActionRefresh(lControl);
        return this;
    }

    public FXButtonBuilder withRegisterSelfOnAction() {
        this.control.registerOnActionRefresh(this.control);
        return this;
    }
}
