package sample;

import com.hiraas.pm4j.primefaces.CustomerDialogPm;
import lombok.Data;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
@Data
public class SampleBean {

    private CustomerDialogPm customerDialogPm = new CustomerDialogPm();

    @Inject
    @ConfigProperty(name = "version")
    private String version;

}
