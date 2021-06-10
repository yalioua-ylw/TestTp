package org.emp.gl.player;


public class Rebot  {
    public String direction="down";//initialement a down
    int x;int y;

    public void changeDirection(String dir){
        this.direction=dir;
    }
    private Rebot(){}
    public static Rebot getInstance() {
        return RebotHolder.INSTANCE;
    }

    private static class RebotHolder {

        private static final Rebot INSTANCE = new Rebot();
    }
}
