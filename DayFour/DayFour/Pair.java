package DayFour;

public class Pair {
	private String first;
	private String second;

	public Pair(String first, String second) {
		this.first = first;
		this.second = second;
	}
	
	public Boolean fullyOverlaps() {
		String[] firstNumbers = this.first.split("-");
		String[] secondNumbers = this.second.split("-");
		
		Integer firstSectionStart = Integer.valueOf(firstNumbers[0]);
		Integer firstSectionEnd = Integer.valueOf(firstNumbers[1]);
		Integer secondSectionStart = Integer.valueOf(secondNumbers[0]);
		Integer secondSectionEnd = Integer.valueOf(secondNumbers[1]);
		
		if (firstSectionStart >= secondSectionStart && firstSectionEnd <= secondSectionEnd) {
			return true;
		}
		
		if (secondSectionStart >= firstSectionStart && secondSectionEnd <= firstSectionEnd) {
			return true;
		}
		return false;
	}
	
	public Boolean overlapAtAll() {
		String[] firstNumbers = this.first.split("-");
		String[] secondNumbers = this.second.split("-");
		
		Integer firstSectionStart = Integer.valueOf(firstNumbers[0]);
		Integer firstSectionEnd = Integer.valueOf(firstNumbers[1]);
		Integer secondSectionStart = Integer.valueOf(secondNumbers[0]);
		Integer secondSectionEnd = Integer.valueOf(secondNumbers[1]);
		
		// .....678.
		// ...456... => SecondSection end is between start and end of first section
		// or
		// ...456...
		// .....678. => FirstSection end is between start and end of section section
		// 
		if (firstSectionEnd >= secondSectionStart && firstSectionEnd <= secondSectionEnd) {
			System.out.println("1. True => " + firstSectionEnd + " >= " + secondSectionStart + " && " + firstSectionEnd + " <= " + secondSectionEnd);
			return true;
		}
		if (secondSectionEnd >= firstSectionStart && secondSectionEnd <= firstSectionEnd) {
			System.out.println("2. True => " + secondSectionEnd + " >= " + firstSectionStart + " && " + secondSectionEnd + " <= " + firstSectionEnd);
			return true;
		}
		
		return false;
	}
}
