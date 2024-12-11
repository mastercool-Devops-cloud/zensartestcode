package Java8Program;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class College {
	private String collegeName;
	private List<String> collegeLocations;

	public College() {
	}

	public College(String collegeName, List<String> collegeLocations) {
		super();
		this.collegeName = collegeName;
		this.collegeLocations = collegeLocations;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	public List<String> getCollegeLocations() {
		return collegeLocations;
	}

	public void setCollegeLocations(List<String> collegeLocations) {
		this.collegeLocations = collegeLocations;
	}
}
public class MapVSFlatmapExample {
	public static void main(String[] args) {
		 List<College> collegeList = new ArrayList<>();
		 collegeList.add(new College("IIM", Arrays.asList("Bangalore", "Ahmedabad", "Kozhikode", "Lucknow")));
		 collegeList.add(new College("IIT", Arrays.asList("Delhi", "Mumbai", "Kharagpur")));
		 collegeList.add(new College("NIFT", Arrays.asList("Hyderabad", "Mumbai", "Patna", "Bangalore")));
	 
		 List<String> op1 = collegeList.stream().map(x->x.getCollegeName()).collect(Collectors.toList());
		 System.out.println(op1);
		 List<String> op2 = collegeList.stream().flatMap(x->x.getCollegeLocations().stream()).collect(Collectors.toList());
		 System.out.println(op2);
	}

}
