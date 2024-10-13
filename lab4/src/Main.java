
public class Main {
    public static void main(String[] args) {
        // Створення екземплярів різних рослин
        BushPlant bush = new BushPlant();
        FloweringPlant flower = new FloweringPlant();
        IndoorPlant indoor = new IndoorPlant();

        // Встановлення інформації про рослини
        bush.setInfo("Троянда", "Європа");
        flower.setInfo("Орхідея", "Азія");
        indoor.setInfo("Кактус", "Південна Америка");

        // Виклик загальних методів
        bush.getInfo();
        bush.waterPlant();
        bush.setTemperature(20);
        bush.setLighting("Сонячне світло");
        bush.prune(); // спеціалізований метод

        System.out.println();

        flower.getInfo();
        flower.waterPlant();
        flower.setTemperature(25);
        flower.setLighting("Яскраве світло");
        flower.bloom(); // спеціалізований метод

        System.out.println();

        indoor.getInfo();
        indoor.waterPlant();
        indoor.setTemperature(22);
        indoor.setLighting("Помірне світло");
        indoor.repot(); // спеціалізований метод
    }
}