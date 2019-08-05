package eu.kunas.pm4j.fx;

import eu.kunas.pm4j.utils.Loader;

/**
 * Created by Kunas on 07.07.2015.
 */
public class FXListViewAttrBuilder extends FXBuilder<FXListViewAttrBuilder, FXListViewAttr> {

    public FXListViewAttrBuilder(){
        this.control = new Loader<FXListViewAttr>().loadController("/eu/....");
    }

    public FXListViewAttrBuilder withRegisterOnAction(final FXControl lControl) {
        this.control.registerRefreshOnAction(lControl);
        return this;
    }
}
