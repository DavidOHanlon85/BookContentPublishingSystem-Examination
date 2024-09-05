/**
 * 
 */
package p2;

/**
 * @author - Daithi O hAnluain - 15621049
 */
public class AudioBook extends AllBooks {

	// Constants

	private static final int MIN_DURATION_LENGTH = 1;
	private static final int MAX_DURATION_LENGTH = 36000;

	private static final int MIN_NARRATOR_LENGTH = 3;
	private static final int MAX_NARRATOR_LENGTH = 30;

	// Instance Variables

	private int duration;
	private String narrator;
	private int currentpos;

	/**
	 * Default constructor for audio book
	 */
	public AudioBook() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor with args for audioBook
	 * 
	 * @param title
	 * @param author
	 * @param genre
	 * @param blurb
	 * @param duration
	 * @param narrator
	 * @param currentpos
	 * @throws IllegalArgumentException
	 */
	public AudioBook(String title, String author, Genre genre, String blurb, int duration, String narrator,
			int currentpos) throws IllegalArgumentException {
		super(title, author, genre, blurb);
		this.setCurrentpos(currentpos);
		this.setNarrator(narrator);
		this.setDuration(duration);
	}

	// Getters and setters

	/**
	 * @return the duration
	 */
	public int getDuration() {
		return duration;
	}

	/**
	 * @param duration the duration to set
	 */
	public void setDuration(int duration) throws IllegalArgumentException {
		if (duration >= MIN_DURATION_LENGTH && duration <= MAX_DURATION_LENGTH) {
			if (duration >= getCurrentpos()) {
				this.duration = duration;
			}
		} else {
			throw new IllegalArgumentException("DURATION IS INVALID");
		}

	}

	/**
	 * @return the narrator
	 */
	public String getNarrator() {
		return narrator;
	}

	/**
	 * Sets narrator name if length is between 3 and 30 inclusive
	 * 
	 * @param narrator
	 * @throws IllegalArgumentException and appropriate message if null or invalid
	 */
	public void setNarrator(String narrator) throws IllegalArgumentException {
		if (narrator == null) {
			throw new IllegalArgumentException("NARRATOR IS NULL");
		} else if (narrator.length() >= MIN_NARRATOR_LENGTH && narrator.length() <= MAX_NARRATOR_LENGTH) {
			this.narrator = narrator;
		} else {
			throw new IllegalArgumentException("NARRATOR IS INVALID");
		}

	}

	/**
	 * @return the currentpos
	 */
	public int getCurrentpos() {
		return currentpos;
	}

	/**
	 * @param currentpos the currentpos to set
	 */
	public void setCurrentpos(int currentpos) {
		if (currentpos < duration) {
			this.currentpos = getDuration();
		} else {
			this.currentpos = 0;
		}
	}

	/**
	 * This method display all details to console
	 */
	@Override
	public void displayDetails() {
		super.displayDetails();
		System.out.println("Narrated By \t: " + getNarrator());
		System.out.println("By          \t: " + getAuthor());
		System.out.println("Genre       \t: " + getGenre().getDescription());
		System.out.println("Duration    \t: " + getDuration());
		System.out.println("Progress    \t: ");
		System.out.println("Remaining   \t: " + (getDuration() - getCurrentpos()));
		
		
//		System.out.println("Duration    \t: " + convertToHoursMinsandSecs(getDuration()));
//		System.out.println("Progress    \t: " + progress());
//		System.out.println("Remaining   \t: " + (convertToHoursMinsandSecs(getDuration() - getCurrentpos())));
	}

	
	/** 
	 * This method calculates progress and returns it in a formatted string
	 * 
	 */
	@Override
	public String progress() {

		String timeLeft;

		int hours = (getDuration() - getCurrentpos()) / 60 / 60;
		int minutes = (getDuration() - getCurrentpos()) / 60 - 60;
		int seconds = (getDuration() - getCurrentpos()) - (hours * 60 * 60) - (minutes * 60);

		int percentageProgress = getCurrentpos() / getDuration() * 100;

		timeLeft = String.format("%s hours, %s min, %s secs (%s%)", hours, minutes, seconds, percentageProgress);

		return timeLeft;

	}
	
	/**
	 * A method to convert time left to hours, minutes and seconds
	 * @param duration
	 * @return
	 */

	public String convertToHoursMinsandSecs(int duration) {

		String timeLeft;

		int hours = duration / 60 / 60;
		int minutes = duration / 60 - 60;
		int seconds = duration - (hours * 60 * 60) - (minutes * 60);

		timeLeft = String.format("%s hours, %s min, %s secs (%d%)", hours, minutes, seconds);

		return timeLeft;

	}
	
	/**
	 * A method to display a summary of the book to console
	 */
	public void displaySummary() {
		System.out.println(getTitle() + "(" + getAuthor() + ")");
		System.out.println(getBlurb());
	}

}
