import java.util.List;
import java.util.ArrayList;

public class Supervisor {

  // Attributes
  private String name;
  private List<Robot> robots = new ArrayList<Robot>();

  // Contructor
  public Supervisor(String name) {
    this.name  = name;
    //System.out.println("Création du superviseur " + name);
  }

  // Accessors
  public void newGame(List<Robot> robots, World w) {
    setRobots(robots, w);
  }

  public void displayWorld(World w) {
    w.display();
  }

  public void moveRobot(int x, int y, String method, Robot r, World w) {
    //System.out.print("Tentative de déplacement de " + r.getName() + " en case [" + x + ", " + y + "] ->");
    if (w.map[y][x].isFree()) {
      w.map[r.getY()][r.getX()].release();
      w.map[y][x].setRobot(r);
      r.setPosition(x, y);
      //System.out.print(" case disponible");
      switch (method) {
        case "dropJewels" : r.dropJewels(x, y, w);  break;
        case "stealJewels": r.stealJewels(x, y, w); break;
        default           :                         break;
      }
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
    // Supervisor
    Supervisor cortana = new Supervisor("Cortana");

      // World
      World w1 = new World(10, 10);

      // Timer
      Timer t1 = new Timer(1000, cortana);

      // Robots
      List<Robot> robots = new ArrayList<Robot>();
      robots.add(new Jeweler("r1", "potato", 0, 0));
      robots.add(new Thief("r2", "MichelMichel", 0, 1));
      robots.add(new Thief("r3", "banana", 0, 2));


      // Starting a new game
      cortana.newGame(robots, w1);

        // Début du thread
        t1.start(w1);
  }



}
