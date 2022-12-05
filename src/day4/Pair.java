package day4;

public class Pair {
	private final String first;
	private final String second;

	public Pair(String first, String second) {
		this.first = first;
		this.second = second;
	}
	
	public Boolean fullyOverlaps() {
		String[] firstNumbers = this.first.split("-");
		String[] secondNumbers = this.second.split("-");
		
		int firstSectionStart = Integer.parseInt(firstNumbers[0]);
		int firstSectionEnd = Integer.parseInt(firstNumbers[1]);
		int secondSectionStart = Integer.parseInt(secondNumbers[0]);
		int secondSectionEnd = Integer.parseInt(secondNumbers[1]);
		
		if (firstSectionStart >= secondSectionStart && firstSectionEnd <= secondSectionEnd) {
			return true;
		}

		return secondSectionStart >= firstSectionStart && secondSectionEnd <= firstSectionEnd;
	}
	
	public Boolean overlapAtAll() {
		String[] firstNumbers = this.first.split("-");
		String[] secondNumbers = this.second.split("-");
		
		int firstSectionStart = Integer.parseInt(firstNumbers[0]);
		int firstSectionEnd = Integer.parseInt(firstNumbers[1]);
		int secondSectionStart = Integer.parseInt(secondNumbers[0]);
		int secondSectionEnd = Integer.parseInt(secondNumbers[1]);
		
		// .....678.
		// ...456... => SecondSection end is between start and end of first section
		// or
		// ...456...
		// .....678. => FirstSection end is between start and end of second section
		// 
		if (firstSectionEnd >= secondSectionStart && firstSectionEnd <= secondSectionEnd) {
			return true;
		}
		return secondSectionEnd >= firstSectionStart && secondSectionEnd <= firstSectionEnd;
	}
}
