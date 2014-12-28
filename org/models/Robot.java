package org.models;
import org.controllers.*;

/**
 * A robot
 *
 * @author  Malo Blanchard
 * @version 0.9
 */
public abstract class Robot {

  protected String ref   = "R0";
  protected String name  = "iRobot";
  protected int    x     = 0;
  protected int    y     = 0;
  protected String image = "robot";

  /**
   * Build a new instance of Robot
   *
   * @param  ref   Robot #reference, like an id (eg: R2)
   * @param  name  name of the robot
   */
  public Robot() {}
  public Robot(String ref, String name) {
    this.ref  = ref;
    this.name = name;
  }

  /**
   * Set the position of the robot in the World
   *
   * @param  x  First part of the targeted cell's coordinates
   * @param  y  Second part of the targeted cell's coordinates
   * @param  w  Instance of World model
   */
  public void setPosition(int x, int y, World w) {
    this.x = w.isCoord(x, w.getWidth())  ? x : this.x;
    this.y = w.isCoord(x, w.getHeight()) ? y : this.y;
  }

  /**
   * Move the robot
   *
   * @param  c  Instance of the Controller
   * @param  w  Instance of World model
   */
  public void move(Controller c, World w) {}

  /**
   * Global method for the robots, used to drop or steal a jewel regarding to
   * the Robot type.
   *
   * @param  x  First part of the targeted cell's coordinates
   * @param  y  Second part of the targeted cell's coordinates
   * @param  w  Instance of World model
   */
  public void use(int x, int y, World w) {}

  /**
   * Set the global direction of a Robot (for Madman ones)
   */
  public void setDirection() {}

  /**
   * Return the coordinate X of the robot
   *
   * @return  x  First part of the robot coordinates
   */
  public int getX() {
    return this.x;
  }

  /**
   * Return the coordinate Y of the robot
   *
   * @return  y  Second part of the robot coordinates
   */
  public int getY() {
    return this.y;
  }

  /**
   * Return the ref of a robot
   *
   * @return  ref
   */
  public String getRef() {
    return this.ref;
  }

  /**
   * Return the name of the robot
   *
   * @return  name
   */
  public String getName() {
    return this.name;
  }

  /**
   * Return a string corresponding to an image of this type of robot
   * @return  image
   */
  public String getImage() {
    return this.image;
  }

}
