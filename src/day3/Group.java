package day3;

public class Group {
	private final String first;
	private final String second;
	private final String third;
	
	private static final String UPPERCASE = "ZXCVBNMASDFGHJKLQWERTYUIOP";

	public Group(String first, String second, String third) {
		this.first = first;
		this.second = second;
		this.third = third;
	}
	
	public char getCommon()	{
		for (int i = 0;i < this.first.length(); i++){
			char firstChar = this.first.charAt(i);
			if (this.second.indexOf(firstChar) != -1 
				&& this.third.indexOf(firstChar) != -1
			) {
				return this.first.charAt(i);
			}
		}
		return 0;		
	}
	
	public int getValue() {
		char common = this.getCommon();
		int ascii = (int) common;
		if (Group.UPPERCASE.indexOf(common) != -1) {
			// Uppercase
			ascii = ascii - 64 + 26;
		} else {
			// Lowercase
			ascii -= 96;
		}
		
		return ascii;
	}
}
