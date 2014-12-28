import org.controllers.*;
import org.models.*;
import org.views.*;
import java.util.ArrayList;


/**
 * App.java - Entry point of the application
 *
 * @author  Malo Blanchard <contact@maloblanchard.com>
 * @version 0.9
 */
public class App {

  /**
   * Initialize the grid, the robots, etc., and then start the timer
   *
   * @param  args[0]  Number of x-cells for the grid,
   * @param  args[0]  Number of y-cells for the grid,
   * @param  args[2]  Time between 2 refresh of the grid
   */
  public static void main(String[] args) {
    int imgDim = 65;
    int width  = args.length == 0 ? 10   : Integer.parseInt(args[0]);
    int height = args.length <= 1 ? 10   : Integer.parseInt(args[1]);
    int speed  = args.length <= 2 ? 1000 : Integer.parseInt(args[2]);

    Controller c1 = new Controller();
    World      w1 = new World(width, height);
    Grid       g1 = new Grid(w1, imgDim);
    WorldView  v1 = new WorldView(w1, g1, imgDim);
    Timer      t1 = new Timer(speed, c1, g1);

    ArrayList<Robot> robots = new ArrayList<Robot>();
                     robots.add(new JewelerMadman("J1", "potato"));
                     robots.add(new JewelerJumper("J2", "banana"));
                     //robots.add(new ThiefExpert("T3", "MichelMichel"));
                     robots.add(new ThiefDrunked("T2", "JHackCheerAK"));

    c1.setRobots(robots, w1);
    t1.start(w1);
  }

}
