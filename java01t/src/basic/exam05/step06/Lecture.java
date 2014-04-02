package basic.exam05.step06;

import java.sql.Date;

public class Lecture {
	String title;
	String teacher;
	Date startDate;
	Date endDate;
	String classroom;
	String manager;
	int hours;
	
	public static Lecture fromCSV(String value) {
		String[] data = value.split(",");
		
		Lecture obj = new Lecture();
		obj.title = data[0];
		obj.teacher = data[1];
		obj.startDate = Date.valueOf(data[2]);
		obj.endDate = Date.valueOf(data[3]);
		obj.classroom = data[4];
		obj.manager = data[5];
		obj.hours = Integer.parseInt(data[6]);
		
		return obj;
	}

	@Override
  public int hashCode() {
	  final int prime = 31;
	  int result = 1;
	  result = prime * result + ((classroom == null) ? 0 : classroom.hashCode());
	  result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
	  result = prime * result + hours;
	  result = prime * result + ((manager == null) ? 0 : manager.hashCode());
	  result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
	  result = prime * result + ((teacher == null) ? 0 : teacher.hashCode());
	  result = prime * result + ((title == null) ? 0 : title.hashCode());
	  return result;
  }

	@Override
  public boolean equals(Object obj) {
	  if (this == obj)
		  return true;
	  if (obj == null)
		  return false;
	  if (getClass() != obj.getClass())
		  return false;
	  Lecture other = (Lecture) obj;
	  if (classroom == null) {
		  if (other.classroom != null)
			  return false;
	  } else if (!classroom.equals(other.classroom))
		  return false;
	  if (endDate == null) {
		  if (other.endDate != null)
			  return false;
	  } else if (!endDate.equals(other.endDate))
		  return false;
	  if (hours != other.hours)
		  return false;
	  if (manager == null) {
		  if (other.manager != null)
			  return false;
	  } else if (!manager.equals(other.manager))
		  return false;
	  if (startDate == null) {
		  if (other.startDate != null)
			  return false;
	  } else if (!startDate.equals(other.startDate))
		  return false;
	  if (teacher == null) {
		  if (other.teacher != null)
			  return false;
	  } else if (!teacher.equals(other.teacher))
		  return false;
	  if (title == null) {
		  if (other.title != null)
			  return false;
	  } else if (!title.equals(other.title))
		  return false;
	  return true;
  }

	@Override
  public String toString() {
	  return title + "," + teacher + ","
	      + startDate.toString() + "," + endDate.toString() + "," 
	  		+ classroom + "," + manager + "," + hours;
  }
	
	
}
