import java.util.List;
import java.util.ArrayList;

public class Controller {

  // Attributes
  private List<Robot> robots = new ArrayList<Robot>();

  // Contructor
  public Controller() {
    System.out.println("Création du controlleur");
  }

  // Accessors
  public void update(World w) {
    for (Robot r : this.robots) {
      r.move(this, w);
    }
    w.display();
  }

  public void initGame(List<Robot> robots, World w) {
    setRobots(robots, w);
  }

  public void moveRobot(int x, int y, Robot r, World w) {
    //System.out.print("Tentative de déplacement de " + r.getName() + " en case [" + x + ", " + y + "] ->");
    if (w.isCell(x, y)) {
      if (w.map[y][x].isFree()) {
        w.map[r.getY()][r.getX()].release();
        w.map[y][x].setRobot(r);
        r.setPosition(x, y, w);
        //System.out.print(" case disponible");
        r.use(x, y, w);
        //System.out.println("");
      } else {
        //System.out.print(" case indisponible");
        //System.out.println("");
      }
    } else {
      //System.out.print(" case innexistante");
      //System.out.println("");
      if (r instanceof JewelerMadman) {
        r.setDirection();
      }
      r.move(this, w);
      //System.out.println("");
    }
    //System.out.println("");
  }

  public void setRobots(List<Robot> robots, World w) {
    for (Robot r : robots) {
      this.addRobot(r, w);
    }
  }

  public void addRobot(Robot r, World w) {
    this.robots.add(r);
    w.map[r.getY()][r.getX()].setRobot(r);
  }

/*  public void removeRobot(Robot r, World w) {
    for (Robot robot : robots) {
      w.map[r.getY()][r.getX()].setRobot(null);
      this.robots.remove(robot);
    }
  }*/

  public static void main(String[] args) {
    Controller c1      = new Controller();
    World w1           = new World(10, 10);
    Timer t1           = new Timer(1000, c1);
    List<Robot> robots = new ArrayList<Robot>();
                robots.add(new JewelerMadman("J1", "potato"));
                robots.add(new JewelerJumper("J2", "banana"));
                robots.add(new ThiefExpert("T3", "MichelMichel"));
                robots.add(new ThiefDrunked("T2", "JHackCheerAK"));
    c1.initGame(robots, w1);
    t1.start(w1);
  }

}
