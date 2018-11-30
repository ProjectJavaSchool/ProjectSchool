package com.company;

/*public class Command {

    enum Manage {
        ManageStudents(1), ManageLecturers(2), Exit(3);

        private int value;

        private Manage(int value) {
            this.value = value;
        }
    }

    enum Student {
        Add(1), View(2), Search(3), Delete(4), Update(5), Back(6);

        private int value;

        private Student(int value) {
            this.value = value;
        }
    }

    enum Lecturer {
        Add(1), View(2), Search(3), Delete(4), Update(5), Back(6);

        private int value;

        private Lecturer(int value) {
            this.value = value;
        }
    }
}*/

public class Command {
    public static final String ManageStudents = "Manage Students";
    public static final String ManageLecturers = "Manage Lecturers";
    public static final String Exit = "Exit";

    public static final String AddStudent = "Add new student";
    public static final String ViewStudent = "View all students";
    public static final String SearchStudent = "Search students";
    public static final String DeleteStudent = "Delete students";
    public static final String UpdateStudent = "Update student";
    public static final String Back = "Back to main menu";

    public static final String AddLecturer = "Add new lecturer";
    public static final String ViewLecturer = "View all lecturers";
    public static final String SearchLecturer = "Search lecturers";
    public static final String DeleteLecturer = "Delete lecturers";
    public static final String UpdateLecturer = "Update lecturer";


}
