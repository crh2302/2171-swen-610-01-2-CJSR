package com.webcheckers.model;

public class Space
{
    private int cellIdx;
    private boolean isBlack;
    private Piece piece = null;

  //
  // Constructor
  //
  /**
   * Create a board space.
   * @param cellIdx
   *        Cell number from left to right.
   * @param isBlack
   *        True for black spaces.
   * @param piece
   *        The piece to be placed in the space.
   */
  public Space(int cellIdx, boolean isBlack, Piece piece)
  {
    this.cellIdx = cellIdx;
    this.isBlack = isBlack;
    this.piece = piece;
  }

  /**
   * Return the cell number of a space.
   * @return
   *      The cell number.
   */
  public int getCellIdx()
  {
        return cellIdx;
  }

  /**
   *Return the piece place on a space.
   * @return
   *      The piece placed on the space.
   */
  public Piece getPiece()
  {
    return piece;
  }

  /**
   * Return if is valid to make a move to the space.
   * @return
   *    Return true if a piece can be placed in that space.
   */

  public boolean isValid()
  {
    return ((this.piece == null) && isBlack);
  }

  public Piece populateSpaceMan()
  {
    Piece pi = piece;
    piece = null;
    return pi;
  }

  public Piece populateSpaceKing(String color)
  {
    piece = null;
    return new Piece("KING",color);
  }

  public void setPiece(Piece piece)
  {
    this.piece = piece;
  }
}
