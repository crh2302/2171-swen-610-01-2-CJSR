package com.webcheckers.model;

/**
 * A single checkers piece
 */
public class Piece
{
  PieceType type;
  PieceColor color;

  /**
  *
  * @param color
  */
  public Piece(PieceColor color)
  {
      this.color = color;
      this.type = PieceType.MAN;
  }

  /**
  *
  * @param type
  * @param color
  */
  public Piece(PieceType type, PieceColor color)
  {
      this.color = color;
      this.type = type;
  }

  /**
  *
  * @return
  */
  public PieceType getType()
  {
      return type;
  }

  /**
  *
  * @return
  */
  public PieceColor getColor()
  {
      return color;
  }

  /**
  *
  */
  public void crownPiece()
  {
      this.type = PieceType.KING;
  }
}
