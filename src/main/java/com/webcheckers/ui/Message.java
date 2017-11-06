package com.webcheckers.ui;

/**
 * Class that represents a message that can be sent to the user
 */
public class Message
{

	private String text;
	static final String SELF_PLAY_ERROR_MSG = "Invalid Opponent. You can't play against yourself!";
	static final String INVALID_OPP_MSG = "Entered opponent does not exist.";
	static final String OPPONENT_ERROR_MSG = "Chosen opponent is already in a game. Please choose another.";
	static final String TITLE_ATTR_MSG = "Welcome!";
	static final String TITLE_ATTR = "title";
	static final String ERROR_ATTR_MSG = "Username already taken. Please enter another.";

	public Message(String text)
	{
		this.text = text;
	}

	public String getText()
	{
		return text;
	}

}
