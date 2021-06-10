package org.emp.gl.TimeService;


import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public interface TimeServiceListener extends PropertyChangeListener {
    static String SECOND="SECOND";

    @Override
    void propertyChange(PropertyChangeEvent evt);
}
