// Прораб: конкретний учасник, може ініціювати зміни та закривати етапи
public class Foreman extends Participant implements IProjectChangeHandler {
    private int experienceYears;

    public Foreman(int id, String name, int experienceYears) {
        super(id, name);
        this.experienceYears = experienceYears;
        System.out.println("[Foreman] Created Foreman: " + name + ", exp=" + experienceYears);
    }

    public ProjectChange initiateChange(String desc, String impact) {
        System.out.println("[Foreman] Initiating change: " + desc);
        return new ProjectChange(desc, impact);
    }

    public void closeStage() {
        System.out.println("[Foreman] Closing stage (acceptance).\n");
    }

    @Override
    public void handleChange(ProjectChange c) {
        System.out.println("[Foreman] Handling change event: " + c);
    }

    @Override
    public String getRole() {
        return "Foreman";
    }
}
