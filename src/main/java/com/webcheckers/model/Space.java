package com.webcheckers.model;

public class Space
{
    private int cellIdx;
    private Position position;
    private boolean isValid;
    private Piece piece = null;

  //
  // Constructor
  //

//TODO javadoc of Space
  public Space(Position position, boolean isValid)
  {
    this.position = position;
    this.isValid = isValid;
    this.piece = null;
  }

  /**
  * Create a board space
  *
  * @param cellIdx
  *          The unique identifier for the space.
  * @param isValid
  *          If valid a piece will be placeble
  */
  public Space(int cellIdx, boolean isValid)
  {
      this.cellIdx = cellIdx;
      this.isValid = isValid;
      this.piece = null;
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
    return this.piece == null;
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
  public boolean isValid()
  {
      return isValid;
  }

  /**
   *
   * @return
   */
  //public Position getPosition()
  //{
  //    return position;
  //}

}
