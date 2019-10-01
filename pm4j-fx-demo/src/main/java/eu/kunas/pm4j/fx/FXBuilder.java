package eu.kunas.pm4j.fx;


import com.hiraas.pm4j.core.PmImpl;

/**
 * Created by Kunas on 06.07.2015.
 */
public abstract class FXBuilder<T_BUILDER extends FXBuilder,T_CONTROL extends FXControl> {

    protected T_CONTROL control = null;

    public T_BUILDER withBindPm(final PmImpl command) {
        this.control.bindPm(command);
        return (T_BUILDER) this;
    }

    public T_CONTROL build() {
        return this.control;
    }
}
