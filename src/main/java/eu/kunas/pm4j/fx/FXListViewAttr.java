package eu.kunas.pm4j.fx;

import eu.kunas.pm4j.core.PmAttrImpl;
import eu.kunas.pm4j.core.PmOption;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;

/**
 * Created by Kunas on 07.07.2015.
 */
public class FXListViewAttr extends FXControl<PmAttrImpl>{


    @FXML
    private ListView<PmOption> listView;

    @Override
    public void refresh() {
        listView.getItems().clear();

        ObservableList data = FXCollections.observableArrayList(pm.getPmOptions());

        listView.setCellFactory(new Callback<ListView<PmOption>, ListCell<PmOption>>() {
            @Override
            public ListCell<PmOption> call(ListView<PmOption> param) {
                ListCell<PmOption> cell =  new ListCell<PmOption>(){
                    @Override
                    protected void updateItem(PmOption item, boolean empty) {
                        super.updateItem(item, empty);
                        if(item != null){
                            setText(item.getLabel());
                        }
                    }
                };

                return cell;
            }
        });

        listView.setItems(data);
    }


    @FXML
    void onMouseClicked(MouseEvent event) {
        onAction();
    }

    public void onAction(){
        PmOption selected = listView.getSelectionModel().getSelectedItem();
        if(selected != null){
            pm.setValue(selected.getValue());
        }

        refreshRegisteredOnAction();
    }
}
