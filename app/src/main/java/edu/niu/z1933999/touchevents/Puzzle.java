package edu.niu.z1933999.touchevents;

import java.util.Random;

public class Puzzle
{
    public static final int NUMBER_PARTS = 5;
    String [] parts;
    Random random = new Random();

    public Puzzle()
    {
        parts = new String[NUMBER_PARTS];
        parts[0] = "I ";
        parts[1] = "LOVE";
        parts[2] = "MOBILE";
        parts[3] = "ANDROID";
        parts[4] = "PROGRAMMING";
    }

    public boolean solved(String [] solution)
    {
        if (solution != null && solution.length == parts.length)
        {
            for (int i = 0; i < parts.length; i++)
            {
                if (!solution[i].equals(parts[i]))
                    return false;
            }
            return true;
        }
        else
            return false;
    }

    public String [] scramble()
    {
        String [] scrambled = new String[parts.length];
        for (int i = 0; i < scrambled.length; i++)
            scrambled[i] = parts[i];

        while (solved(scrambled))
        {
            for (int i = 0; i < scrambled.length; i++)
            {
                int n = random.nextInt(scrambled.length - i) + i;
                String temp = scrambled[i];
                scrambled[i] = scrambled[n];
                scrambled[n] = temp;
            }
        }
        return scrambled;
    }

    public int getNumberOfParts()
    {
        return parts.length;
    }

    public String wordToChange()
    {
        return "MOBILE";
    }

    public String replacementWord()
    {
        return "ANDROID";
    }
}