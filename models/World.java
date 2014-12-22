package models;

public class World {

  // Attributes
  public Cell[][] map;
  private int width;
  private int height;
  //static nbRobots

  // Contructor
  public World(int width, int height) {
    generateMap(width, height);
    System.out.println("Création du monde (" + width + "x" + height + ")");
  }

  public void generateMap(int width, int height) {
    this.map = new Cell[height][width];
    if (width > 20 || height > 30) {
      //System.out.print("La taille du tableau dépasse la limite autorisée de 20x30");
    } else {
      for (int y = 0; y < height; ++y) {
        for (int x = 0; x < width; ++x) {
          this.map[y][x] = new Cell();
        }
      }
      this.width  = width;
      this.height = height;
    }
  }

  // Accessors
  private static String _repeat(String toRepeat, int times) {
    String str = "";
    for (int i = 0; i < times; i++) {
      str += toRepeat;
    }
    return str;
  }

  public void display() {
    System.out.println("--" + _repeat("----", this.width));
    for (int y = 0; y < this.height; ++y) {
      System.out.print("|");
      for (int x = 0; x < this.width; ++x) {
        System.out.print(" " + this.map[y][x].show() + " ");
      }
      System.out.print("|");
      System.out.println("");
    }
    System.out.println("--" + _repeat("----", this.width));
  }

  public boolean isCell(int x, int y) {
    return (isCoord(x, this.width) && isCoord(y, this.height));
  }

  public boolean isCoord(int n, int max) {
    return (n > -1 && n < max);
  }

  public int getWidth()   { return this.width;  }
  public int getHeight()  { return this.height; }

}
