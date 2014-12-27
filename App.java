import org.controllers.*;
import org.models.*;
import org.views.*;
import java.util.ArrayList;

public class App {

  public static void main(String[] args) {

    int width  = args.length == 0 ? 10   : Integer.parseInt(args[0]);
    int height = args.length <= 1 ? 10   : Integer.parseInt(args[1]);
    int speed  = args.length <= 2 ? 1000 : Integer.parseInt(args[2]);

    Controller c1 = new Controller();
    World      w1 = new World(width, height);
    Timer      t1 = new Timer(speed, c1);
    SPanel     p1 = new SPanel();
    SWindow   win = new SWindow("iRobots", w1.getWidth(), w1.getHeight(), p1);

    ArrayList<Robot> robots = new ArrayList<Robot>();
                     robots.add(new JewelerMadman("J1", "potato"));
                     robots.add(new JewelerJumper("J2", "banana"));
                     robots.add(new ThiefExpert("T3", "MichelMichel"));
                     robots.add(new ThiefDrunked("T2", "JHackCheerAK"));

    c1.initGame(robots, w1);
    t1.start(w1);

  }

}

