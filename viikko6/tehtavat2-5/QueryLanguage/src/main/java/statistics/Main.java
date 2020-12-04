package statistics;

import statistics.matcher.*;

public class Main {
    public static void main(String[] args) {
        String url = "https://nhlstatisticsforohtu.herokuapp.com/players.txt";

        Statistics stats = new Statistics(new PlayerReaderImpl(url));
        
        Matcher m = new And( new HasAtLeast(5, "goals"),
                             new HasAtLeast(5, "assists"),
                             new PlaysIn("PHI")
        );

        m = new And(new Not( new HasAtLeast(1, "goals") ), 
                            new PlaysIn("NYR")
        );
        for (Player player : stats.matches(m)) {
            System.out.println(player);
        }

        m = new And(new HasFewerThan(1, "goals"), 
                            new PlaysIn("NYR")
        );
        System.out.println("======");
        for (Player player : stats.matches(m)) {
            System.out.println(player);
        }

        System.out.println("======");
        System.out.println(stats.matches(new All()).size());

        m = new Or( new HasAtLeast(40, "goals"),
                    new HasAtLeast(60, "assists")
        );  
        System.out.println("======");
        for (Player player : stats.matches(m)) {
            System.out.println(player);
        }

        m = new And(new HasAtLeast(50, "points"),
                    new Or( new PlaysIn("NYR"),
                            new PlaysIn("NYI"),
                            new PlaysIn("BOS")
                        )
        ); 
        System.out.println("======");
        for (Player player : stats.matches(m)) {
            System.out.println(player);
        }

        System.out.println("== Builder ====");
        
        QueryBuilder query = new QueryBuilder();
        Matcher builtM = query.playsIn("NYR").hasAtLeast(5, "goals").hasFewerThan(10, "goals").build();

        for (Player player : stats.matches(builtM)) {
            System.out.println( player );
        }

        System.out.println("== Or... ====");

        query = new QueryBuilder();
        Matcher m1 = query.playsIn("PHI").hasAtLeast(10, "assists").hasFewerThan(5, "goals").build();
        Matcher m2 = query.playsIn("EDM").hasAtLeast(40, "points").build();
        Matcher builtM2 = query.oneOf(m1, m2).build();
        for (Player player : stats.matches(builtM2)) {
            System.out.println( player );
        }
    }
}
