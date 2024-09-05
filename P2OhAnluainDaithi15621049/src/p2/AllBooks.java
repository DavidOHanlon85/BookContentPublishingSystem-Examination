/**
 * 
 */
package p2;

import java.util.Objects;

/**
 * @author - Daithi O hAnluain - 15621049
 */
public abstract class AllBooks {

	// Constants

	private static final int MIN_TITLE_LENGTH = 3;
	private static final int MAX_TITLE_LENGTH = 30;

	private static final int MIN_AUTHOR_LENGTH = 3;
	private static final int MAX_AUTHOR_LENGTH = 30;

	private static final int MIN_BLURB_LENGTH = 3;
	private static final int MAX_BLURB_LENGTH = 200;

	// Instance Variables

	private String title;
	private String author;
	private Genre genre;
	private String blurb;

	// Constructors

	/**
	 * This is the default constructor for AllBooks
	 */
	public AllBooks() {

	}

	/**
	 * This is the constructor with args for AllBooks
	 * 
	 * @param title
	 * @param author
	 * @param genre
	 * @param blurb
	 * @throws IllegalArgumentException
	 */
	public AllBooks(String title, String author, Genre genre, String blurb) throws IllegalArgumentException {
		this.setTitle(title);
		this.setAuthor(author);
		this.setGenre(genre);
		this.setBlurb(blurb);
	}

	// Getters and Setters

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets title according to business rule range between 3 - 30 inclusive
	 * 
	 * @param title
	 * @throws IllegalArgumentException with appropriate messages if null of title
	 *                                  invalid
	 */
	public void setTitle(String title) throws IllegalArgumentException {
		if (title == null) {
			throw new IllegalArgumentException("TITLE IS NULL");
		} else if (title.length() >= MIN_TITLE_LENGTH && title.length() <= MAX_TITLE_LENGTH) {
			this.title = title;
		} else {
			throw new IllegalArgumentException("TITLE IS INVALID");
		}

	}

	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * Sets title according to business rule range between 3 - 30 inclusive
	 * 
	 * @param author
	 * @throws IllegalArgumentException with appropriate messages if null of title
	 *                                  invalid
	 */
	public void setAuthor(String author) throws IllegalArgumentException {
		String allowed = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ . -";
		
		// loop needed

		if (author == null) {
			throw new IllegalArgumentException("AUTHOR IS NULL");
		} else if (author.length() >= MIN_AUTHOR_LENGTH && author.length() <= MAX_AUTHOR_LENGTH) {
			this.author = author;
		} else {
			throw new IllegalArgumentException("AUTHOR IS INVALID");
		}
	}

	/**
	 * @return the genre
	 */
	public Genre getGenre() {
		return genre;
	}

	/**
	 * Gets genre 
	 * @param genre
	 * @throws IllegalArgumentException if genre is null
	 */
	public void setGenre(Genre genre)throws IllegalArgumentException {
		if (genre == null) {
			throw new IllegalArgumentException("GENRE IS NULL");
		} else {
			this.genre = genre;
		}
		
	}

	/**
	 * @return the blurb
	 */
	public String getBlurb() {
		return blurb;
	}

	/**
	 * Sets blurb according to business rule range between 3 - 200 inclusive
	 * @param blurb
	 * @throws IllegalArgumentException
	 */
	public void setBlurb(String blurb)throws IllegalArgumentException {
		if (blurb == null) {
			throw new IllegalArgumentException("BLURB IS NULL");
		} else if (blurb.length() >= MIN_BLURB_LENGTH && blurb.length() <= MAX_BLURB_LENGTH) {
			this.blurb = blurb;
		} else {
			throw new IllegalArgumentException("BLURB IS INVALID");
		}
			
	}
	
	// Methods
	
	public abstract String progress();
	
	/**
	 * This method displays of the book details to the console
	 */
	public void displayDetails(){
		
		System.out.println("Title       \t: " + getTitle());
		System.out.println("By          \t: " + getAuthor());
		System.out.println("Genre       \t: " + getGenre());
	} 
	
	// hashCode and equals

	@Override
	public int hashCode() {
		return Objects.hash(author, blurb, genre, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AllBooks other = (AllBooks) obj;
		return Objects.equals(author, other.author) && Objects.equals(blurb, other.blurb) && genre == other.genre
				&& Objects.equals(title, other.title);
	}
	
	
	
	

}
