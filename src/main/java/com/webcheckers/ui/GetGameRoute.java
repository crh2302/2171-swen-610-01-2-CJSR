package com.webcheckers.ui;

import com.webcheckers.appl.CheckersCenter;
import com.webcheckers.model.Board;
import spark.*;

import java.util.HashMap;
import java.util.Map;

public class GetGameRoute implements TemplateViewRoute, Route {

  private final CheckersCenter checkersCenter;

  private static final String TITLE_ATTR = "title";
  private static final String PLAYER_NAME_ATTR = "playerName";
  private static final String PLAYER_COLOR_ATTR = "playerColor";
  private static final String IS_MY_TURN_ATTR = "isMyTurn";

  private static final String OPPONENT_NAME_ATTR = "opponentName";
  private static final String OPPONENT_COLOR_ATTR = "opponentColor";

  private static final String CURRENT_PLAYER_ATTR = "currentPlayer";
  private static final String GAME_VIEW = "game.ftl";

  private static final String BOARD_ATTR = "board";


  /**
   * GetGameRoute Constructor.
   *
   * @param checkersCenter holds player information and game data
   */
  public GetGameRoute(CheckersCenter checkersCenter)
  {
    this.checkersCenter = checkersCenter;
  }


  @Override
  public ModelAndView handle(Request request, Response response)
  {

    String title = "welcome";

    //Get Player information
    String playerName = "Player name";
    String playerColor = "Player color";

    //Get Opponents information.
    String opponentsName = "Opponent name  ";
    String opponentsColor = "Opponents Color  ";


    Map<String, Object> vm = new HashMap<>();
    vm.put(TITLE_ATTR,title);
    vm.put(PLAYER_NAME_ATTR,playerName);
    vm.put(PLAYER_COLOR_ATTR,playerColor);

    vm.put(IS_MY_TURN_ATTR,true);
    vm.put(CURRENT_PLAYER_ATTR,true);
    //vm.put("message",true);

    vm.put(OPPONENT_NAME_ATTR,opponentsName);
    vm.put(OPPONENT_COLOR_ATTR,opponentsColor);


    Board boar = new Board();
    vm.put(BOARD_ATTR,boar);
    vm.put("row.index",0);

    return new ModelAndView(vm, GAME_VIEW);
  }
}




