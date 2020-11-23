package ohtu;

public class TennisGame {

    private int player1Score = 0;
    private int player2Score = 0;
    private String player1Name;
    private String player2Name;
    private String score;

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(player1Name)) {
            player1Score++;
        } else {
            player2Score++;
        }
    }

    public String scoreToString(int playerScore) {
        String scoreAsString = "";
        switch (playerScore) {
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
                scoreAsString = "Deuce";
                break;
        }
        return scoreAsString;
    }

    public void evenScore() {
        if (player1Score < 4) {
            score = scoreToString(player1Score) + "-All";
        } else {
            score = "Deuce";
        }
    }

    public void scoreIsFourOrOver() {
        int minusResult = player1Score - player2Score;
        if (minusResult == 1)
            score = "Advantage " + player1Name;
        else if (minusResult == -1)
            score = "Advantage " + player2Name;
        else if (minusResult >= 2)
            score = "Win for " + player1Name;
        else
            score = "Win for " + player2Name;
    }

    public void unevenScoreUnderFour() {
        score = scoreToString(player1Score) + "-" + scoreToString(player2Score);
    }

    public String getScore() {
        score = "";
        if (player1Score == player2Score) {
            evenScore();
        } else if (player1Score >= 4 || player2Score >= 4) {
            scoreIsFourOrOver();
        } else {
            unevenScoreUnderFour();
        }
        return score;
    }
}