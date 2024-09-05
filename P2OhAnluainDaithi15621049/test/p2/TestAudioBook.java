package p2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestAudioBook {

	// Test data

	String validTitleAuthorNarLow, validTitleAuthorNarMid, validTitleAuthorNarHigh;
	String invalidTitleAuthorNarLow, invalidTitleAuthorNarHigh;

	Genre biography;
	Genre scifi;
	Genre ya;
	Genre childrens;

	String validBlurbLow, validBlurbMid, validBlurbHigh;
	String invalidBlurbLow, invalidBlurbHigh;

	int validDurationLow, validDurationMid, validDurationHigh;
	int invalidDurationLow, invalidDurationHigh;

	AudioBook a;

	@BeforeEach
	void setUp() throws Exception {

		a = new AudioBook();

		validTitleAuthorNarLow = "A".repeat(3);
		validTitleAuthorNarMid = "A".repeat(15);
		validTitleAuthorNarHigh = "A".repeat(30);

		invalidTitleAuthorNarLow = "A".repeat(2);
		invalidTitleAuthorNarHigh = "A".repeat(31);

		biography = Genre.BIOGRAPHY;
		scifi = Genre.SCIFI;
		ya = Genre.YA;
		childrens = Genre.CHILDRENS;

		validBlurbLow = "A".repeat(3);
		validBlurbMid = "A".repeat(100);
		validBlurbHigh = "A".repeat(200);

		invalidBlurbLow = "A".repeat(2);
		invalidBlurbHigh = "A".repeat(301);

		validDurationLow = 1;
		validDurationMid = 18000;
		validDurationHigh = 36000;

		invalidDurationLow = 0;
		invalidDurationHigh = 36001;

		a = new AudioBook(validTitleAuthorNarHigh, validTitleAuthorNarHigh, biography, validBlurbHigh,
				validDurationHigh, validTitleAuthorNarHigh, 0);

	}

	@Test
	void testAudioBookConstuctorNoArgs() {
		assertNotNull(a);
		assertEquals(validTitleAuthorNarHigh, a.getAuthor());
		assertEquals(validTitleAuthorNarHigh, a.getTitle());
		assertEquals(Genre.BIOGRAPHY, a.getGenre());
		assertEquals(validBlurbHigh, a.getBlurb());
		assertEquals(validTitleAuthorNarHigh, a.getNarrator());

	}

	@Test
	void testAudioBookConstructorWithArgsValid() {
		Exception exp = assertThrows(IllegalArgumentException.class, () -> {
			AudioBook a = new AudioBook(invalidTitleAuthorNarHigh, validTitleAuthorNarHigh, biography, validBlurbHigh,
					validDurationHigh, validTitleAuthorNarHigh, 0);
		});
		
		assertEquals("TITLE IS INVALID", exp.getMessage());
		
		exp = assertThrows(IllegalArgumentException.class, () -> {
			AudioBook a = new AudioBook(null, validTitleAuthorNarHigh, biography, validBlurbHigh,
					validDurationHigh, validTitleAuthorNarHigh, 0);
		});
		
		assertEquals("TITLE IS NULL", exp.getMessage());
		
		exp = assertThrows(IllegalArgumentException.class, () -> {
			AudioBook a = new AudioBook(validTitleAuthorNarHigh, invalidTitleAuthorNarHigh, biography, validBlurbHigh,
					validDurationHigh, validTitleAuthorNarHigh, 0);
		});
		
		assertEquals("AUTHOR IS INVALID", exp.getMessage());
		
		exp = assertThrows(IllegalArgumentException.class, () -> {
			AudioBook a = new AudioBook(validTitleAuthorNarHigh, null, biography, validBlurbHigh,
					validDurationHigh, validTitleAuthorNarHigh, 0);
		});
		
		assertEquals("AUTHOR IS NULL", exp.getMessage());
		
		exp = assertThrows(IllegalArgumentException.class, () -> {
			AudioBook a = new AudioBook(validTitleAuthorNarHigh, validTitleAuthorNarHigh, null, validBlurbHigh,
					validDurationHigh, validTitleAuthorNarHigh, 0);
		});
		
		assertEquals("GENRE IS NULL", exp.getMessage());
		
		exp = assertThrows(IllegalArgumentException.class, () -> {
			AudioBook a = new AudioBook(validTitleAuthorNarHigh, validTitleAuthorNarHigh, biography, invalidBlurbHigh,
					validDurationHigh, validTitleAuthorNarHigh, 0);
		});
		
		assertEquals("BLURB IS INVALID", exp.getMessage());
		
		exp = assertThrows(IllegalArgumentException.class, () -> {
			AudioBook a = new AudioBook(validTitleAuthorNarHigh, validTitleAuthorNarHigh, biography, null,
					validDurationHigh, validTitleAuthorNarHigh, 0);
		});
		
		assertEquals("BLURB IS NULL", exp.getMessage());
		
		exp = assertThrows(IllegalArgumentException.class, () -> {
			AudioBook a = new AudioBook(validTitleAuthorNarHigh, validTitleAuthorNarHigh, biography, validBlurbHigh,
					invalidDurationHigh, validTitleAuthorNarHigh, 0);
		});
		
		assertEquals("DURATION IS INVALID", exp.getMessage());
		
		exp = assertThrows(IllegalArgumentException.class, () -> {
			AudioBook a = new AudioBook(validTitleAuthorNarHigh, validTitleAuthorNarHigh, biography, validBlurbHigh,
					validDurationHigh, invalidTitleAuthorNarHigh, 0);
		});
		
		assertEquals("NARRATOR IS INVALID", exp.getMessage());
		
	
	}

	@Test
	void testSetGetDurationValid() {
		a.setDuration(validDurationLow);
		assertEquals(validDurationLow, a.getDuration());
		
		a.setDuration(validDurationMid);
		assertEquals(validDurationMid, a.getDuration());
		
		a.setDuration(validDurationHigh);
		assertEquals(validDurationHigh, a.getDuration());
		
	}
	
	@Test
	void testSetGetDurationInvalid() {
		Exception exp = assertThrows(IllegalArgumentException.class, () -> {
			a.setDuration(invalidDurationLow);
		});
		
		assertEquals("DURATION IS INVALID", exp.getMessage());
		
		exp = assertThrows(IllegalArgumentException.class, () -> {
			a.setDuration(invalidDurationHigh);
		});
		
		assertEquals("DURATION IS INVALID", exp.getMessage());
		
	}
	
	@Test
	void testSetGetNarratorValid() {
		a.setNarrator(validTitleAuthorNarHigh);
		assertEquals(validTitleAuthorNarHigh, a.getNarrator());
		
		a.setNarrator(validTitleAuthorNarMid);
		assertEquals(validTitleAuthorNarMid, a.getNarrator());
		
		a.setNarrator(validTitleAuthorNarLow);
		assertEquals(validTitleAuthorNarLow, a.getNarrator());
	
	}
	
	@Test
	void testSetGetNarratorInvalid() {
		Exception exp = assertThrows(IllegalArgumentException.class, () -> {
			a.setNarrator(invalidTitleAuthorNarHigh);
		});
		
		assertEquals("NARRATOR IS INVALID", exp.getMessage());
		
		exp = assertThrows(IllegalArgumentException.class, () -> {
			a.setNarrator(invalidTitleAuthorNarLow);
		});
		
		assertEquals("NARRATOR IS INVALID", exp.getMessage());
		
		exp = assertThrows(IllegalArgumentException.class, () -> {
			a.setNarrator(null);
		});
		
		assertEquals("NARRATOR IS NULL", exp.getMessage());
	
	}

	@Test
	void testGetSetTitleValid() {
		a.setTitle(validTitleAuthorNarHigh);
		assertEquals(validTitleAuthorNarHigh, a.getTitle());
		
		a.setTitle(validTitleAuthorNarMid);
		assertEquals(validTitleAuthorNarMid, a.getTitle());
		
		a.setTitle(validTitleAuthorNarLow);
		assertEquals(validTitleAuthorNarLow, a.getTitle());
	}
	
	@Test
	void testGetSetTitleInvalid() {
		Exception exp = assertThrows(IllegalArgumentException.class, () -> {
			a.setTitle(invalidTitleAuthorNarHigh);
		});
		
		assertEquals("TITLE IS INVALID", exp.getMessage());
		
		exp = assertThrows(IllegalArgumentException.class, () -> {
			a.setTitle(invalidTitleAuthorNarLow);
		});
		
		assertEquals("TITLE IS INVALID", exp.getMessage());
		
		exp = assertThrows(IllegalArgumentException.class, () -> {
			AudioBook a = new AudioBook(null, validTitleAuthorNarHigh, biography, validBlurbHigh,
					validDurationHigh, validTitleAuthorNarHigh, 0);
		});
		
		assertEquals("TITLE IS NULL", exp.getMessage());
	}
	
	@Test
	void testGetSetAuthorValid() {
		a.setAuthor(validTitleAuthorNarHigh);
		assertEquals(validTitleAuthorNarHigh, a.getAuthor());
		
		a.setAuthor(validTitleAuthorNarMid);
		assertEquals(validTitleAuthorNarMid, a.getAuthor());
		
		a.setAuthor(validTitleAuthorNarLow);
		assertEquals(validTitleAuthorNarLow, a.getAuthor());
	}
	
	@Test
	void testGetSetAuthorInvalid() {
		
		Exception exp = assertThrows(IllegalArgumentException.class, () -> {
			a.setAuthor(invalidTitleAuthorNarHigh);
		});
		
		assertEquals("AUTHOR IS INVALID", exp.getMessage());
		
		exp = assertThrows(IllegalArgumentException.class, () -> {
			a.setAuthor(invalidTitleAuthorNarLow);
		});
		
		assertEquals("AUTHOR IS INVALID", exp.getMessage());
		
		exp = assertThrows(IllegalArgumentException.class, () -> {
			a.setAuthor(null);
		});
		
		assertEquals("AUTHOR IS NULL", exp.getMessage());
		
	}

	@Test
	void testSetGenreValid() {
		a.setGenre(biography);
		assertEquals(Genre.BIOGRAPHY, a.getGenre());
		
		a.setGenre(childrens);
		assertEquals(Genre.CHILDRENS, a.getGenre());
		
		a.setGenre(scifi);
		assertEquals(Genre.SCIFI, a.getGenre());
		
		a.setGenre(ya);
		assertEquals(Genre.YA, a.getGenre());
	}
	
	@Test
	void testSetGenreInvalid() {
		Exception exp = assertThrows(IllegalArgumentException.class, () -> {
			a.setGenre(null);
		});
		
		assertEquals("GENRE IS NULL", exp.getMessage());
	}

	@Test
	void testSetBlurbValid() {
		a.setBlurb(validBlurbLow);
		assertEquals(validBlurbLow, a.getBlurb());
		
		a.setBlurb(validBlurbMid);
		assertEquals(validBlurbMid, a.getBlurb());
		
		a.setBlurb(validBlurbHigh);
		assertEquals(validBlurbHigh, a.getBlurb());
	}
	
	@Test
	void testSetBlurbInvalid() {
		Exception exp = assertThrows(IllegalArgumentException.class, () -> {
			a.setBlurb(invalidBlurbLow);
		});
		
		assertEquals("BLURB IS INVALID", exp.getMessage());
		
		exp = assertThrows(IllegalArgumentException.class, () -> {
			a.setBlurb(invalidBlurbHigh);
		});
		
		assertEquals("BLURB IS INVALID", exp.getMessage());
		
		exp = assertThrows(IllegalArgumentException.class, () -> {
			a.setBlurb(null);
		});
		
		assertEquals("BLURB IS NULL", exp.getMessage());
	}

}
