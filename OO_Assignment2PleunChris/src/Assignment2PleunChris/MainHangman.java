package Assignment2PleunChris;

/**
 *
 * @author Pleun Scholten s4822250
 * @author Christian Lammers s...
 */
public class MainHangman {

    private static final String FILE_NAME = "src/Assignment2PleunChris/words.txt";
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Console console = new Console();
        String word = getInputWord(console);        
        Gallows gallow = new Gallows(word);
        console.println(gallow.getGuess());
        playerGuessing(console, gallow);
    }
    
    /**
     * Returns either a user inputted String or a random word if the input is empty.
     * @param console
     * @return either a user inputted String or a random word if the input is empty.
     */
    private static String getInputWord(Console console) {
        console.println("Hey Whaddup, plz enter your word to be guessed. A random word is chosen if the field is left empty.");
        String word = console.getNextLine().toLowerCase();
        //Bug fixes that would break the game.
        //Remove all non-letters.
        word = word.replaceAll("[^A-Za-z ]", "");
        //Remove spaces at the beginning of a word.
        while(word.length()>0 && word.charAt(0)==' ') {
//            if(word.length()==0)
//                word = "";
//            else
                word = word.substring(1);
        }
        //Only take the first word in a sentence.
        if(word.contains(" ")) {
            String[] words = word.split(" "); 
            word = words[0];
            console.println("Only the first word of the sentence is taken.");
        }
        //Random word if no (valid) iput is given. 
        if(word.length()==0) {
            WordReader reader = new WordReader(FILE_NAME);
            word = reader.getWord();
        }
        return word;
    }

    /**
     * The main game loop for the hangman game.
     * Allows the player to guess and gives feedback to the user about their guess.
     * @param console
     * @param gallows 
     */
    private static void playerGuessing(Console console, Gallows gallows) {
        boolean endGame = false;
        while(!endGame) {
            console.println("Please guess.");
            char letter = getNextInput(console);
            console.println("");
            
            if(letter != '*') {
                if (!gallows.playerGuess(letter)) 
                    console.println(gallows.getGallows());
            }
            else
                console.println("Invalid input. Please try again. (I am a forgiving gallow-god)");
            
            console.println(gallows.getGuess()+"\n");
            
            //Plz forgive my too long stories. I got a little carried away. ^^
            if(gallows.won()) {
                endGame = true;
                console.println("Crows screech in the distance... \nThe smell of death is all around you.\nAs you look to the left, the noose around your neck, you look right into the eyes of the executioner."
                        + "\n'Is there anyone who objects?' he yells to the small crowd.\n'Yes, for the love of God, yes, I object!' There you see... no, is that?...\n"
                        + "\nYour long lost lover, standing in the crowd. Your lover pays the bail and you are released from the gallows.\nTogether, you walk off. Into the sunset, where life will be good.");
            }
            if(gallows.lost()) {
                endGame = true;
                console.println("Crows screech in the distance... \nThe smell of death is all around you.\nAs you look to the left, the noose around your neck, you look right into the eyes of the executioner."
                        + "\nHe looks back, no sign of remorse.\nHis hand moves from his waste to the lever.\n'You should've guessed '" + gallows.getWord() + "', fool.'"
                                + "\nYou close your eyes, pray one last time, and then....\n\nSilence. Forever.");
            }
        }
    }
    
    /**
     * Returns the character given by the user.
     * If either a too long string is input or non-letter characters, the function gives and error message and returns the '*' character.
     * @param console
     * @return Either a letter if correct input is given or '*' if incorrect input is given.
     */
    private static char getNextInput(Console console) {
        String input = console.getNextLine().toLowerCase();
        if(input.length()!=1 || input.matches("[^A-Za-z]")) 
            return '*';
        else 
            return input.charAt(0); //Return first (and only) character 
    }
}
