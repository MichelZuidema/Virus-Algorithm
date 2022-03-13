public class MoveDetails {
    private VirusMove move;
    private int score;

    public MoveDetails(VirusMove move, int score) {
        this.move = move;
        this.score = score;
    }

    public VirusMove getMove() {
        return move;
    }

    public int getScore() {
        return score;
    }


}
