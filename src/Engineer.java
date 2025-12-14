// Інженер: переглядає зміни і оновлює графік
public class Engineer extends Participant implements IProjectChangeHandler {
    private String licenseNumber;

    public Engineer(int id, String name, String licenseNumber) {
        super(id, name);
        this.licenseNumber = licenseNumber;
        System.out.println("[Engineer] Created Engineer: " + name + ", license=" + licenseNumber);
    }

    public boolean approveChange(ProjectChange c) {
        System.out.println("[Engineer] Approving change: " + c);
        return true; // в прототипі завжди погоджуємо
    }

    public void updateSchedule() {
        System.out.println("[Engineer] Updating schedule to reflect approved changes.");
    }

    @Override
    public void handleChange(ProjectChange c) {
        System.out.println("[Engineer] Notified about change: " + c);
        if (approveChange(c)) {
            updateSchedule();
        }
    }

    @Override
    public String getRole() {
        return "Engineer";
    }
}
