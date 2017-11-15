package com.webcheckers.model;

/**
 * A single checkers piece
 */
public class Piece
{

  //
  // Atrributes
  //

  String type;
  String color;

  /**
  * Construct a piece with the specified type and color.
  * @param type
  *         Can be a MAN or a KING.
  * @param color
   *        Can be RED or WHITE.
  */
  public Piece(String type, String color)
  {
      this.color = color;
      this.type = type;
  }

  /**
   * Set type mutator.
   *
   * @param type
   */
  public void setType(String type)
  {
    this.type = type;
  }

  /**
  *
  * @return
   *    type of piece.
  */
  public String getType(){
      return type;
  }

  /**
  *
  * @return
   *    color of disc.
  */
  public String getColor(){
      return color;
  }

  /**
  * change disc from MAN to KING.
  */
  public void crownPiece() {
      this.type = "KING";
  }

  public boolean isKing(Piece piece){
      return piece.getType().equals("KING");
  }

  public boolean isSingle(Piece piece){
    return piece.getType().equals("SINGLE");
  }

  public boolean isRed(Piece piece){
    return piece.getColor().equals("RED");
  }

  public boolean isWhite(Piece piece){
    return piece.getColor().equals("WHITE");
  }
}
