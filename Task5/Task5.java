import java.util.*;

// Main class
public class Task5
{
    private static List<course> courses = new ArrayList<>();
    private static List<student> students = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args)
    {
        
        while (true)
        {
            System.out.println("\nMenu :");
            System.out.println("1. Add course");
            System.out.println("2. Add student");
            System.out.println("3. Show courses");
            System.out.println("4. Show students");
            System.out.println("5. Enroll course");
            System.out.println("6. Drop course");
            System.out.println("7. Exit");
            System.out.print("Choose : ");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option)
            {
                case 1:
                    addCourse();
                    break;
                case 2:
                    addStudent();
                    break;
                case 3:
                    showCourses();
                    break;
                case 4:
                    showStudents();
                    break;
                case 5:
                    enrollCourse();
                    break;
                case 6:
                    dropCourse();
                    break;
                case 7:
                    System.out.println("\nExiting...");
                    return;
                default:
                    System.out.println("\nInvalid option. Try again.");
            }
        }
    }

    private static void showCourses()
    {
        if (courses.isEmpty())
        {
            System.out.println("\nNo courses available.");
        }
        else
        {
            for (course course : courses)
            {
                System.out.println(course);
                List<String> studentIds = course.getStudents();
                if (studentIds.isEmpty())
                {
                     System.out.println("\nNo students enrolled in this course.");
                }
                else
                {
                    System.out.println("Students enrolled : ");
                    for (String studentId : studentIds)
                    {
                        student student = findStudentById(studentId);
                        System.out.println("- " + student.getName() + " (" + student.getId() + ")");
                    }
                }
            System.out.println();
            }
        }
    }

    private static void addStudent()
    {
        System.out.print("Enter student ID : ");
        String id = scanner.nextLine();
        System.out.print("Enter name : ");
        String name = scanner.nextLine();
        students.add(new student(id, name));
        System.out.println("\nStudent added.");
    }

    private static void enrollCourse()
    {
        System.out.print("Enter student ID : ");
        String id = scanner.nextLine();
        student student = findStudentById(id);
        if (student == null)
        {
            System.out.println("\nStudent not found.");
            return;
        }

        System.out.print("Enter course code : ");
        String code = scanner.nextLine();
        course course = findCourseByCode(code);
        if (course == null)
        {
            System.out.println("\nCourse not found.");
            return;
        }

        if (student.enroll(course))
        {
            System.out.println("\nCourse enrolled.");
        }
        else
        {
            System.out.println("\nFailed to enroll. Course might be full.");
        }
    }

    private static void dropCourse()
    {
        System.out.print("Enter student ID : ");
        String id = scanner.nextLine();
        student student = findStudentById(id);
        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        System.out.print("Enter course code : ");
        String code = scanner.nextLine();
        course course = findCourseByCode(code);
        if (course == null)
        {
            System.out.println("\nCourse not found.");
            return;
        }

        if (student.drop(course))
        {
            System.out.println("\nCourse dropped.");
        }
        else
        {
            System.out.println("\nFailed to drop course.");
        }
    }

    private static void addCourse()
    {
        System.out.print("Enter course code : ");
        String code = scanner.nextLine();
        System.out.print("Enter course title : ");
        String title = scanner.nextLine();
        System.out.print("Enter course description : ");
        String desc = scanner.nextLine();
        System.out.print("Enter course capacity : ");
        int cap = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter course schedule : ");
        String sched = scanner.nextLine();

        courses.add(new course(code, title, desc, cap, sched));
        System.out.println("\nCourse added.");
    }

    private static void showStudents()
    {
        if (students.isEmpty())
        {
            System.out.println("\nNo students enrolled.");
        }
        else
        {
            for (student student : students)
            {
                System.out.println(student);
                System.out.println();
            }
        }
    }

    private static student findStudentById(String id)
    {
        for (student student : students)
        {
            if (student.getId().equals(id))
            {
                return student;
            }
        }
        return null;
    }

    private static course findCourseByCode(String code)
    {
        for (course course : courses)
        {
            System.out.println("Checking course code : " + course.getCode());
            if (course.getCode().equals(code))
            {
                return course;
            }
        }
        return null;
    }
}