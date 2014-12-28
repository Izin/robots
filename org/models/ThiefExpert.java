package org.models;

public class ThiefExpert extends Thief {

  // Attributes

  // Constructor
  public ThiefExpert() {}
  public ThiefExpert(String ref, String name) {
    super(ref, name);
    this.image = "expert";
    System.out.println("Création du robot voleur expert " + name + " (" + ref + ")");
  }

  @Override public void stealJewel(int x, int y, World w) {
    if (w.map[y][x].hasJewel()) {
      w.map[y][x].steal();
      System.out.println(" -> vole les bijoux");
    } else {
      //System.out.print(" -> rien à voler");
    }
  }

}
