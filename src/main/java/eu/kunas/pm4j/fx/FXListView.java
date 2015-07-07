package eu.kunas.pm4j.fx;

import eu.kunas.pm4j.core.PmAttrImpl;
import eu.kunas.pm4j.core.PmOption;
import eu.kunas.pm4j.fx.base.FXControl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ListView;

/**
 * Created by Kunas on 07.07.2015.
 */
public class FXListView extends FXControl<PmAttrImpl>{

    @FXML
    private ListView<PmOption> listView;

    @Override
    public void refresh() {
        listView.getItems().clear();

        ObservableList data = FXCollections.observableArrayList(pm.getPmOptions());

        listView.setItems(data);
    }
}
