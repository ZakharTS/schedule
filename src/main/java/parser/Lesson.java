package parser;

public class Lesson {
    public static boolean isGroupName(String data) {
        // to do
        return true;
    }

    public static boolean isDay(String data) {
        // to do
        return true;
    }
    public static String formatGroupName(String data) {
        // to do
        return data;
    }

    public static String formatLessonName(String data) {
        // to do
        return data;
    }

    // etc

    enum LessonType {
        LECTURE,
        PRACTICE,
        LAB
    }

    enum WeekType {
        UPPER,
        LOWER,
        BOTH
    }

    private String lessonName = null;
    private LessonType lessonType = null;
    private String teacherName = null;
    private String classroomNum = null;

    private String groupName = null;
    private int subgroupNum;
    private WeekType week = null;

    private String day = null;
    private String time = null;
    private int number;

    int rowIndex;
    int columnIndex;

}
