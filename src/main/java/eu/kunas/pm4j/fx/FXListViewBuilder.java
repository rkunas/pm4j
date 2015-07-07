package eu.kunas.pm4j.fx;

import eu.kunas.pm4j.fx.base.FXBuilder;
import eu.kunas.pm4j.utils.Loader;

/**
 * Created by Kunas on 07.07.2015.
 */
public class FXListViewBuilder extends FXBuilder<FXListViewBuilder, FXListView> {

    public FXListViewBuilder(){
        this.control = (FXListView) new Loader().loadController("/eu/....");
    }
}
