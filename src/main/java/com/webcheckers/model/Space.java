package com.webcheckers.model;

import static spark.Spark.halt;

/**
 * Represents a space on the checkers board
 */
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

  public int getCellIdx() {
    return cellIdx;
  }

  public void setPiece(Piece piece) {
    this.piece = piece;
  }

  public Piece getPiece() {
    return piece;
  }

  /**
   * Return if is valid to make a move to the space.
   * @return
   *    Return true if a piece can be placed in that space.
   */
  public boolean isValid() {
    return ((this.piece == null) && isBlack);
  }


  /**
   * populate space with a MAN piece
   * @return
   *     the piece
   */
  public Piece populateSpaceMan()
  {
    Piece pi = piece;
    piece = null;
    return pi;
  }


  /**
   * populate space with a KING piece
   * @param
   *      color
   * @return
   *      KING piece of necessary color
   */
  public Piece populateSpaceKing(String color) {
    piece = null;
    return new Piece("KING",color);
  }

  public boolean isBlack(){
    return isBlack;
  }

  public boolean getOtherSpace(int row, int column, Board board, String color) {
    if (color.equals("RED")) {
      if(column - 1 < 0 || column + 1 > 7 || column + 2 > 7 || column - 2 < 0
              || row + 2 > 7 || row - 2 < 0 || row + 1 > 7 || row + 1 > 7){
          //do nothing because those columns don't exist
      }
      else{
          Space space = board.getRows().get(row - 1).getSpaces().get(column + 1);
          Space space2 = board.getRows().get(row - 1).getSpaces().get(column - 1);
          if (space.isValid() || space2.isValid()) {
            return true;
          }
          else {
            Space space3 = board.getRows().get(row - 2).getSpaces().get(column + 2);
            Space space4 = board.getRows().get(row - 2).getSpaces().get(column - 2);
            if (space3.isValid() || space4.isValid()){
              return true;
            }
            else{
              return false;
            }
          }
      }
    }
    else if (color.equals("WHITE")){
      if(column - 1 < 0 || column + 1 > 7 || column + 2 > 7 || column - 2 < 0
              || row + 2 > 7 || row - 2 < 0 || row + 1 > 7 || row + 1 > 7){
        //do nothing because those columns don't exist
      }
      else{
        Space space = board.getRows().get(row + 1).getSpaces().get(column + 1);
        Space space2 = board.getRows().get(row + 1).getSpaces().get(column - 1);
        if (space.isValid() || space2.isValid()) {
          return true;
        }
        else {
          Space space3 = board.getRows().get(row + 2).getSpaces().get(column + 2);
          Space space4 = board.getRows().get(row + 2).getSpaces().get(column - 2);
          if (space3.isValid() || space4.isValid()) {
            return true;
          }
          else{
            return false;
          }
        }
      }
    }
    return true;
  }
}
