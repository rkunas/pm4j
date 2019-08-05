package eu.kunas.pm4j.utils;

import javafx.fxml.FXMLLoader;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Kunas on 06.07.2015.
 */
public class Loader<T_FX_CONTROL> {

    public T_FX_CONTROL loadController(final String url) {
        final InputStream fxmlStream = null;
        try {
            final FXMLLoader loader = new FXMLLoader();

            try {
                loader.load(getClass().getResourceAsStream(url));
            } catch (final IOException e) {
                e.printStackTrace();
            }
            return loader.getController();
        } finally {
            if (fxmlStream != null) {
                try {
                    fxmlStream.close();
                } catch (final IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
