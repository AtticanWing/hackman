import java.util.ArrayList;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class Puzzle {
    private String word;
    private int rightGuesses;
    private String guesses;

    public Puzzle(String w) {
        word = w.toUpperCase();
        guesses = "";
    }

    /** Shows the puzzle on the terminal
     *  
     */
    public void show() {
        System.out.print("Puzzle: ");
        for (int i = 0; i < word.length(); i++) {
            if (guesses.contains((word.substring(i, i+1)))) {
                System.out.print((word.substring(i, i+1)) + " ");
            } else {
                System.out.print("_ ");
            }
        }
        System.out.println();
        System.out.println();
        System.out.println("Guesses: " + guesses);
    }

    /** Accessor method for the puzzle word
     *  @return the String word
     */
    public String getWord() {
        return word;
    }

    /** Method that determines whether the puzzle has been solved
     *  @return true if not solved, false if solved
     */
    public boolean isUnsolved() {
        if (rightGuesses == word.length()) {
            return false;
        } else {
            return true;
        }
    }

    /** Method that takes guess and sees if correct
     *  @param guess letter guessed by player
     *  @return true if word contains the letter, false if the word does not
     */
    public boolean makeGuess(String guess) {
        boolean correct = false;
        String sub = (guess.substring(0,1)).toUpperCase();
        guesses += sub + ", ";
        for (int i = 0; i < word.length(); i++) {
            if (word.substring(i, i+1).equals(sub)) {
                correct = true;
                rightGuesses++;
            }
        }
        return correct;
    }
}
