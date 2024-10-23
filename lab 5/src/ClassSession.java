public class ClassSession implements Comparable<ClassSession> {
    private String className;
    private Coach coach;
    private int priority; // Пріоритет заняття, наприклад, за важливістю

    public ClassSession(String className, Coach coach, int priority) {
        this.className = className;
        this.coach = coach;
        this.priority = priority;
    }

    public String getClassName() {
        return className;
    }

    public Coach getCoach() {
        return coach;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public int compareTo(ClassSession other) {
        return Integer.compare(this.priority, other.priority);
    }

    @Override
    public String toString() {
        return "Заняття: " + className + ", Тренер: " + coach.getName() + ", Пріоритет: " + priority;
    }
}
