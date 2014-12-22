import java.util.ArrayList;

import controllers.*;
import models.*;
//import views.*;

public class App {

  public static void main(String[] args) {

    Controller c1      = new Controller();
    World w1           = new World(10, 10);
    Timer t1           = new Timer(1000, c1);

    ArrayList<Robot> robots = new ArrayList<Robot>();
                     robots.add(new JewelerMadman("J1", "potato"));
                     robots.add(new JewelerJumper("J2", "banana"));
                     robots.add(new ThiefExpert("T3", "MichelMichel"));
                     robots.add(new ThiefDrunked("T2", "JHackCheerAK"));

    c1.initGame(robots, w1);
    t1.start(w1);

  }

}

