package problem2;

import java.io.PrintStream;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Term {

	private String name; // e.g. "Spring"

	private int year; // e.g. 2025

	private Set<CourseOffering> courses = new HashSet<CourseOffering>();

	public Term(String name, int year) {
		this.name = name;
		this.year = year;
	}

	public boolean addCourse(CourseOffering course) {
		return courses.add(course);
	}

	public boolean hasCourse(Course course) {
		return courses.contains(course);
	}

	public String toString() {
		return name + " " + year;
	}

	public void print(PrintStream out) {
		out.println(this + ":");
		for (CourseOffering c : courses)
			out.println("  " + c);
	}

	public Collection<CourseOffering> getCoursesWithCode(String code) {
		List<CourseOffering> result = new LinkedList<CourseOffering>();
		for (CourseOffering c : courses)
			if (code.equals(c.getCode()))
				result.add(c);
		return result;
	}

}
