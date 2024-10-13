public class BushPlant implements Plant {
    private String name;
    private String origin;

    @Override
    public void setInfo(String name, String origin) {
        this.name = name;
        this.origin = origin;
    }

    @Override
    public void getInfo() {
        System.out.println("Кущова рослина: " + name + ", походження: " + origin);
    }

    @Override
    public void waterPlant() {
        System.out.println("Кущова рослина полита.");
    }

    @Override
    public void setTemperature(int temperature) {
        System.out.println("Температура для кущової рослини встановлена на: " + temperature + " градусів.");
    }

    @Override
    public void setLighting(String lighting) {
        System.out.println("Освітлення для кущової рослини встановлено: " + lighting);
    }

    @Override
    public void removePlant() {
        System.out.println("Кущову рослину видалено.");
    }

    // Спеціалізовані методи для Кущової рослини
    public void prune() {
        System.out.println("Кущову рослину підстрижено.");
    }
}