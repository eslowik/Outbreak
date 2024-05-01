# Outbreak
Project based on recursion

# Instructions
1. Given the following class:

```java
	public class Room {           
		public final boolean isInfected; 
		public boolean visited = false;
		Room(boolean infected) {
			isInfected = infected;
		}
	}
	
	public static boolean isOutbreak(Room[][] floor) {
		//Your logic here
	}
```

Fill in the logic for the isOutbreak() method. This method should return true if 5 or more connected rooms are infected, false otherwise. Connected rooms are defined as rooms that share a wall, e.g. diagonal rooms are not connected.


<details>

  <summary>Example Test Data</summary>

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


</details>
