package org.emp.gl.launcher;
import org.emp.gl.TimeServiceImpl.TimeServiceImpl;
import org.emp.gl.gui.Environnement;
import org.emp.gl.gui.GameControler;
import org.emp.gl.lookup.Lookup;


public class mainClass {
    static {
        Lookup.getInstance().register(TimeServiceImpl.class,new TimeServiceImpl());
    }

    public static void main(String args[]){

        GameControler gameControler=new GameControler();
        Environnement environnement=new Environnement();
        TimeServiceImpl tsi= Lookup.getInstance().getService(TimeServiceImpl.class);
        tsi.addListener(environnement);

    }
}
