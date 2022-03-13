public class Main {

    public static void main(String[] args) {
        // VirusGame game = new VirusGame(7);
        // game.virusSingleGame(new RandomVirusStrategy(), new MichelsAlgorithm());

        playCertainAmountOfTimes(100, new RandomVirusStrategy(), new MichelsAlgorithm());
    }

    private static void playCertainAmountOfTimes(int times, VirusStrategy greenPlayer, VirusStrategy redPlayer) {
        int wins = 0;
        int losses = 0;
        for (int i = 0; i < times; i++) {
            VirusGame game = new VirusGame(7);
            Player winner = game.virusSingleGame(greenPlayer, redPlayer);

            if (winner.equals(Player.RED)) {
                wins++;
            } else {
                losses++;
            }
        }

        if (wins > losses) {
            System.out.println("Winner: " + redPlayer.getName());
        } else {
            System.out.println("Winner: " + greenPlayer.getName());
        }

        System.out.println("Wins: " + wins + ", Losses: " + losses + ", Winrate: "
                + String.valueOf((double) wins / (double) times * 100) + "%");
    }
}
