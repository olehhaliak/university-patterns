import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.*;

@Getter
@Setter
public class Course {

   private String name;
   private Date date;
   private int seminarsNumber;
   private float fee;
   private Professor professor;
   private Map<Student,Enrollment> enrolledStudents = new HashMap<>();

   public Course(String name, Date date,Professor professor, int seminarsNumber, float fee) {
      this.name = name;
      this.date = date;
      this.seminarsNumber = seminarsNumber;
      this.fee = fee;
   }
   public Course(String name, Date date, int seminarsNumber, float fee) {
      this.name = name;
      this.date = date;
      this.seminarsNumber = seminarsNumber;
      this.fee = fee;
   }

   public void addStudent(Student student,Enrollment enrollment){
      enrolledStudents.put(student,enrollment);
   }

   public void removeStudent(Student student ){
       enrolledStudents.remove(student);
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Course course = (Course) o;
      return seminarsNumber == course.seminarsNumber && Float.compare(course.fee, fee) == 0 && Objects.equals(name, course.name) && Objects.equals(date, course.date);
   }

   @Override
   public int hashCode() {
      return Objects.hash(name, date, seminarsNumber, fee);
   }

   @Override
   public String toString() {
      return "Course{" +
              "name='" + name + '\'' +
              ", date=" + date +
              ", seminarsNumber=" + seminarsNumber +
              ", fee=" + fee +
              '}';
   }
}
