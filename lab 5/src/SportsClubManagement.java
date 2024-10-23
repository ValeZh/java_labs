import java.util.*;

public class SportsClubManagement {
    private HashSet<ClubMember> members = new HashSet<>();
    private TreeMap<String, ClassSession> schedule = new TreeMap<>();
    private PriorityQueue<ClassSession> classQueue = new PriorityQueue<>();

    // Додавання члена клубу
    public void addMember(ClubMember member) {
        if (members.add(member)) {
            System.out.println("Додано члена: " + member);
        } else {
            System.out.println("Член клубу вже існує: " + member);
        }
    }

    // Додавання заняття
    public void addClassSession(ClassSession session) {
        classQueue.offer(session);
        schedule.put(session.getClassName(), session);
        System.out.println("Додано заняття: " + session);
    }

    // Показати всіх членів клубу
    public void showMembers() {
        if (members.isEmpty()) {
            System.out.println("Немає зареєстрованих членів.");
        } else {
            for (ClubMember member : members) {
                System.out.println(member);
            }
        }
    }

    // Показати розклад занять
    public void showSchedule() {
        if (schedule.isEmpty()) {
            System.out.println("Розклад занять порожній.");
        } else {
            for (Map.Entry<String, ClassSession> entry : schedule.entrySet()) {
                System.out.println(entry.getValue());
            }
        }
    }

    // Показати чергу занять за пріоритетом
    public void showPriorityQueue() {
        if (classQueue.isEmpty()) {
            System.out.println("Черга занять порожня.");
        } else {
            PriorityQueue<ClassSession> tempQueue = new PriorityQueue<>(classQueue);
            while (!tempQueue.isEmpty()) {
                System.out.println(tempQueue.poll());
            }
        }
    }
}
