package com.example.fredenbe20.uno.Uno;

import com.example.fredenbe20.uno.game.infoMsg.GameState;

import java.util.ArrayList;

/**
 * Created by fredenbe20 on 2/25/2018.
 * <p>
 * The UnoGameState class holds all info on the
 * current game state, and houses methods for
 * all options for a players actions.
 *
 * @author Stelios Papoutsakis
 * @author Chris Fishback
 * @author Alli Jacobs
 * @author Mason Fredenberg
 */

public class UnoGameState extends GameState {


    //Different groupings of cards
    private ArrayList<ArrayList<Card>> playerHands;

    //String-based info
    private ArrayList<String> playerNames;


    //number-based info
    private int turn;

    private Color currentColor;
    //game direction
    private boolean gameDirection; //true = clockwise; false = counterclockwise

    //Deck drawpile and discardpile
    private Deck drawPile;

    public Deck getDiscardPile() {
        return discardPile;
    }

    private Deck discardPile;


    /*
    * regular constructor
    */
    public UnoGameState() {
        //filling the drawPile with Cards
        //dealing 7 cards to each player from the top of the deck in
        // traditional fashion

        this.playerHands = new ArrayList<>();

        this.drawPile = new Deck();
        this.discardPile = new Deck();
        this.drawPile.add108();

        //adds two players
        this.playerHands.add(new ArrayList<Card>());
        this.playerHands.add(new ArrayList<Card>());

        for (int i = 0; i < 7; i++) {
            this.playerHands.get(0).add(this.drawPile.take());
            this.playerHands.get(1).add(this.drawPile.take());
        }


        //setting all of the integer-based info
        this.turn = 0;


        //setting game direction clockwise
        this.gameDirection = true;


        //moving the top card from drawPile to discardPile
        this.discardPile.put(drawPile.take());


    }

    /*
    * this constructor is used to make a deep copy of the game state
    */
    public UnoGameState(UnoGameState masterGameState, int playerID) {


        this.playerHands = new ArrayList<>();

        // telling the game state whose turn it is
        this.turn = playerID;

        // copying decks
        this.drawPile = new Deck(masterGameState.getDrawPile());
        this.discardPile = new Deck(masterGameState.getDiscardPile());

        //copying players ahdn
        this.playerHands.add((ArrayList<Card>)(masterGameState.getPlayerHands().get(0).clone());
        this.playerHands.add((ArrayList<Card>)(masterGameState.getPlayerHands().get(1).clone());




        //copying color
        this.currentColor = discardPile.take().getColor();


        //copying gameDirection
        this.gameDirection = masterGameState.gameDirection;


    }

    /*
    * method converts all variables into strings
    */
    @Override
    public String toString() {
        String str = "\n";

        str = "# cards in draw pile: " + drawPile.getDeckSize();
        str += "\n";

        str += "Player1 #cards: " + this.player1NumCards;
        str += "\n";

        str += "Player2 #cards: " + this.player2NumCards;
        str += "\n";

        str += "Player3 #cards: " + this.player3NumCards;
        str += "\n";

        str += "Player4 #cards: " + this.player4NumCards;
        str += "\n";

        str += "current player: " + this.turn;
        str += "\n";
        str += "card Val: ";
        for (Card card : this.currentPlayerHand) {
            str += " " + card.getCardVal();
        }
        str += "\n";

        str += "Top card in discard pile: " + this.topOfDiscard.getCardVal();
        str += "\n";
        str += "Game direction: " + this.gameDirection;
        str += "\n";
        str += "Current color: " + this.color;

        str += "\n";
        str += "\n";
        str += "\n";


        return str;
    }

    /*
    * draws a card from the deck and puts it into the players hand
    * @return true if player can draw a card
    */
    public boolean drawCard(int playerId) {
        //return false if there are no cards to draw from
        if (this.drawPile.getDeckSize() < 1 || playerId != this.turn)
            return false;

        //gets the player and adds a card to his/her hand
        this.currentPlayerHand.add(this.drawPile.take());
        switch (playerId) {
            case 0:
                player1NumCards++;
                break;
            case 1:
                player2NumCards++;
                break;
            case 2:
                player3NumCards++;
                break;
            case 3:
                player4NumCards++;
                break;

        }


        return true;
    }


    /* method places a card onto the discard pile
    * @return true if player can place card
    */
    public boolean placeCard(int playerId, Card toPlace) {

        if (playerId != this.turn || this.currentPlayerHand.size() == 0) return false;

        //gets the player, removes the card,
        //and adds the card to the discard pile
        currentPlayerHand.remove(toPlace);
        discardPile.put(toPlace);
        switch (playerId) {
            case 0:
                player1NumCards--;
                break;
            case 1:
                player2NumCards--;
                break;
            case 2:
                player3NumCards--;
                break;
            case 3:
                player4NumCards--;
                break;

        }


        return true;
    }

    /*
    * method draws a card and moves turn on to the next player
    * @return true if skip turn is possible
    */
    public boolean skipTurn(int playerId) {
        if (playerId != this.turn) return false;

        //draw a card
        drawCard(playerId);

        //skip turn
        this.turn++;

        return true;
    }

    /*
    * method that quits game
    * @return true
    */
    public boolean quit(int playerId) {
        System.exit(0);
        return true;
    }

    /*
    * method that is called to see if player has uno
    * @return true if player has uno, false otherwise
    */
    public boolean hasUno(int playerId) {

        switch (playerId) {
            case 0: //master player
                if (this.player1NumCards == 1) return true;
                return false;
            case 1: //player2
                if (this.player2NumCards == 1) return true;
                return false;
            case 2: //player3
                if (this.player3NumCards == 1) return true;
                return false;
            case 3: //player4
                if (this.player4NumCards == 1) return true;
                return false;
        }

        return false;
    }

    //getters and setters

    public Deck getDrawPile() {
        return this.drawPile;
    }

    public int getTurn() {
        return turn;
    }


    public ArrayList<ArrayList<Card>> getPlayerHands() {
        return playerHands;
    }
}

