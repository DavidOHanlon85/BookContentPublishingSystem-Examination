/**
 * 
 */
package p2;

/**
 * @author - Daithi O hAnluain - 15621049
 */
public enum Genre {
	
	BIOGRAPHY("BIOGRAPHY - Biography/Autobiography"), SCIFI("SCIFI - Science Fiction and Fantasy"), YA("YA _ Young Adult Fiction"), CHILDRENS("CHILDRENS _ For Younger Readers");

	private String description;

	/**
	 * @param description
	 */
	private Genre(String description) {
		this.description = description;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	
	
	
	
	
	
	
}
