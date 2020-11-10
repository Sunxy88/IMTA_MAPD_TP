package xin.xisx.MAPD.TP13.codeGiven;

import java.util.*;
import static java.util.Arrays.asList;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

import static java.util.stream.Collectors.groupingBy;

public class DB {
	private static DB db = null;
    public static List<Series> coll;

    private DB() {
        Person sb = new Person("Scott", "Bakula", Citizenship.US);
        Person wh = new Person("William", "Hartnell", Citizenship.UK);
        Person sm = new Person("Steve", "McQueen", Citizenship.US);
        Person rt = new Person("Roy", "Thinnes", Citizenship.US);
        Person jw = new Person("Jodie", "Whittaker", Citizenship.UK);
        Person tf = new Person("Travis", "Fimmel", Citizenship.AU);
        Person kw = new Person("Katheryn", "Winnick", Citizenship.CA);
        Person gs = new Person("Gustaf", "Skarsgard", Citizenship.SE);

        coll = new ArrayList<>();
        coll.add(new Series("Wanted Dead or Alive", 1958, Genre.WESTERN, asList(sm),94));
        coll.add(new Series("The Twilight Zone", 1959, Genre.SCIFI, asList(), 156));
        coll.add(new Series("The Twilight Zone", 1985, Genre.SCIFI, asList(), 65));
        coll.add(new Series("The Twilight Zone", 2002, Genre.SCIFI, asList(), 43));
        coll.add(new Series("The Twilight Zone", 2019, Genre.SCIFI, asList(), 0));
        coll.add(new Series("The Invaders", 1967, Genre.SCIFI, Arrays.asList(rt), 43));
        coll.add(new Series("The Invaders", 1995, Genre.SCIFI, Arrays.asList(sb, rt), 2));
        coll.add(new Series("Dr Who", 1963, Genre.SCIFI, asList(wh), 134));
        coll.add(new Series("Dr Who", 2018, Genre.SCIFI, asList(jw), 11));
        coll.add(new Series("Deadwood", 2004, Genre.WESTERN, asList(), 36));
        coll.add(new Series("Game of Thrones", 2011, Genre.FANTASY, asList(), 73));
        coll.add(new Series("Vikings", 2011, Genre.HISTORY, asList(tf, kw), 69));
    }

    public static DB getInstance() {
        if (db == null) {
            db = new DB();
        }
        return db;
    }
}

