package eu.kunas.pm4j.fx;

import javafx.beans.property.StringPropertyBase;
import org.junit.Test;

public class TestFx {

    @Test
    public void testProps(){
        StringPropertyBase propertyBase = new StringPropertyBase("demo"){

            @Override
            public Object getBean() {
                return null;
            }

            @Override
            public String getName() {
                return null;
            }
        };

        StringPropertyBase propertyBase1 = new StringPropertyBase("demo"){

            @Override
            public Object getBean() {
                return null;
            }

            @Override
            public String getName() {
                return null;
            }
        };


        propertyBase.bindBidirectional(propertyBase1);

        propertyBase1.set("franz");

        System.out.println(propertyBase.get());
    }
}
