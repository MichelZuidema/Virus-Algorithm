import java.util.ArrayList;

public class MichelsAlgorithm implements VirusStrategy {
    @Override
    public VirusMove doMove(Player currentPlayer, Player[][] playingField, ArrayList<VirusMove> moveList,
            int FieldSize) {

        ArrayList<MoveDetails> moveDetails = new ArrayList<MoveDetails>();

        for (VirusMove m : moveList) {
            // Set default score
            int score = 0;

            // Simulate move
            int fromX = (int) m.from.getX();
            int fromY = (int) m.from.getY();
            int toX = (int) m.to.getX();
            int toY = (int) m.to.getY();
            if (Math.abs(fromX - toX) > 1 || Math.abs(fromY - toY) > 1) {
                playingField[fromX][fromY] = Player.EMPTY;
            }

            // Loop over field, see if there are any enemies, if so, take the positions
            for(int i = toX - 1; i <= toX + 1; i++) {
                for(int j = toY - 1; j <= toY + 1; j++) {
                    if(j >= 0 && i >= 0 && j < FieldSize && i < FieldSize && playingField[i][j] != Player.EMPTY) {
                        score++;
                    }
                }
            }

            // Add move to list
            moveDetails.add(new MoveDetails(m, score));
        }

        // Return best move
        return getBestMove(moveDetails);
    }

    private VirusMove getBestMove(ArrayList<MoveDetails> moveDetails) {
        MoveDetails bestMove = moveDetails.get(0);

        for(MoveDetails md : moveDetails) {
            if(md.getScore() > bestMove.getScore()) {
                bestMove = md;
            }
        }

        return bestMove.getMove();
    }

    @Override
    public String getName() {
        return "MichelsAlgorithm";
    }

}
