package outbreak;

public class Room {
	public final boolean isInfected;
	public boolean visited = false;

	Room(boolean infected) {
		isInfected = infected;
	}
}
