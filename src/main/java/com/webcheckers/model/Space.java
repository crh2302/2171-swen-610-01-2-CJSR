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

//TODO javadoc of Space
  public Space(Position position, boolean isBlack)
  {
    this.position = position;
    this.isBlack = isBlack;
    this.piece = null;
  }

  /**
  * Create a board space
  *
  * @param cellIdx
  *          The unique identifier for the space.
  * @param isBlack
  *          If valid a piece will be placeble
  */
  public Space(int cellIdx, boolean isBlack)
  {
      this.cellIdx = cellIdx;
      this.isBlack = isBlack;
      this.piece = null;
  }

  public Space(int cellIdx, boolean isBlack,Piece piece)
  {
    this.cellIdx = cellIdx;
    this.isBlack = isBlack;
    this.piece = piece;
  }

  /**
   *
   * @return
   */
  public int getCellIdx()
  {
        return cellIdx;
  }

  /**
   *
   * @return
   */
  public Piece getPiece()
  {
    return piece;
  }

  /**
   *
   * @param piece
   */
  public void placePiece(Piece piece)
  {
      this.piece = piece;
  }

  /**
   *
   * @return
   */
  public boolean containsPiece()
  {
    return this.piece != null;
  }

  /**
   *
   */
  public void removePiece()
  {
    this.piece = null;
  }

  /**
   *
   * @return
   */
  public boolean isBlack()
  {
      return isBlack;
  }

  /**
   *
   * @return
   */

  public boolean isValid()
  {
    return ((this.piece == null) && isBlack);
  }


}
