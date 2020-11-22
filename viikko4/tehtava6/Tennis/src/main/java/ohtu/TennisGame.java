package ohtu;

public class TennisGame {
    
    private String namePlayer1;
    private int scorePlayer1;
    
    private String namePlayer2;
    private int scorePlayer2;
    
    public TennisGame(String namePlayer1, String namePlayer2) {
        this.namePlayer1 = namePlayer1;
        this.namePlayer2 = namePlayer2;
        this.scorePlayer1 = 0;
        this.scorePlayer2 = 0;
    }

    public void wonPoint(String playerName) {
        if (playerName == namePlayer1)
            scorePlayer1 += 1;
        else if (playerName == namePlayer2) {
            scorePlayer2 += 1;
        }
    }

    public String getScore() {
        if (scorePlayer1 == scorePlayer2) {
            return situationEven(scorePlayer1, scorePlayer2);
        } else if (scorePlayer1 >= 4 || scorePlayer2 >= 4) {
            return situationAdvantageOrWin(scorePlayer1, scorePlayer2);  
        } else {
            return situationUndecided(scorePlayer1, scorePlayer2);
        }
    }

    private String situationEven(int scorePlayer1, int scorePlayer) {
        switch (scorePlayer1) {
                case 0:
                    return "Love-All";
                case 1:
                    return "Fifteen-All";
                case 2:
                    return "Thirty-All";
                case 3:
                    return "Forty-All";
                default:
                    return "Deuce";
            }
    }

    private String situationAdvantageOrWin(int scorePlayer1, int scorePlayer2) {
        int marginal = scorePlayer1 - scorePlayer2;
        
        if (marginal > 0) {
            if (marginal >= 2) {
                return "Win for player1";
            } else {
                return "Advantage player1";
            }
        }

        if (marginal < 0) {
            if (marginal <= -2) {
                return "Win for player2";
            } else {
                return "Advantage player2";
            }
        }

        return null;

    }

    private String situationUndecided(int scorePlayer1, int scorePlayer2) {
        String score = "";
        
        switch(scorePlayer1) {
            case 0:
                score+="Love";
                break;
            case 1:
                score+="Fifteen";
                break;
            case 2:
                score+="Thirty";
                break;
            case 3:
                score+="Forty";
                break;
        }
        
        score += "-";

        switch(scorePlayer2) {
            case 0:
                score+="Love";
                break;
            case 1:
                score+="Fifteen";
                break;
            case 2:
                score+="Thirty";
                break;
            case 3:
                score+="Forty";
                break;
        }

        return score;
    }
}