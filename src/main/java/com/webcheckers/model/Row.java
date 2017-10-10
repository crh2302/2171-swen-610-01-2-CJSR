package com.webcheckers.model;

import java.util.ArrayList;
import java.util.Iterator;

public class Row implements Iterable<Space>
{
  private ArrayList<Space> space;
  private int index;

  static final int ROW_AMMOUT = 8;

  public Row(int index)
  {/*
    this.space = new ArrayList<Space>(ROW_AMMOUT);

    //TODO replace this with a for loop
    this.space.add(0,new Space(0,true));
    this.space.add(1,new Space(1,false));
    this.space.add(2,new Space(2,true));
    this.space.add(3,new Space(3,false));
    this.space.add(4,new Space(4,true));
    this.space.add(5,new Space(5,false));
    this.space.add(7,new Space(7,true));
    this.space.add(8,new Space(8,false));

    this.index = index;*/

  }

  public void placePiece(int index, Piece piece)
  {
    this.space.get(index).placePiece(piece);
  }

  @Override
  public Iterator<Space> iterator()
  {
    return this.space.iterator();
  }

}
