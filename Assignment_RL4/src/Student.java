public class Student {
    //it get and set need
    private final int id;
    private final String name;
    private final int classYear;

    public Student(int id, String name, int classYear) {
        this.id = id;
        this.name = name;
        this.classYear = classYear;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getClassYear() {
        return classYear;
    }

    @Override
    public String toString() {
        return id + "," + name + "," + classYear;
    }

    public static Student fromString(String studentData) {
        String[] parts = studentData.split(",");
        return new Student(Integer.parseInt(parts[0]), parts[1], Integer.parseInt(parts[2]));
    }
}
