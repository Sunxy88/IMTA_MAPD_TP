package xin.xisx.MAPD.TP13.codeGiven;

import java.util.Comparator;
import java.util.List;

public class TestSort {

	public static void main(String[] args) {
		List<Series> coll = DB.getInstance().coll;
		System.out.println(coll);

		// sort series by title
		coll.sort(Comparator.comparing(Series::getTitle));
		System.out.println(coll);

		// sort series by release date
		coll.sort(Comparator.comparing(Series::getYear));
		System.out.println(coll);
	}
}
