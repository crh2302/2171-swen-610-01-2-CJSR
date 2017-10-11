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
  *
  * @param color
  */
  public Piece(String color)
  {
      this.color = color;
      this.type = "SINGLE";
  }

  /**
  *
  * @param type
  * @param color
  */
  public Piece(String type, String color)
  {
      this.color = color;
      this.type = type;
  }

  /**
   * Set type mutator
   *
   * @param type
   */
  public void setType(String type)
  {
    this.type = type;
  }

  /**
   * Set color mutator
   *
   * @param color
   */
  public void setColor(String color)
  {
    this.color = color;
  }

  /**
  *
  * @return
   *    type of piece
  */
  public String getType()
  {
      return type;
  }

  /**
  *
  * @return
   *    color of disc
  */
  public String getColor()
  {
      return color;
  }

  /**
  * change disc from MAN to KING
  */
  public void crownPiece()
  {
      this.type = "KING";
  }
}
