package sample;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.hiraas.pm4j.primefaces.CustomerDialogPm;
import lombok.Getter;
import lombok.Setter;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@Named
@RequestScoped
public class SampleBean {

	@Getter
	@Setter
	private  CustomerDialogPm customerDialogPm = new CustomerDialogPm();

	@Inject
	@ConfigProperty(name = "version")
	private String version;

}
