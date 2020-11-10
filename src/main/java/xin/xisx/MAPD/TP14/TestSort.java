package xin.xisx.MAPD.TP14;

import xin.xisx.MAPD.TP13.codeGiven.*;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.Collectors.*;

/**
 * TP14
 */
public class TestSort {

	public static void main(String[] args) {
		List<Series> coll = DB.getInstance().coll;
		System.out.println(coll);

		exercice4(coll);
		exercice51(coll);
		exercice52(coll);

	}

	private static void exercice4(List<Series> coll) {
		Stream<Series> stream = coll.stream();
		List<String> titles = stream
				.filter(s -> s.getYear() <= 2000)
				.sorted(Comparator.comparing(Series::getYear))
				.map(series -> series.getTitle())
				.distinct()
				.collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
		System.out.println(titles);
	}

	private static void exercice51(List<Series> coll) {
		Map<Genre, List<Series>> oldiesByGenre;
		oldiesByGenre = coll.stream().filter(s -> s.getYear() <= 2000)
				.collect(Collectors.groupingBy(Series::getGenre));
		System.out.println(oldiesByGenre);
	}

	private static void exercice52(List<Series> coll) {
		Map<Boolean, List<Person>> partition = coll.stream()
				.flatMap(s -> s.getCast().stream())
				.collect(Collectors.partitioningBy(p -> {
					Citizenship cz = p.getCitizenship();
					return cz == Citizenship.US || cz == Citizenship.AU || cz == Citizenship.UK || cz == Citizenship.CA;
				}));
		System.out.println(partition);
	}
}
