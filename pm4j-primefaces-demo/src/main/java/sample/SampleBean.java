package sample;

import com.hiraas.pm4j.pms.CustomerDialogPm;
import lombok.Data;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named
@ApplicationScoped
@Data
public class SampleBean implements Serializable {

    private FacesCustomerDialogPm customerDialogPm = new FacesCustomerDialogPm();

    @Inject
    @ConfigProperty(name = "version")
    private String version;


}
