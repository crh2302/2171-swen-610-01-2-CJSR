package com.webcheckers.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Row implements Iterable<Space>
{
  private int index = 0;
  private List<Space> spaces;

  /**
   * Constructor for Row
   *
   * @param index
   */
  public Row(int index)
  {
    this.index = index;
    spaces = new ArrayList<Space>();
    for (int i = 0; i <= 7; i++)
    {
      if (index == 0 && i % 2 == 1)
      {
        spaces.add(new Space(i, true, new Piece("SINGLE", "WHITE")));
      } else if (index == 1 && i % 2 == 0)
      {
        spaces.add(new Space(i, true, new Piece("SINGLE", "WHITE")));
      } else if (index == 2 && i % 2 == 1)
      {
        spaces.add(new Space(i, true, new Piece("SINGLE", "WHITE")));
      } else if (index == 3 && i % 2 == 0)
      {
        spaces.add(new Space(i, true, null));

      } else if (index == 4 && i % 2 == 1)
      {
        spaces.add(new Space(i, true, null));

      } else if (index == 6 && i % 2 == 1)
      {
        spaces.add(new Space(i, true, new Piece("SINGLE", "RED")));
      } else if (index == 7 && i % 2 == 0)
      {
        spaces.add(new Space(i, true, new Piece("SINGLE", "RED")));
      } else if (index == 5 && i % 2 == 0)
      {
        spaces.add(new Space(i, true, new Piece("SINGLE", "RED")));
      } else
      {
        spaces.add(new Space(i, false, null));
      }
    }
  }

  public List<Space> getSpaces()
  {
    return spaces;
  }

  @Override
  public Iterator<Space> iterator()
  {
    return spaces.iterator();
  }

  @Override
  public int hashCode()
  {
    return spaces.hashCode();
  }

  public int getIndex()
  {
    return index;
  }

}
