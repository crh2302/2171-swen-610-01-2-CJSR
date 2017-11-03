package com.webcheckers.model;

public class Space
{
    private int cellIdx;
    private boolean isBlack;
    private Piece piece = null;
    private Position position;
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
   * Place piece in a space
   * @param piece
   *        Piece to be placed on the space.
   */
  public void placePiece(Piece piece)
  {
      this.piece = piece;
  }

  /**
   * Return true if the space contains a piece.
   * @return
   *    Return true if the space contains a piece.
   */
  public boolean containsPiece()
  {
    return this.piece != null;
  }

  /**
   * Removes piece from space.
   */
  public void removePiece()
  {
    this.piece = null;
  }

  /**
   * Returns if the space is black.
   * @return
   *    Return true if the space is black.
   */
  public boolean isBlack()
  {
      return isBlack;
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

  /**
   * Return the position of the space.
   * @param position
   *        Return the position of the space.
   */
  public void setPosition(Position position)
  {
    this.position = position;
  }

}
