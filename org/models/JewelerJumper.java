package org.models;

import org.controllers.*;

public class JewelerJumper extends Jeweler {

  // Constructor
  public JewelerJumper() {}

  public JewelerJumper(String ref, String name) {
    super(ref, name);
    System.out.println("Création du robot bijoutier sauteur " + name + " (" + ref + ")");
  }

  @Override public void move(Controller c, World w) {
    int x = this.x;
    int y = this.y;
    int r = (int) Math.abs(Math.random() * 8);
    //System.out.println("Possibilité de 0 à 7 : : " + r);
    switch(r) {
      case 0 : x -= 2; y -= 2; break; // top-left
      case 1 : x++;    y -= 2; break; // top-right
      case 2 : x += 2; y--;    break; // right-top
      case 3 : x += 2; y += 2; break; // right-bottom
      case 4 : x++;    y += 2; break; // bottom-right
      case 5 : x--;    y += 2; break; // bottom-left
      case 6 : x -= 2; y++;    break; // left-bottom
      default: x -= 2; y -= 2; break; // left-top
    }
    c.moveIfPossible(x, y, this, w);
  }

}
