public class World {

  // Attributes
  private int[][] map;
  private int width;
  private int height;
  //static nbRobots

  // Contructor
  public World(int width, int height) {
    generateMap(width, height);
  }

  public void generateMap(int width, int height) {
    this.map = new int[height][width];
    if (width > 20 || height > 30) {
      System.out.print("La taille du tableau dépasse la limite autorisée de 20x30");
    } else {
      for (int y = 0; y < height; ++y) {
        for (int x = 0; x < width; ++x) {
          this.map[y][x] = 0;
        }
      }
      this.width  = width;
      this.height = height;
    }
  }

  // Accessors
  private boolean _isFree(int x, int y) {
    return this.map[y][x] == 0;
  }

  public void moveRobot(int x, int y) {
    if (_isFree(x, y)) {
      this.map[y][x] = 1;
      System.out.println("Gooot!");
    } else {
      System.out.println("C'est nuul la case est prise !");
    }
  }

  public void release(int x, int y) {
    // qui libérera la case correspondante (en attribuant la valeur -1) ;
  }

  public void occupy(int x, int y, int num) {
    // indiquera que la case est occupée par ce robot ;
  }

  private static String _repeat(String toRepeat, int times) {
    String str = "";
    for (int i = 0; i < times; i++) {
      str += toRepeat;
    }
    return str;
  }

  public void display() {
    System.out.println("--" + _repeat("---", this.width));
    for (int y = 0; y < this.height; ++y) {
      System.out.print("|");
      for (int x = 0; x < this.width; ++x) {
        System.out.print(" " + this.map[y][x] + " ");
      }
      System.out.print("|");
      System.out.println("");
    }
    System.out.println("--" + _repeat("---", this.width));
  }

}
