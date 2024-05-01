package outbreak;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class Tests {

	@Test
	void verticalCorrect() {
		assertTrue(isOutbreak(verticalTrue, "verticalTrue"));
	}

	@Test
	void horizontalCorrect() {
		assertTrue(isOutbreak(horizontalTrue, "horizontalTrue"));
	}

	@Test
	void mixedCorrect() {
		assertTrue(isOutbreak(mixedTrue1, "mixedTrue1"));
	}

	@Test
	void mixedCorrect2() {
		assertTrue(isOutbreak(mixedTrue2, "mixedTrue2"));
	}

	@Test
	void mixedIncorrect() {
		assertFalse(isOutbreak(mixedFalse1, "mixedFalse"));
	}

	@Test
	void mixedIncorrect2() {
		assertFalse(isOutbreak(mixedFalse2, "mixedFalse"));
	}

	// Method to be Tested
	public static boolean isOutbreak(Room[][] floor, String testMethod) {

		// Look for all infected rooms
		for (int rowIndex = 0; rowIndex < floor.length; rowIndex++) {
			for (int columnIndex = 0; columnIndex < floor[rowIndex].length; columnIndex++) {
				if (floor[rowIndex][columnIndex].isInfected) {
					//Check how many of the connected rooms are infected recursively
					int numOfConnectedRooms = checkConnectedRooms(floor, rowIndex, columnIndex);
					if (numOfConnectedRooms >= 5) {
						return true;
					}
				}
			}
		}
		return false;
	}

	// Recursively Checks for Connected Infected Rooms
	public static int checkConnectedRooms(Room[][] floor, int rowIndex, int columnIndex) {
		Room room = floor[rowIndex][columnIndex];
		int foundConnections = 0;

		//Return 0 if anything is out of bounds
		if (rowIndex < 0 || rowIndex > floor.length - 1 || columnIndex < 0
				|| columnIndex > floor[rowIndex].length - 1) {
			return 0;

		} else if (!room.visited && room.isInfected) {

			//If room hasn't been visited yet, and checked room is infected, increment number of connections
			foundConnections++;
			//Make sure room isn't checked a second time
			room.visited = true;

			//Check all surrounding rooms, and add up number of rooms that are infected
			if (rowIndex > 0) {
				foundConnections += checkConnectedRooms(floor, rowIndex - 1, columnIndex);
			}
			if (rowIndex < floor.length - 1) {
				foundConnections += checkConnectedRooms(floor, rowIndex + 1, columnIndex);
			}
			if (columnIndex > 0) {
				foundConnections += checkConnectedRooms(floor, rowIndex, columnIndex - 1);
			}
			if (columnIndex < floor[rowIndex].length - 1) {
				foundConnections += checkConnectedRooms(floor, rowIndex, columnIndex + 1);
			}

			return foundConnections;
		}
		return foundConnections;
	}

	// Test Data
	Room[][] verticalTrue = new Room[][] {
			{ new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false),
					new Room(false), new Room(false), new Room(false) },
			{ new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false),
					new Room(false), new Room(false), new Room(false) },
			{ new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false),
					new Room(false), new Room(false), new Room(false) },
			{ new Room(false), new Room(true), new Room(false), new Room(true), new Room(true), new Room(false),
					new Room(false), new Room(false), new Room(false) },
			{ new Room(false), new Room(true), new Room(false), new Room(false), new Room(false), new Room(false),
					new Room(false), new Room(false), new Room(false) },
			{ new Room(false), new Room(true), new Room(false), new Room(false), new Room(false), new Room(false),
					new Room(false), new Room(false), new Room(false) },
			{ new Room(false), new Room(true), new Room(false), new Room(false), new Room(false), new Room(false),
					new Room(false), new Room(false), new Room(false) },
			{ new Room(false), new Room(true), new Room(false), new Room(false), new Room(false), new Room(false),
					new Room(false), new Room(false), new Room(false) },
			{ new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false),
					new Room(false), new Room(false), new Room(false) },
			{ new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false),
					new Room(false), new Room(false), new Room(false) } };

	Room[][] horizontalTrue = new Room[][] {
			{ new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false),
					new Room(false), new Room(false), new Room(false) },
			{ new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false),
					new Room(false), new Room(false), new Room(false) },
			{ new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false),
					new Room(false), new Room(false), new Room(false) },
			{ new Room(false), new Room(true), new Room(true), new Room(true), new Room(true), new Room(true),
					new Room(false), new Room(false), new Room(false) },
			{ new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false),
					new Room(false), new Room(false), new Room(false) },
			{ new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false),
					new Room(false), new Room(false), new Room(false) },
			{ new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false),
					new Room(false), new Room(false), new Room(false) },
			{ new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false),
					new Room(false), new Room(false), new Room(false) },
			{ new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false),
					new Room(false), new Room(false), new Room(false) },
			{ new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false),
					new Room(false), new Room(false), new Room(false) } };

	Room[][] mixedTrue1 = new Room[][] {
			{ new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false),
					new Room(false), new Room(false), new Room(false) },
			{ new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false),
					new Room(false), new Room(false), new Room(false) },
			{ new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false),
					new Room(false), new Room(false), new Room(false) },
			{ new Room(false), new Room(true), new Room(true), new Room(false), new Room(false), new Room(false),
					new Room(false), new Room(false), new Room(false) },
			{ new Room(false), new Room(true), new Room(true), new Room(true), new Room(false), new Room(false),
					new Room(false), new Room(false), new Room(false) },
			{ new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false),
					new Room(false), new Room(false), new Room(false) },
			{ new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false),
					new Room(false), new Room(false), new Room(false) },
			{ new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false),
					new Room(false), new Room(false), new Room(false) },
			{ new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false),
					new Room(false), new Room(false), new Room(false) },
			{ new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false),
					new Room(false), new Room(false), new Room(false) } };

	Room[][] mixedTrue2 = new Room[][] {
			{ new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false),
					new Room(false), new Room(false), new Room(false) },
			{ new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false),
					new Room(false), new Room(false), new Room(false) },
			{ new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false),
					new Room(false), new Room(false), new Room(false) },
			{ new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false),
					new Room(false), new Room(false), new Room(false) },
			{ new Room(false), new Room(false), new Room(true), new Room(true), new Room(false), new Room(false),
					new Room(false), new Room(false), new Room(false) },
			{ new Room(false), new Room(false), new Room(false), new Room(true), new Room(false), new Room(false),
					new Room(false), new Room(false), new Room(false) },
			{ new Room(false), new Room(false), new Room(false), new Room(true), new Room(true), new Room(false),
					new Room(false), new Room(false), new Room(false) },
			{ new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false),
					new Room(false), new Room(false), new Room(false) },
			{ new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false),
					new Room(false), new Room(false), new Room(false) },
			{ new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false),
					new Room(false), new Room(false), new Room(false) } };

	Room[][] mixedFalse1 = new Room[][] {
			{ new Room(true), new Room(false), new Room(true), new Room(false), new Room(false), new Room(false),
					new Room(false), new Room(false), new Room(false) },
			{ new Room(false), new Room(true), new Room(false), new Room(true), new Room(false), new Room(false),
					new Room(false), new Room(false), new Room(false) },
			{ new Room(true), new Room(false), new Room(true), new Room(false), new Room(false), new Room(false),
					new Room(false), new Room(false), new Room(false) },
			{ new Room(false), new Room(true), new Room(false), new Room(true), new Room(false), new Room(true),
					new Room(false), new Room(false), new Room(false) },
			{ new Room(false), new Room(true), new Room(false), new Room(false), new Room(true), new Room(false),
					new Room(false), new Room(false), new Room(false) },
			{ new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(true),
					new Room(false), new Room(false), new Room(false) },
			{ new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false),
					new Room(true), new Room(false), new Room(false) },
			{ new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false),
					new Room(false), new Room(false), new Room(false) },
			{ new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false),
					new Room(false), new Room(false), new Room(false) },
			{ new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false),
					new Room(false), new Room(false), new Room(false) } };

	Room[][] mixedFalse2 = new Room[][] {
			{ new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false),
					new Room(false), new Room(false), new Room(false) },
			{ new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false),
					new Room(false), new Room(false), new Room(false) },
			{ new Room(false), new Room(false), new Room(true), new Room(false), new Room(false), new Room(true),
					new Room(false), new Room(false), new Room(false) },
			{ new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(true),
					new Room(false), new Room(false), new Room(false) },
			{ new Room(true), new Room(false), new Room(false), new Room(false), new Room(false), new Room(true),
					new Room(false), new Room(false), new Room(false) },
			{ new Room(false), new Room(false), new Room(true), new Room(false), new Room(false), new Room(false),
					new Room(false), new Room(false), new Room(false) },
			{ new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false),
					new Room(false), new Room(false), new Room(true) },
			{ new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false),
					new Room(false), new Room(false), new Room(false) },
			{ new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false),
					new Room(false), new Room(false), new Room(false) },
			{ new Room(true), new Room(true), new Room(true), new Room(true), new Room(false), new Room(false),
					new Room(false), new Room(false), new Room(false) } };

}
