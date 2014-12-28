package org.models;


/**
 * A ThiefDrunked is a drunked robot that steal a jewel half time
 *
 * @author  Malo Blanchard
 * @version 0.9
 * @see     Thief
 */
public class ThiefDrunked extends Thief {

  private boolean stolen = true;

  /**
   * Build a new instance of ThiefDrunked
   *
   * @param  ref   Robot #reference, like an id (eg: R2)
   * @param  name  name of the robot
   */
  public ThiefDrunked() {}
  public ThiefDrunked(String ref, String name) {
    super(ref, name);
    this.image = "drunked";
  }

  /**
   * Try stealing a jewel in a specific cell (using x and y). But because
   * of it's state, this robot type can steal only one jewel of two.
   *
   * @param  x  First part of the targeted cell's coordinates
   * @param  y  Second part of the targeted cell's coordinates
   * @param  w  Instance of World model
   */
  @Override public void stealJewel(int x, int y, World w) {
    if (w.grid[y][x].hasJewel()) {
      if (!this.stolen) {
        w.grid[y][x].steal();
        this.stolen = true;
      } else {
        this.stolen = false;
      }
    }
  }

}
