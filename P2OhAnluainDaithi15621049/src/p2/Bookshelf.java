/**
 * 
 */
package p2;

import java.util.ArrayList;

/**
 * @author - Daithi O hAnluain - 15621049
 */
public class Bookshelf {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

	/**
	 * This method displays all details of the books in the AL to the console.
	 * 
	 * @param allBooks
	 * @throws IllegalArgumentException thrown with appropriate message if AL is
	 *                                  null or empty
	 */
	public static void outputDetails(ArrayList<AllBooks> allBooks) throws IllegalArgumentException {

		if (allBooks.size() == 0 || allBooks == null) {
			throw new IllegalArgumentException("AL NULL OR EMPTY");
		}

		System.out.println("______________");
		System.out.println("Book Details");
		System.out.println("______________");

		for (AllBooks a : allBooks) {
			if (a instanceof AudioBook) {
				AudioBook ab = (AudioBook) a;
				ab.displayDetails();
				System.out.println();
			}
		}

	}

	/**
	 * This method displays all summaries of the books in the AL to the console.
	 * 
	 * @param allBooks
	 * @throws IllegalArgumentException thrown with appropriate message if AL is
	 *                                  null or empty
	 */
	public static void outputSummaries(ArrayList<AllBooks> allBooks) throws IllegalArgumentException {

		if (allBooks.size() == 0 || allBooks == null) {
			throw new IllegalArgumentException("AL NULL OR EMPTY");
		}

		System.out.println("______________");
		System.out.println("Book Summaries");
		System.out.println("______________");

		for (AllBooks a : allBooks) {
			if (a instanceof AudioBook) {
				AudioBook ab = (AudioBook) a;
				ab.displaySummary();
				System.out.println();
			}
		}

	}

	/**
	 * This searches an input AL list by genre and returns an AL of those books
	 * which matched the genre
	 * 
	 * @param allBooks
	 * @throws IllegalArgumentException thrown with appropriate message if AL is
	 *                                  null or empty or in Genre is null
	 */
	public static ArrayList<AllBooks> searchByGenre(ArrayList<AllBooks> allBooks, Genre genre)
			throws IllegalArgumentException {

		ArrayList<AllBooks> resultsByGenre = new ArrayList<AllBooks>();

		if (allBooks.size() == 0 || allBooks == null) {
			throw new IllegalArgumentException("AL NULL OR EMPTY");
		}

		if (genre == null) {
			throw new IllegalArgumentException("GENRE IS NULL");
		}

		for (AllBooks a : allBooks) {
			if (a.getGenre() == genre) {
				resultsByGenre.add(a);
			}
		}

		return resultsByGenre;
	}

	/**
	 * This searches an input AL list by duration and returns an AL of those books
	 * which matched the duration range (inclusive)
	 * 
	 * @param allBooks
	 * @throws IllegalArgumentException thrown with appropriate message if AL is
	 *                                  null or empty or if minDuration > maxDuration
	 */
	public static ArrayList<AllBooks> searchByDuration(ArrayList<AllBooks> allBooks, int minDuration, int maxDuration)
			throws IllegalArgumentException {

		ArrayList<AllBooks> resultsByDuration = new ArrayList<AllBooks>();

		if (allBooks.size() == 0 || allBooks == null) {
			throw new IllegalArgumentException("AL NULL OR EMPTY");
		}

		if (minDuration > maxDuration) {
			throw new IllegalArgumentException("INPUT ERROR");
		}

		for (AllBooks a : allBooks) {
			if (a instanceof AudioBook) {
				AudioBook ab = (AudioBook) a;
				if (ab.getDuration() >= minDuration && ab.getDuration() <= maxDuration) {
					resultsByDuration.add(a);
				}
			}
		}

		return resultsByDuration;
	}

	/**
	 * This searches an input AL list by keyword and returns an AL of those books
	 * which matched the keyword - the search is case insensitive
	 * 
	 * @param allBooks
	 * @throws IllegalArgumentException thrown with appropriate message if AL is
	 *                                  null or empty or in keyword is null
	 */
	public static ArrayList<AllBooks> searchByKeyword(ArrayList<AllBooks> allBooks, String keyword)
			throws IllegalArgumentException {

		ArrayList<AllBooks> resultsByKeyword = new ArrayList<AllBooks>();

		if (allBooks.size() == 0 || allBooks == null) {
			throw new IllegalArgumentException("AL NULL OR EMPTY");
		}

		if (keyword == null) {
			throw new IllegalArgumentException("KEYWORD IS NULL");
		}
		
		keyword = keyword.toUpperCase();

		for (AllBooks a : allBooks) {
			if (a.getBlurb().toUpperCase().contains(keyword)){
				resultsByKeyword.add(a);
			}
		}

		return resultsByKeyword;
	}

}
