package com.webcheckers.model;


/**
 * Location in terms of cell and row
 */
public class Position
{

    //
    // Attributes
    //

      private final int row;
      private final int cell;

      /**
      * Constructor
       *
       *
      * @param row
      * @param cell
      */
      public Position(int row, int cell)
      {
          this.row = row;
          this.cell = cell;
      }

      /**
      *
      * @return
       *    return the row of the position.
      */
      public int getRow()
      {
          return row;
      }

      /**
      *
      * @return
       *    returns the cell of the position.
      */
      public int getCell()
      {
          return cell;
      }
    }
