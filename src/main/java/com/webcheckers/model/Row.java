package com.webcheckers.model;

import java.util.ArrayList;
import java.util.Iterator;

public class Row implements Iterable<Space>
{
  private ArrayList<Space> spaces;
  private int index;

  static final int ROW_AMMOUT = 8;

  public ArrayList<Space> getSpaces()
  {
    return spaces;
  }

  public void setSpaces(ArrayList<Space> spaces)
  {
    this.spaces = spaces;
  }

  public int getIndex()
  {
    return index;
  }

  public void setIndex(int index)
  {
    this.index = index;
  }

  public Row(int index)
  {
    this.index = index;
    this.spaces = new ArrayList<Space>(ROW_AMMOUT);

    //TODO convert all of this into a loop
    if (index == 0 || index == 2)
    {
      spaces.add(new Space(0,false, null));
      spaces.add(new Space(1,true, new Piece("SINGLE","WHITE")));
      spaces.add(new Space(2,false, null));
      spaces.add(new Space(3,true, new Piece("SINGLE","WHITE")));
      spaces.add(new Space(4,false, null));
      spaces.add(new Space(5,true, new Piece("SINGLE","WHITE")));
      spaces.add(new Space(6,false, null));
      spaces.add(new Space(7,true, new Piece("SINGLE","WHITE")));


    }

    if (index == 1)
    {
      spaces.add(new Space(0,true, new Piece("SINGLE","WHITE")));
      spaces.add(new Space(1,false, null));
      spaces.add(new Space(2,true, new Piece("SINGLE","WHITE")));
      spaces.add(new Space(3,false, null));
      spaces.add(new Space(4,true, new Piece("SINGLE","WHITE")));
      spaces.add(new Space(5,false, null));
      spaces.add(new Space(6,true, new Piece("SINGLE","WHITE")));
      spaces.add(new Space(7,false, null));
    }

    if (index == 5 || index == 7)
    {
      spaces.add(new Space(0,true, new Piece("SINGLE","RED")));
      spaces.add(new Space(1,false, null));
      spaces.add(new Space(2,true, new Piece("SINGLE","RED")));
      spaces.add(new Space(3,false, null));
      spaces.add(new Space(4,true, new Piece("SINGLE","RED")));
      spaces.add(new Space(5,false, null));
      spaces.add(new Space(6,true, new Piece("SINGLE","RED")));
      spaces.add(new Space(7,false, null));


    }

    if (index == 6)
    {
      spaces.add(new Space(0,false, null));
      spaces.add(new Space(1,true, new Piece("SINGLE","RED")));
      spaces.add(new Space(2,false, null));
      spaces.add(new Space(3,true, new Piece("SINGLE","RED")));
      spaces.add(new Space(4,false, null));
      spaces.add(new Space(5,true, new Piece("SINGLE","RED")));
      spaces.add(new Space(6,false, null));
      spaces.add(new Space(7,true, new Piece("SINGLE","RED")));
    }
/*
    if(index == 4)
    {
      spaces.add(new Space(0,false, null));
      spaces.add(new Space(1,true, null));
      spaces.add(new Space(2,false, null));
      spaces.add(new Space(3,true, null));
      spaces.add(new Space(4,false, null));
      spaces.add(new Space(5,true, null));
      spaces.add(new Space(6,false, null));
      spaces.add(new Space(7,true, null));

    }

    if(index == 5)
    {
      spaces.add(new Space(0,true, null));
      spaces.add(new Space(1,false, null));
      spaces.add(new Space(2,true, null));
      spaces.add(new Space(3,false, null));
      spaces.add(new Space(4,true, null));
      spaces.add(new Space(5,false, null));
      spaces.add(new Space(6,true, null));
      spaces.add(new Space(7,false, null));

    }*/

  }

  public void placePiece(int index, Piece piece)
  {
    this.spaces.get(index).placePiece(piece);
  }

  @Override
  public Iterator<Space> iterator()
  {
    return this.spaces.iterator();
  }

  public void add(Space space)
  {
    this.spaces.add(space);
  }

  public void add(int index, Space space)
  {
    this.spaces.add(index,space);
  }
}