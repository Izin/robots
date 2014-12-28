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
  public Jewel() {
    int r  = (int) Math.abs(Math.random() * 4);

    switch(r) {
      case 0 : this.image = "jewel0"; break;
      case 1 : this.image = "jewel1"; break;
      case 2 : this.image = "jewel2"; break;
      case 3 : this.image = "jewel3"; break;
      default: this.image = "jewel"; break;
    }
  }

  /**
   * Return a string corresponding to the image of a jewel
   *
   * @return  name without extention
   */
  public String getImage() {
    return this.image;
  }

}
