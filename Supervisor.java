import java.util.List;
import java.util.ArrayList;

public class Supervisor {

  // Attributes
  private String name;
  private World world;
  private List<Robot> robots = new ArrayList<Robot>();

  // Contructor
  public Supervisor(String name) {
    this.name = name;
    System.out.println("Création du superviseur " + name);
  }

  // Accessors
  public void newGame(World world, List<Robot> robots) {
    this.world = world;
    for (Robot r : robots) {
      this.robots.add(r);
      this.world.map[r.getY()][r.getX()].addRobot(r);
    }
  }

  public void displayWorld() {
    this.world.display();
  }

  public void moveRobot(int x, int y, Robot r) {
    System.out.print("Tentative de déplacement de " + r.getName() + " en case [" + x + ", " + y + "] ->");
    if (this.world.map[y][x].isFree()) {
      this.world.map[r.getY()][r.getX()].release();
      this.world.map[y][x].addRobot(r);
      System.out.print(" case disponible -> ok.");
      System.out.println("");
    } else {
      System.out.print(" case indisponible -> erreur.");
      System.out.println("");
    }
  }

  public void nextRound() {
    for (Robot r : this.robots) {
      r.move(this, this.world);
    }
    System.out.println("Nouveau tour...");
  }

  public static void main(String[] args) {
    // Supervisor
    Supervisor cortana = new Supervisor("Cortana");

    // World
    World w1 = new World(7, 7);

    // Robots
    List<Robot> robots = new ArrayList<Robot>();
    robots.add(new Jeweler("r1", "potato"));
    robots.add(new Jeweler("r2", "MichelMichel"));
    robots.add(new Jeweler("r3", "banana"));

    // Starting a new game
    cortana.newGame(w1, robots);

    cortana.displayWorld();

    cortana.nextRound();

    cortana.displayWorld();

    cortana.nextRound();

    cortana.displayWorld();
  }



}
