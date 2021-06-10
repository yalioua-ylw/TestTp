package org.emp.gl.TimeService;

import java.beans.PropertyChangeListener;

public interface TimeService {
    static String SECOND="SECOND";
    void addListener(TimeServiceListener l);
    void removeListener(TimeServiceListener l);
}
