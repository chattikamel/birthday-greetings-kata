package it.xpug.kata.birthday_greetings;

import static org.junit.Assert.*;

import org.junit.*;



public class BirthDateTest {
	@Test
	public void getters() throws Exception {
		BirthDate date = new BirthDate("1789/01/24");
		assertEquals(1, date.getMonth());
		assertEquals(24, date.getDay());
	}

	@Test
	public void isSameDate() throws Exception {
		BirthDate date = new BirthDate("1789/01/24");
		BirthDate sameDay = new BirthDate("2001/01/24");
		BirthDate notSameDay = new BirthDate("1789/01/25");
		BirthDate notSameMonth = new BirthDate("1789/02/25");

		assertTrue("same", date.isSameDay(sameDay));
		assertFalse("not same day", date.isSameDay(notSameDay));
		assertFalse("not same month", date.isSameDay(notSameMonth));
	}

	@Test
	public void equality() throws Exception {
		BirthDate base = new BirthDate("2000/01/02");
		BirthDate same = new BirthDate("2000/01/02");
		BirthDate different = new BirthDate("2000/01/04");

		assertFalse(base.equals(null));
		assertFalse(base.equals(""));
		assertTrue(base.equals(base));
		assertTrue(base.equals(same));
		assertFalse(base.equals(different));
	}

}
