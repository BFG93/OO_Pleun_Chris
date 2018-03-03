package oo_assignment4pleunchris;

/**
 * Main running method of the game.
 *
 * View: Input/output of the game. Both shows the user the relevant state of the
 * game and takes input to let the user manipulate the state of the game. Model:
 * The board, the human player and the computer player. Controller: The main
 * game loop: how are all the parts connected, how does the user input from the
 * user influence the game?
 *
 * It's sort of like this, but TA's told us not to get hung up on it, so we'll
 * just do what seems logical, and try to separate the different kinds of logic
 * (Game logic/IO/controller logic etc.).
 *
 * @author Pleun Scholten s4822250
 * @author Christian Lammers s4578236
 */
public class OO_Assignment4PleunChris {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.run();

    }
}
