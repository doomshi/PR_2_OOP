// Учасник проєкту: базовий абстрактний клас
public abstract class Participant {
    private int id;
    private String name;

    // Конструктор для ініціалізації учасника
    public Participant(int id, String name) {
        this.id = id;
    
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    // Абстрактний метод для ролі учасника
    public abstract String getRole();
}
