package com.company.cmd;

import static com.company.Command.*;
import static com.company.Command.ENTER_YOUR_OPTION;

public class GUIController {
    //anh bắt đầu thấy Main của mình nó cồng kềnh rồi, anh refactor, chuyển mấy cái này vào Class GUIController nhé, sau này có gọi gì về Display lên GUI mà dài dòng, em hãy viết ở đây
    public static void openManageStudentWindow() {
        writeln(SEPERATOR);
        writeln(ADD_NEW_STUDENT);
        writeln(VIEW_ALL_STUDENTS);
        writeln(SEARCH_STUDENTS);
        writeln(DELETE_STUDENTS);
        writeln(UPDATE_STUDENT);
        writeln(BACK_TO_MAIN_MENU);
        writeln(SEPERATOR);
        write(ENTER_YOUR_OPTION);
    }

    public static void openManageLecturerWindow() {
        writeln(SEPERATOR);
        writeln(ADD_NEW_LECTURER);
        writeln(VIEW_ALL_LECTURERS);
        writeln(SEARCH_LECTURERS);
        writeln(DELETE_LECTURERS);
        writeln(UPDATE_LECTURER);
        writeln(BACK_TO_MAIN_MENU);
        write(ENTER_YOUR_OPTION);
    }

    public static void informInvalidNumberInput() {
        writeln(NOT_VALID_NUMBER_INPUT);
        write(ENTER_YOUR_OPTION);
    }

    public static void openFirstApplicationWindow() {
        writeln(SEPERATOR);
        writeln(MANAGE_STUDENTS);
        writeln(MANAGE_LECTURERS);
        writeln(EXIT);
        writeln(SEPERATOR);
        write(ENTER_YOUR_OPTION);
    }
}
