package org.models;
import org.controllers.*;


/**
 * A JewelerMadman is a robot that allways moves in the same direction.
 * It can be top, left, right or bottom the current cell.
 *
 * @author  Malo Blanchard
 * @version 0.9
 * @see     Jeweler
 */
public class JewelerMadman extends Jeweler {

  private int direction = 0;

  /**
   * Build a new instance of JewelerMadman
   *
   * @param  ref   Robot #reference, like an id (eg: R2)
   * @param  name  name of the robot
   */
  public JewelerMadman() {}
  public JewelerMadman(String ref, String name) {
    super(ref, name);
    this.image = "madman";
    System.out.println("Création du robot bijoutier fou " + name + " (" + ref + ")");
    this.setDirection();
  }

  /**
   * Override the Jeweler move() method. Calculate coordinates.
   *
   * @param  c  Instance of the Controller
   * @param  w  Instance of World model
   */
  @Override public void move(Controller c, World w) {
    //System.out.println("Direction : " + direction);
    int x = this.x;
    int y = this.y;
    switch(this.direction) {
      case 0 : y--; break; // top
      case 1 : x++; break; // right
      case 2 : y++; break; // bottom
      default: x--; break; // left
    }
    c.moveIfPossible(x, y, this, w);
  }

  /**
   * Find a number corresponding to a global direction.
   */
  @Override public void setDirection() {
    this.direction = (int) Math.abs(Math.random() * 4);
    //System.out.println("Direction de J1 : " + this.direction);
  }

}
