package xin.xisx.MAPD.TP13.codeGiven;

import java.util.List;

class Series {
    private final String title;
    private final int year;
    private final Genre genre;
    private final List<Person> cast;
    private final int nbEpisodes;

    Series(String title, int year, Genre genre, List cast, int nbEpisodes) {
        this.title = title;
        this.year = year;
        this.genre = genre;
        this.cast = cast;
        this.nbEpisodes = nbEpisodes;
    }

    String getTitle() {
        return title;
    }
    int getYear() {
        return year;
    }
    Genre getGenre() {
        return genre;
    }
    List<Person> getCast() { return cast; }
    @Override
    public String toString(){
        return "Series(" + title + ", " + year + ", " + genre + ", " + cast + ", " + nbEpisodes + ")";
    }

}

