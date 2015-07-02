package eu.kunas.pm4j;

import java.io.Serializable;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Created by ramazan on 03.11.14.
 */
public abstract class PmCommandImpl<T_PM_PARENT> extends PmImpl<T_PM_PARENT> implements Serializable {
    
    private static Log log        = LogFactory.getLog(PmCommandImpl.class);
    private String     onComplete = "";
    private String     render     = "";
    
    public PmCommandImpl(final T_PM_PARENT parent) {
        super(parent);
    }
    
    public String getRender() {
        return render;
    }
    
    public void setRender(final String render) {
        this.render = render;
    }
    
    public String getOnComplete() {
        return onComplete;
    }
    
    public void setOnComplete(final String onComplete) {
        this.onComplete = onComplete;
    }
    
    public final void doIt() {
        log.info(getPmParent().getClass().getSimpleName() + " - doIt");
        log.info(getPmParent().getClass().getSimpleName() + " - Validiere vor doIt");
        validate();
        log.info(getPmParent().getClass().getSimpleName() + " - Validierung abgeschlossen");
        if (getValid()) {
            log.info(getPmParent().getClass().getSimpleName() + " - Pm Command " + getTitle() + " ist valide");
            doItImpl();
        }
        else {
            log.info(getPmParent().getClass().getSimpleName() + " - Pm Command " + getTitle() + " ist nicht valide");
        }
    }
    
    protected abstract void doItImpl();
    
}
