package org.models;

import org.models.Jewel;

public class Jeweler extends Robot {

  // Constructor
  public Jeweler() {}

  public Jeweler(String ref, String name) {
    super(ref, name);
  }

  public void dropJewels(int x, int y, World w) {
    if (!w.map[y][x].hasJewel()) {
      w.map[y][x].setJewel(new Jewel());
      //System.out.print(" -> perd des bijoux");
    }
  }

  @Override public void use(int x, int y, World w) {
    this.dropJewels(x, y, w);
  }

  public void changeDirection() {}

}
