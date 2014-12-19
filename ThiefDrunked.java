public class ThiefDrunked extends Thief {

  // Attributes
  private boolean steal = true;

  // Constructor
  public ThiefDrunked(String ref, String name, int x, int y) {
    super(ref, name, x, y);
    //System.out.println("Création du robot voleur " + name + " (" + ref + ")");
  }

  @Override public void stealJewels(int x, int y, World w) {
    if (w.map[y][x].getState() == 1) {
      if (this.steal) {
        w.map[y][x].setState(0);
        this.steal = false;
        System.out.print(" -> vole les bijoux");
      } else {
        this.steal = true;
        System.out.print(" -> trop saoul pour remarquer les bijoux");
      }
    } else {
      //System.out.print(" -> rien à voler");
    }
  }

}
