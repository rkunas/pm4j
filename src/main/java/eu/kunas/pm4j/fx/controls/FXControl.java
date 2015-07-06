package eu.kunas.pm4j.fx.controls;

import eu.kunas.pm4j.core.PmCommandImpl;
import eu.kunas.pm4j.core.PmImpl;
import javafx.fxml.FXML;
import javafx.scene.Node;

/**
 * Created by Kunas on 06.07.2015.
 */
public abstract class FXControl<T_PM extends PmImpl> {

    @FXML
    public Node view;

    protected T_PM pm;

    abstract void refresh();

    public void bindPmCommand(T_PM pm){
        this.pm = pm;
        refresh();
    }

    public Node getView() {
        return view;
    }
}
