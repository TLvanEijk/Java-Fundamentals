

package soccer.play;

import soccer.event.GameEvent;
import soccer.event.Goal;


public class GameResult {
    
 
    private final Team homeTeam;
    private final Team awayTeam;
    private Team winner;
    private int homeTeamGoals;
    private int awayTeamGoals;
    private boolean isDrawn;
    
    
    
 
    public boolean isDrawnGame() {
        return isDrawn;
    } 
    
    // Possibly throw Exception here for game not played or drawn game
    public Team getWinner()  {
        return this.winner;
    }  
    public int getHomeTeamScore(){
        return this.homeTeamGoals;
    }
    public int getAwayTeamScore(){
        return this.awayTeamGoals;
    }
   
   // Constructor 
   public GameResult(Game currGame) {
        this.homeTeam = currGame.getHomeTeam();  // This might change in later version
        this.awayTeam = currGame.getAwayTeam();
        getScore(currGame);       
         if (homeTeamGoals == awayTeamGoals){
            this.isDrawn = true;       
        } else if (homeTeamGoals > awayTeamGoals) {
            this.winner = this.homeTeam;
        } else {
            this.winner = this.awayTeam;
        }

    }
    
    private void getScore(Game currGame) {
       for (GameEvent currEvent: currGame.getEvents()) {
            if (currEvent instanceof Goal) {
                if (currEvent.getTheTeam()==currGame.getHomeTeam()){
                    this.homeTeamGoals++;
                } else {
                    this.awayTeamGoals++;
                }
                // Increment player's goals here? Seems not correct. TODO
                // NOT correct because GameResults get created all over the place.
                //currEvent.getThePlayer().incGoalsScored();
            }
       }
    } 

    /**
     * @return the homeTeam
     */
    public Team getHomeTeam() {
        return homeTeam;
    }

    /**
     * @return the awayTeam
     */
    public Team getAwayTeam() {
        return awayTeam;
    }
 
}
