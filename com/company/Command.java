package com.company;

public class Command {
    public static final String SEPERATOR = "===================================";
    public static final String COLUMN_SEPERATOR = " | ";
    public static final String MANAGE_STUDENTS = "1. Manage Students";
    public static final String MANAGE_LECTURERS = "2. Manage Lecturers";
    public static final String EXIT = "3. Exit";

    public static final String ADD_NEW_STUDENT = "1. Add new student";
    public static final String VIEW_ALL_STUDENTS = "2. View all students";
    public static final String SEARCH_STUDENTS = "3. Search students";
    public static final String DELETE_STUDENTS = "4. Delete students";
    public static final String UPDATE_STUDENT = "5. Update student";
    public static final String BACK_TO_MAIN_MENU = "6. Back to main menu";

    public static final String ADD_NEW_LECTURER = "1. Add new lecturer";
    public static final String VIEW_ALL_LECTURERS = "2. View all lecturers";
    public static final String SEARCH_LECTURERS = "3. Search lecturers";
    public static final String DELETE_LECTURERS = "4. Delete lecturers";
    public static final String UPDATE_LECTURER = "5. Update lecturer";

    public static final String EMPTY = "";

    public static final String NOT_VALID_NUMBER_INPUT = "Your input is not valid. Please input again.";
    public static final String ENTER_YOUR_OPTION = "Enter your option: ";
    public static final String ID_DOES_NOT_EXIST = "The id does not exist.";
    public static final String ID_EXISTS = "The id has already existed.";
    public static final String NO_SEARCHED_STUDENTS = "There is no such students with the name input.";
    public static final String NO_SEARCHED_LECTURERS = "There is no such lecturers with the name input.";
    public static final String STUDENT_ADDED = "New student has been added.";
    public static final String LECTURER_ADDED = "New lecturer has been added.";
    public static final String STUDENTS_DELETED = "Student(s) has (have) been deleted.";
    public static final String LECTURERS_DELETED = "Lecturer(s) has (have) been deleted.";
    public static final String STUDENTS_UPDATED_INFO = "Student's updated information: ";
    public static final String LECTURERS_UPDATED_INFO = "Lecturer's updated information: ";

    public static final String ENTER_ID = "Enter the id: ";
    public static final String ENTER_NAME = "Enter the name: ";
    public static final String ENTER_DOB = "Enter date of birth: ";
    public static final String ENTER_EMAIL = "Enter the email: ";
    public static final String ENTER_PHONE = "Enter the phone: ";
    public static final String ENTER_ADDRESS = "Enter the address: ";
    public static final String ENTER_BATCH = "Enter the batch: ";
    public static final String ENTER_DEPARTMENT = "Enter the department: ";

    public static final String ID = "Id: ";
    public static final String NAME = "Name: ";
    public static final String DOB = "Date of birth: ";
    public static final String EMAIL = "Email: ";
    public static final String PHONE = "Phone: ";
    public static final String ADDRESS = "Address: ";
    public static final String BATCH = "Batch: ";
    public static final String DEPARTMENT = "Department: ";

    public static final String DATEFORMAT = "dd/mm/yyyy";

    public static void writeln(String content) {
        System.out.println(content);
    }

    public static void write(String content) {
        System.out.print(content);
    }
}
