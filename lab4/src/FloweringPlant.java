// Реалізація інтерфейсу для Квіткової рослини
class FloweringPlant implements Plant {
    private String name;
    private String origin;

    public void setInfo(String name, String origin) {
        this.name = name;
        this.origin = origin;
    }

    public void getInfo() {
        System.out.println("Квіткова рослина: " + name + ", походження: " + origin);
    }

    public void waterPlant() {
        System.out.println("Квіткову рослину полито.");
    }

    public void setTemperature(int temperature) {
        System.out.println("Температура для квіткової рослини встановлена на: " + temperature + " градусів.");
    }

    public void setLighting(String lighting) {
        System.out.println("Освітлення для квіткової рослини встановлено: " + lighting);
    }

    public void removePlant() {
        System.out.println("Квіткову рослину видалено.");
    }

    // Спеціалізовані методи для Квіткової рослини
    public void bloom() {
        System.out.println("Квіткова рослина розцвіла.");
    }
}
