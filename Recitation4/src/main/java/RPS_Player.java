import java.util.Random;

public class RPS_Player {
    private int numberOfGamesWon;
    private int numberOfGamesPlayed;
    private int choice;
    private String name;

    public RPS_Player(String name){
        this.name = name;
        numberOfGamesWon = 0;
        numberOfGamesPlayed = 0;
        choice = -1;
    }

    public String getName(){
        return name;
    }

    /**
     * Returns the number of games played since a clear() was issued.
     * @return returns the number of games played.
     */
    public int getNumberOfGamesPlayed(){
        return numberOfGamesPlayed;
    }

    /**
     * Returns the number of games won since a clear() was issued.
     * @return returns the number of games won.
     */
    public int getNumberOfGamesWon(){
        return numberOfGamesWon;
    }

    /**
     * Returns the win percentage as number between 0 and 1.
     * @return win percentage as a double.
     */
    public double getWinPercentage(){
        if (numberOfGamesPlayed == 0) return 0;
        return (double) numberOfGamesWon / numberOfGamesPlayed;    }

    /**
     * Starts a new game.
     */
    public void clear(){
        numberOfGamesWon = 0;
        numberOfGamesPlayed = 0;
        choice = -1;    }

    /**
     * This player challenges anotherPlayer whereby both players make a
     * random choice of rock, paper, scissors.  A reference to the winning
     * player is returned or null if there is a draw.
     * @param anotherPlayer an RPS_Player that this player is challenging.
     * @return Reference to the RPS_Player that won or a null if there is a draw
     */
    public RPS_Player challenge(RPS_Player anotherPlayer){
        int result = (choice - anotherPlayer.choice + 3) % 3;
        numberOfGamesPlayed++;
        anotherPlayer.numberOfGamesPlayed++;
        if (result == 0) return null;
        if (result == 1) {
            numberOfGamesWon++;
            return this;
        }
        else {
            anotherPlayer.numberOfGamesWon++;
            return anotherPlayer;
        }    }

    /**
     * This player challenges anotherPlayer whereby this player uses the previous
     * choice made and anotherPlayer makes a random choice of rock, paper, scissors.
     * A reference to the winning player is returned or null if there is a draw.
     * @param anotherPlayer an RPS_Player that this player is challenging.
     * @return Reference to the RPS_Player that won or a null if there is a draw
     */
    public RPS_Player keepAndChallenge(RPS_Player anotherPlayer){
        Random rand = new Random();
        choice = rand.nextInt(3);
        return challenge(anotherPlayer);
    }

}
