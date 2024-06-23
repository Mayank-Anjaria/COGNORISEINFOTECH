import java.util.*;

// Student class
public class student
{
    private String id;
    private String name;
    private List<course> courses;

    public student(String id, String name)
    {
        this.id = id;
        this.name = name;
        this.courses = new ArrayList<>();
    }

    public String getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public List<course> getCourses()
    {
        return courses;
    }

    public boolean enroll(course course)
    {
        if (course.addStudent(this.id))
        {
            courses.add(course);
            return true;
        }
        return false;
    }

    public boolean drop(course course)
    {
        if (course.removeStudent(this.id))
        {
            courses.remove(course);
            return true;
        }
        return false;
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder("\nID : " + id + "\nName : " + name + "\nCourses :\n");
        for (course course : courses)
        {
            sb.append(course.getCode()).append(" - ").append(course.getTitle()).append("\n");
        }
        return sb.toString();
    }
}