package org.emp.gl.TimeServiceImpl;

import org.emp.gl.TimeService.TimeService;
import org.emp.gl.TimeService.TimeServiceListener;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.time.LocalTime;
import java.util.Timer;
import java.util.TimerTask;

public class TimeServiceImpl extends TimerTask implements TimeService {
    PropertyChangeSupport pcs=new PropertyChangeSupport(this);
    public  TimeServiceImpl(){
        Timer timer = new Timer();
        LocalTime localTime = LocalTime.now();
        timer.scheduleAtFixedRate(this, 100, 1000);
    }

    @Override
    public void run() {

        PropertyChangeEvent pce=new PropertyChangeEvent(this,SECOND,null,null);
        pcs.firePropertyChange(pce);
    }

    @Override
    public void addListener(TimeServiceListener l) {
        pcs.addPropertyChangeListener(l);
    }

    @Override
    public void removeListener(TimeServiceListener l) {
        pcs.removePropertyChangeListener(l);
    }
}
