package org.models;
import org.controllers.*;


/**
 * A jewel
 *
 * @author  Malo Blanchard
 * @version 0.9
 */
public class Jewel {

  protected String image = "jewel";

  /**
   * Build a new instance of Jewel
   */
  public Jewel() {}

  /**
   * Return a string corresponding to the image of a jewel
   *
   * @return  name without extention
   */
  public String getImage() {
    return this.image;
  }

}
