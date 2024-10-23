import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SportsClubManagement club = new SportsClubManagement();
        Scanner scanner = new Scanner(System.in);

        // Додаємо кілька тренерів
        Coach coach1 = new Coach("Олег");
        Coach coach2 = new Coach("Ірина");

        // Додаємо кілька членів клубу
        club.addMember(new ClubMember("Олексій", 1));
        club.addMember(new ClubMember("Марія", 2));

        // Додаємо кілька занять
        club.addClassSession(new ClassSession("Йога", coach1, 1));
        club.addClassSession(new ClassSession("Фітнес", coach2, 2));
        club.addClassSession(new ClassSession("Плавання", coach1, 3));

        // Консольне меню для взаємодії
        while (true) {
            System.out.println("\n--- Управління спортивним клубом ---");
            System.out.println("1. Показати всіх членів клубу");
            System.out.println("2. Показати розклад занять");
            System.out.println("3. Показати чергу занять за пріоритетом");
            System.out.println("4. Вийти");
            System.out.print("Оберіть дію: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    club.showMembers();
                    break;
                case 2:
                    club.showSchedule();
                    break;
                case 3:
                    club.showPriorityQueue();
                    break;
                case 4:
                    System.out.println("Вихід з програми.");
                    return;
                default:
                    System.out.println("Неправильний вибір.");
            }
        }
    }
}