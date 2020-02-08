package ohtu;

public class TennisGame {
    public final int GAME_LENGTH = 4;
    private int player1Score = 0;
    private int player2Score = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(player1Name))
            player1Score += 1;
        else if (playerName.equals(player2Name))
            player2Score += 1;
    }
    
    public String getScore() {
        String score = "";
        if (player1Score >= GAME_LENGTH || player2Score >= GAME_LENGTH) {
            score = adsOrWinnerToString(player1Score, player2Score);
        }
        else if (player1Score == player2Score) {
            score = scoreToString(player1Score) + "-All";
        }
        else {
            score = scoreToString(player1Score) + "-" + scoreToString(player2Score);
        }
        return score;
    }
    
    private String scoreToString(int score) {
        String scoreAsString;
        switch (score)
            {
                case 0:
                        scoreAsString = "Love";
                    break;
                case 1:
                        scoreAsString = "Fifteen";
                    break;
                case 2:
                        scoreAsString = "Thirty";
                    break;
                case 3:
                        scoreAsString = "Forty";
                    break;
                default:
                        scoreAsString = "";
                    break;
                
            }
        return scoreAsString;
    }
     
    private String adsOrWinnerToString(int score1, int score2) {
        String scoreAsString;
        int minusResult = score1 - score2;
        if (minusResult == 1) scoreAsString ="Advantage player1";
        else if (minusResult == -1) scoreAsString ="Advantage player2";
        else if (minusResult >= 2) scoreAsString = "Win for player1";
        else if (minusResult <= -2) scoreAsString = "Win for player2";
        else scoreAsString = "Deuce";
        return scoreAsString;
    }
}