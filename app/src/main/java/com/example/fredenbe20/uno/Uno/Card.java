package com.example.fredenbe20.uno.Uno;

/**
 * Created by fredenbe20 on 2/25/2018.
 *
 * The card class is an object for an uno card with a specific value,
 * type, and color.
 *
 * @author Stelios Papoutsakis
 * @author Chris Fishback
 * @author Alli Jacobs
 * @author Mason Fredenberg
 */

public class Card {



    //description variables for the card
    private Color color; //1-9: numbers, 10: skip, 11: reverse,
    //12: draw2, 13: wild, 14: wild draw 4
    private Type type;

    public Card(Color color, Type type)
    {
        this.color = color;
        this.type = type;
    }

    //getters

    public Color getColor() {
        return color;
    }

    public Type getType() {
        return type;
    }



}
