package org.models;


/**
 * A World
 *
 * @author  Malo Blanchard
 * @version 0.9
 */
public class World {

  public Cell[][] grid; // todo WOULALA horrible ! remplacer par un getWorld!
  private int width;
  private int height;

  /**
   * Build a new instance of World
   *
   * @param  width   Number of x-cells
   * @param  height  Number of y-cells
   */
  public World() {}
  public World(int width, int height) {
    generateGrid(width, height);
  }

  /**
   * Automaticaly generate the grid|map of X * Y cells
   *
   * @param  width   Number of x-cells
   * @param  height  Number of y-cells
   */
  public void generateGrid(int width, int height) {
    this.grid = new Cell[height][width];
    if (width > 20 || height > 30) {
    } else {
      for (int y = 0; y < height; ++y) {
        for (int x = 0; x < width; ++x) {
          this.grid[y][x] = new Cell();
        }
      }
      this.width  = width;
      this.height = height;
    }
  }

  /**
   * Check if a cell corresponding to x and y parameters exists
   *
   * @param  x  First part of the cell's coordinates
   * @param  y  Second part of the cell's coordinates
   * @return    true if the cell exists
   */
  public boolean isCell(int x, int y) {
    return (isCoord(x, this.width) && isCoord(y, this.height));
  }

  /**
   * Check the number that correspond to a part of the cell's coordinates
   *
   * @param  n    Value
   * @param  max  Maximum value available
   * @return      true if n is a valid coordinate
   */
  public boolean isCoord(int n, int max) {
    return (n > -1 && n < max);
  }

  /**
   * Get the number of x-cells in the World
   *
   * @return  width
   */
  public int getWidth() {
    return this.width;
  }

  /**
   * Get the number of y-cells in the World
   *
   * @return  height
   */
  public int getHeight() {
    return this.height;
  }

}
