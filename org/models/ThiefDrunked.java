package org.models;

public class ThiefDrunked extends Thief {

  // Attributes
  private boolean stolen = true;

  // Constructor
  public ThiefDrunked() {}
  public ThiefDrunked(String ref, String name) {
    super(ref, name);
    System.out.println("Création du robot voleur saoul " + name + " (" + ref + ")");
  }

  @Override public void stealJewels(int x, int y, World w) {
    if (w.map[y][x].getState() == 1) {
      if (this.stolen) {
        w.map[y][x].setState(0);
        w.map[y][x].steal();
        this.stolen = false;
        //System.out.println(" -> vole les bijoux");
      } else {
        this.stolen = true;
        //System.out.println(" -> ne vole pas les bijoux");
      }
    } else {
      //System.out.print(" -> rien à voler");
    }
  }

}
