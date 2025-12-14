// Постачальник: залежність від проєкту, постачає матеріали
public class Supplier extends Participant {
    private String companyName;

    public Supplier(int id, String name, String companyName) {
        super(id, name);
        this.companyName = companyName;
        System.out.println("[Supplier] Created Supplier: " + name + ", company=" + companyName);
    }

    // Залежність: постачальник залежить від проєкту під час доставки
    public void deliverMaterials(ConstructionProject project) {
        System.out.println("[Supplier] Delivering materials for project: " + project.getTitle());
    }

    @Override
    public String getRole() {
        return "Supplier";
    }
}
