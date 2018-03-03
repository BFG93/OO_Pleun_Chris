package oo_assignment4pleunchris;

/**
 * 
 * @author Pleun Scholten s4822250
 * @author Christian Lammers s4578236
 */
public interface Player {
    Move play(Board board);
    void setTeam(Field team);
    Field getTeam();
    void setName(String name);
    String getName();
}
