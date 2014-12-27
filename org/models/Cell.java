package org.models;

public class Cell {

  // Attributes
  private int state    = 0; // todo a virer bordel
  private Jewel jewel  = null;
  private Robot robot  = null;
  private String image = "cell";

  // Contructor
  public Cell() {}

  // Accessors
  public boolean isFree() {
    return this.robot instanceof Robot == false;
  }

  public boolean hasJewel() {
    return this.jewel instanceof Jewel;
  }

  public void release() {
    this.robot = null;
  }

  public void steal() {
    this.jewel = null;
  }

  public String show() {
    if (this.robot instanceof Robot) {
      return robot.getImage();
    } else if (this.jewel instanceof Jewel) {
      return jewel.getImage();
    } else {
      return this.image;
    }
  }

  public int getState()             { return this.state;  }
  public Jewel getJewel()           { return this.jewel;  }
  public void setState(int state)   { this.state = state; }
  public void setJewel(Jewel jewel) { this.jewel = jewel; }
  public void setRobot(Robot robot) { this.robot = robot; }
}
