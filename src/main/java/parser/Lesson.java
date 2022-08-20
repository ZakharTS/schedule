package parser;

public class Lesson {

    protected static boolean isGroupName(String data) {
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

    private String lessonName = null;
    private String lessonType = null;
    private String teacherName = null;
    private String classroomNum = null;

    private String groupName = null;
    private String subgroupNum = null;

    private String day = null;
    private String time = null;
    private String number = null;

    int rowIndex;
    int columnIndex;

    public String getLessonName() {
        return lessonName;
    }

    public void setLessonName(String toSet) {
        lessonName = toSet;
    }

    public String getLessonType() {
        return lessonType;
    }

    public void setLessonType(String toSet) {
        lessonType = toSet;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String toSet) {
        teacherName = toSet;
    }

    public String getClassroomNum() {
        return classroomNum;
    }

    public void setClassroomNum(String toSet) {
        classroomNum = toSet;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String toSet) {
        groupName = toSet;
    }

    public String getSubgroupNum() {
        return subgroupNum;
    }

    public void setSubgroupNum(String toSet) {
        subgroupNum = toSet;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String toSet) {
        day = toSet;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String toSet) {
        time = toSet;
    }

    public int getRowIndex() {
        return rowIndex;
    }

    public void set(int toSet) {
        rowIndex = toSet;
    }

    public int getColumnIndex() {
        return columnIndex;
    }

    public void setColumnIndex(int toSet) {
        columnIndex = toSet;
    }

}
