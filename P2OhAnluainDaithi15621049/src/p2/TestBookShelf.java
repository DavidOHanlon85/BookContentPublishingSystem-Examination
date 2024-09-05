/**
 * 
 */
package p2;

import java.util.ArrayList;

/**
 * @author - Daithi O hAnluain - 15621049
 */
public class TestBookShelf {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Bookshelf bs = new Bookshelf();
		
		ArrayList<AllBooks> allBooks = new ArrayList<AllBooks>();
		
		AllBooks a1 = new AudioBook("Title1", "Author1", Genre.BIOGRAPHY, "abbababa", 4000, "Nar1", 0);
		AllBooks a2 = new AudioBook("Title2", "Author1", Genre.YA, "cars", 30, "Nar1", 0);
		AllBooks a3 = new AudioBook("Title3", "Author1", Genre.SCIFI, "abbababa", 4000, "Nar1", 0);
		AllBooks a4 = new AudioBook("Title4", "Author1", Genre.SCIFI, "cars", 4000, "Nar1", 0);
		AllBooks a5 = new AudioBook("Title5", "Author1", Genre.BIOGRAPHY, "abbababa", 100, "Nar1", 0);

		allBooks.add(a1);
		allBooks.add(a2);
		allBooks.add(a3);
		allBooks.add(a4);
		allBooks.add(a5);
		
		// Conversion issue
		
		System.out.println("Output details");
		System.out.println("______________");
		bs.outputDetails(allBooks);
		System.out.println();
		
		// Output Summaries
		
		System.out.println("Output summaries");
		System.out.println("______________");
		bs.outputSummaries(allBooks);
		System.out.println();
		
		// Search by Genre
		
		System.out.println("Search by Genre");
		System.out.println("________________");
		ArrayList<AllBooks> searchByGenre = bs.searchByGenre(allBooks, Genre.SCIFI);
		bs.outputDetails(searchByGenre);
		System.out.println();
		
		// Search by Duration
		
		System.out.println("Search by Duration");
		System.out.println("________________");
		ArrayList<AllBooks> searchByDuration = bs.searchByDuration(allBooks, 20, 105);
		bs.outputDetails(searchByDuration);
		System.out.println();
		
		
		// Search by Keyword in Blurb
		
		System.out.println("Search by Keyword in Blurb");
		System.out.println("________________");
		ArrayList<AllBooks> searchByKeyword = bs.searchByKeyword(allBooks, "cars");
		bs.outputDetails(searchByKeyword);
		System.out.println();
		
	}

}
