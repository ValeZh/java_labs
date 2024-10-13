class IndoorPlant implements Plant {
    private String name;
    private String origin;

    public void setInfo(String name, String origin) {
        this.name = name;
        this.origin = origin;
    }

    public void getInfo() {
        System.out.println("Кімнатна рослина: " + name + ", походження: " + origin);
    }

    public void waterPlant() {
        System.out.println("Кімнатну рослину полито.");
    }

    public void setTemperature(int temperature) {
        System.out.println("Температура для кімнатної рослини встановлена на: " + temperature + " градусів.");
    }

    public void setLighting(String lighting) {
        System.out.println("Освітлення для кімнатної рослини встановлено: " + lighting);
    }

    public void removePlant() {
        System.out.println("Кімнатну рослину видалено.");
    }

    // Спеціалізовані методи для Кімнатної рослини
    public void repot() {
        System.out.println("Кімнатну рослину пересаджено.");
    }
}