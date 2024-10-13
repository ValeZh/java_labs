public interface Plant {
    void setInfo(String name, String origin);
    void getInfo();
    void waterPlant();
    void setTemperature(int temperature);
    void setLighting(String lighting);
    void removePlant();
}