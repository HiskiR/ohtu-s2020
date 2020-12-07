package statistics;

import statistics.matcher.*;

public class Main {

    public static void main(String[] args) {
        Statistics stats = new Statistics(new PlayerReaderImpl("https://nhlstatisticsforohtu.herokuapp.com/players.txt"));

        QueryBuilder query = new QueryBuilder();

        Matcher m = query.oneOf(
                query.playsIn("PHI")
                        .hasAtLeast(10, "assists")
                        .hasFewerThan(5, "goals").build(),
                query.playsIn("EDM")
                        .hasAtLeast(40, "points").build()
        ).build();

        for (Player player : stats.matches(m)) {
            System.out.println(player);
        }
    }
}
