package com.webcheckers.model;

/**
 * A single checkers piece
 */
public class Piece
{
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

  public void setType(String type)
  {
    this.type = type;
  }

  public void setColor(String color)
  {
    this.color = color;
  }

  /**
  *
  * @return
  */
  public String getType()
  {
      return type;
  }

  /**
  *
  * @return
  */
  public String getColor()
  {
      return color;
  }

  /**
  *
  */
  public void crownPiece()
  {
      this.type = "KING";
  }
}
