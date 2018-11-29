package com.company;

public class Command {
    public static final String SEPERATOR = "===================================";
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

    public static final String BLANK_LINE = "\n";

    public static final String NOT_VALID_NUMBER_INPUT = "You input is not valid. Please input again";
    public static final String ENTER_YOUR_OPTION = "Enter your option: ";

    public static void writeln(String content) {
        System.out.println(content);
    }

    public static void write(String content) {
        System.out.print(content);
    }
}