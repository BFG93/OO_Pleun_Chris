package Assignment2PleunChris;

/**
 * The Gallows class for the hangman game. 
 * The most important functions for the game mechanic are in this class.
 * @author Pleun Scholten s4822250
 */
public class Gallows {
    private static final int MAX_MISTAKES = 10;
    
    private final String word;
    private int mistakes;
    private final StringBuilder guess;
    
    /**
     * Construction function for the Gallow object.
     * Initializes the guess and the number of mistakes. 
     * @param word Correct word
     */
    public Gallows(String word) {
        this.word = word;
        this.guess = new StringBuilder(this.word.length());
        this.mistakes = 0;
        //initializes the guess as dots with the same length of the word.
        for(int i = 0; i<word.length(); i++) {
            this.guess.append(".");
        }
    }
    
    /**
     * Returns the players current guess.
     * @return the players current guess.
     */
    public String getGuess() {
        return this.guess.toString();
    }
    
    /**
     * Returns the correct word. Only used by cheaters.
     * @return the correct word.
     */
    public String getWord() {
        return this.word;
    }
    
    /**
     * Getter function for the number of mistakes.
     * @return number of mistakes.
     */
    public int getMistakes() {
        return MAX_MISTAKES-this.mistakes;
    }
    
    /**
     * Return whether the player has reached the maximum number of mistakes.
     * @return whether the player has reached the maximum number of mistakes.
     */
    public boolean lost() {
        return this.mistakes >= MAX_MISTAKES;
    }
    
    /**
     * Updates the guess of the player according to the guessed character.
     * Returns true if the guess was correct, false otherwise.
     * @param c guessed character
     * @return true if the guess was correct, false otherwise.
     */
    public boolean playerGuess(char c) {
        int found = 0;
        for(int i=0;i<this.word.length();i++) {
            if(this.word.charAt(i) == c) {
                found++;
                this.guess.replace(i, i+1, Character.toString(c)); 
            }
        }
        //Not a character in the word --> mistake
        if(found == 0)
            this.mistakes++;
        return found != 0;
    }
    
    /**
     * Returns whether the player has won, meaning the guess equals the given word.
     * @return whether the player guessed the word.
     */
    public boolean won() {
        return this.guess.toString().equals(this.word);
    }
    
    /**
     * Returns the ASCII art String of a gallows corresponding with the number of mistakes.
     * Only works with MAX_MISTAKES = 10.
     * @return ASCII art of gallows or empty String in case of invalid nr of mistakes.
     */
    public String getGallows() {
        switch(MAX_MISTAKES-this.mistakes) {
            case 9:
                return "========";
            case 8:
                return "/\\\n========";
            case 7: 
                return "|\n/\\\n========";
            case 6: 
                return "|\n|\n|\n/\\\n========";
            case 5: 
                return "|/\n|\n|\n|\n/\\\n========";
            case 4:
                return "=======\n|/\n|\n|\n|\n/\\\n========";
            case 3:
                return "=======\n|/    |\n|\n|\n|\n/\\\n========";
            case 2:
                return "=======\n|/    |\n|    _O_\n|\n|\n/\\\n========";
            case 1:
                return "=======\n|/    |\n|    _O_\n|     |\n|\n/\\\n========";
            case 0: 
                return "=======\n|/    |\n|    _O_\n|     |\n|    / \\\n/\\\n========";
            default:
                return "";
        }
    }
    
}
