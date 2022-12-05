package day3;

public class Rucksack {

	private final String firstCompartment;
	private final String secondCompartment;
	
	private static final String UPPERCASE = "ZXCVBNMASDFGHJKLQWERTYUIOP";

	public Rucksack(String firstCompartment, String secondCompartment) {
		this.firstCompartment = firstCompartment;
		this.secondCompartment = secondCompartment;
	}
	
	public char getCommon() {
		for (int i = 0;i < this.firstCompartment.length(); i++){
			if (this.secondCompartment.indexOf(this.firstCompartment.charAt(i)) != -1) {
				return this.firstCompartment.charAt(i);
			}
		}
		return 0;
	}
	
	public int getValue() {
		char common = this.getCommon();
		int ascii = (int) common;
		if (Rucksack.UPPERCASE.indexOf(common) != -1) {
			// Uppercase
			ascii = ascii - 64 + 26;
		} else {
			// Lowercase
			ascii -= 96;
		}
		
		return ascii;
	}
}
