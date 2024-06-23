import java.util.*;

// Course class
public class course
{
    private String code;
    private String title;
    private String desc;
    private int cap;
    private String sched;
    private List<String> students;

    public course(String code, String title, String desc, int cap, String sched)
    {
        this.code = code;
        this.title = title;
        this.desc = desc;
        this.cap = cap;
        this.sched = sched;
        this.students = new ArrayList<>();
    }

    public String getCode()
    {
        return code;
    }

    public String getTitle()
    {
        return title;
    }

    public String getDesc()
    {
        return desc;
    }

    public int getCap()
    {
        return cap;
    }

    public String getSched()
    {
        return sched;
    }

    public List<String> getStudents()
    {
        return students;
    }

    public int getAvailableSlots()
    {
        return cap - students.size();
    }

    public boolean addStudent(String studentId)
    {
        if (students.size() < cap)
        {
            students.add(studentId);
            return true;
        }
        return false;
    }

    public boolean removeStudent(String studentId)
    {
        return students.remove(studentId);
    }

    @Override
    public String toString()
    {
        return "Code : " + code + "\nTitle : " + title + "\nDescription : " + desc + "\nCapacity : " + cap + "\nSchedule : " + sched + "\nAvailable Slots : " + getAvailableSlots();
    }
}
