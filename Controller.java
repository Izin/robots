import java.util.List;
import java.util.ArrayList;

public class Controller {

  // Attributes
  private String name;
  private List<Robot> robots = new ArrayList<Robot>();

  // Contructor
  public Controller(String name) {
    this.name  = name;
    //System.out.println("Création du superviseur " + name);
  }

  // Accessors
  public void initGame(List<Robot> robots, World w) {
    setRobots(robots, w);
  }

  public void displayWorld(World w) {
    w.display();
  }

  public void moveRobot(int x, int y, Robot r, World w) {
    //System.out.print("Tentative de déplacement de " + r.getName() + " en case [" + x + ", " + y + "] ->");
    if (w.map[y][x].isFree()) {
      w.map[r.getY()][r.getX()].release();
      w.map[y][x].setRobot(r);
      r.setPosition(x, y);
      //System.out.print(" case disponible");
      r.use(x, y, w);
      //System.out.println("");
    } else {
      //System.out.print(" case indisponible");
      //System.out.println("");
    }
  }

  public void nextRound(World w) {
    //System.out.println("Nouveau tour...");
    for (Robot r : this.robots) {
      r.move(this, w);
    }
  }

  public void setRobots(List<Robot> robots, World w) {
    for (Robot r : robots) {
      this.addRobot(r, w);
    }
  }

  public void removeRobot(Robot r, World w) {
    for (Robot robot : robots) {
      w.map[r.getY()][r.getX()].setRobot(null);
      this.robots.remove(robot);
    }
  }

  public void addRobot(Robot r, World w) {
    this.robots.add(r);
    w.map[r.getY()][r.getX()].setRobot(r);
  }

  public void update(World w) {
    this.nextRound(w);
    this.displayWorld(w);
  }

  public static void main(String[] args) {
    Controller c1      = new Controller("Cortana");
    World w1           = new World(7, 7);
    Timer t1           = new Timer(750, c1);
    List<Robot> robots = new ArrayList<Robot>();
                         robots.add(new JewelerMadman("r1", "potato", 0, 0));
                         robots.add(new ThiefExpert("r2", "MichelMichel", 0, 1));
                         robots.add(new ThiefDrunked("r3", "banana", 0, 2));

    c1.initGame(robots, w1);
    t1.start(w1);
  }

}
