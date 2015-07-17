package eu.kunas.pm4j.fx;

import eu.kunas.pm4j.utils.Loader;

/**
 * Created by Kunas on 06.07.2015.
 */
public class FXButtonBuilder extends FXBuilder<FXButtonBuilder,FXButton> {

    public FXButtonBuilder() {
        this.control = new Loader<FXButton>().loadController("/eu/kunas/pm4j/fx/FXButton.fxml");
    }

    public FXButtonBuilder withRegisterOnAction(final FXControl lControl) {
        this.control.registerRefreshOnAction(lControl);
        return this;
    }

    public FXButtonBuilder withRegisterSelfOnAction() {
        this.control.registerRefreshOnAction(this.control);
        return this;
    }
}
