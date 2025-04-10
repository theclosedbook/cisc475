package problem2;

public class Course {

	private String code; // e.g., "CISC"

	private int number; // e.g., 475

	private String name; // e.g. "Software Engineering"

	public Course() {
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getNumber() {
		return number;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public String toString() {
		return code + number + ": " + name;
	}
}


