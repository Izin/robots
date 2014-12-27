package org.models;

public class Jeweler extends Robot {

  // Constructor
  public Jeweler() {}

  public Jeweler(String ref, String name) {
    super(ref, name);
    this.image = "jeweler";
  }

  public void dropJewels(int x, int y, Jewel j, World w) {
    if (w.map[y][x].getState() == 0) {
      w.map[y][x].setState(1);
      w.map[y][x].setJewel(j);
      //System.out.print(" -> perd des bijoux");
    }
  }

  @Override public void use(int x, int y, Jewel j, World w) {
    this.dropJewels(x, y, j, w);
  }

  public void changeDirection() {}

}
