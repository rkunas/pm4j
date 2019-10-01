package eu.kunas.pm4j.fx;

import com.hiraas.pm4j.core.PmImpl;
import javafx.fxml.FXML;
import javafx.scene.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kunas on 06.07.2015.
 */
public abstract class FXControl<T_PM extends PmImpl> {

    @FXML
    public Node view;

    protected T_PM pm;

    protected List<FXControl> refreshControlsOnAction = null;

    protected void registerRefreshOnAction(final FXControl control) {
        if (this.refreshControlsOnAction == null) {
            this.refreshControlsOnAction = new ArrayList<>();
        }
        if (control != null) {
            this.refreshControlsOnAction.add(control);
        }
    }

    public abstract void refresh();

    public void bindPm(T_PM pm){
        this.pm = pm;
        refresh();
    }

    /**
     * Aktualisiert FXControls welche registriert sind
     */
    protected void refreshRegisteredOnAction(){
        if(refreshControlsOnAction != null) {
            for (FXControl control : refreshControlsOnAction) {
                control.refresh();
            }
        }
    }

    public Node getView() {
        return view;
    }
}
