package com.webcheckers.model;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 *  Class to implement the board's Rows
 *
 */
public class Row implements Iterable<Space>
{
  //
  // Attributes
  //

  private ArrayList<Space> spaces;
  private int index;

  //
  // Constants
  //

  static final int ROW_AMMOUT = 8;

  /**
   * accessor for list of spaces
   *
   * @return
   *    list of spaces
   */
  public ArrayList<Space> getSpaces()
  {
    return spaces;
  }

  /**
   * mutator for list of spaces
   *
   * @param spaces
   *
   */
  public void setSpaces(ArrayList<Space> spaces)
  {
    this.spaces = spaces;
  }

  /**
   * accessor for index
   *
   * @return
   *     index
   */
  public int getIndex()
  {
    return index;
  }

  /**
   * mutator for index
   *
   * @param index
   *
   */
  public void setIndex(int index)
  {
    this.index = index;
  }

  /**
   * Constructor
   *
   *
   * @param index
   *
   */
  public Row(int index) {
    this.index = index;
    this.spaces = new ArrayList<Space>(ROW_AMMOUT);

    if (index == 0 || index == 2) {
      spaces.add(new Space(0, false, null));
      spaces.add(new Space(1, true, new Piece("SINGLE", "WHITE")));
      spaces.add(new Space(2, false, null));
      spaces.add(new Space(3, true, new Piece("SINGLE", "WHITE")));
      spaces.add(new Space(4, false, null));
      spaces.add(new Space(5, true, new Piece("SINGLE", "WHITE")));
      spaces.add(new Space(6, false, null));
      spaces.add(new Space(7, true, new Piece("SINGLE", "WHITE")));


    }

    if (index == 1) {
      spaces.add(new Space(0, true, new Piece("SINGLE", "WHITE")));
      spaces.add(new Space(1, false, null));
      spaces.add(new Space(2, true, new Piece("SINGLE", "WHITE")));
      spaces.add(new Space(3, false, null));
      spaces.add(new Space(4, true, new Piece("SINGLE", "WHITE")));
      spaces.add(new Space(5, false, null));
      spaces.add(new Space(6, true, new Piece("SINGLE", "WHITE")));
      spaces.add(new Space(7, false, null));
    }

    if (index == 5 || index == 7) {
      spaces.add(new Space(0, true, new Piece("SINGLE", "RED")));
      spaces.add(new Space(1, false, null));
      spaces.add(new Space(2, true, new Piece("SINGLE", "RED")));
      spaces.add(new Space(3, false, null));
      spaces.add(new Space(4, true, new Piece("SINGLE", "RED")));
      spaces.add(new Space(5, false, null));
      spaces.add(new Space(6, true, new Piece("SINGLE", "RED")));
      spaces.add(new Space(7, false, null));


    }

    if (index == 6) {
      spaces.add(new Space(0, false, null));
      spaces.add(new Space(1, true, new Piece("SINGLE", "RED")));
      spaces.add(new Space(2, false, null));
      spaces.add(new Space(3, true, new Piece("SINGLE", "RED")));
      spaces.add(new Space(4, false, null));
      spaces.add(new Space(5, true, new Piece("SINGLE", "RED")));
      spaces.add(new Space(6, false, null));
      spaces.add(new Space(7, true, new Piece("SINGLE", "RED")));
    }
  }

  /**
   * place piece
   *
   * @param index
   * @param piece
   *
   */
  public void placePiece(int index, Piece piece)
  {
    this.spaces.get(index).placePiece(piece);
  }

  @Override
  public Iterator<Space> iterator()
  {
    return this.spaces.iterator();
  }

  /**
   * add space to lists of spaces
   *
   * @param space
   *
   */
  public void add(Space space)
  {
    this.spaces.add(space);
  }

  /**
   * add index and space to list of spaces
   *
   * @param index
   * @param space
   *
   */
  public void add(int index, Space space)
  {
    this.spaces.add(index,space);
  }
}
