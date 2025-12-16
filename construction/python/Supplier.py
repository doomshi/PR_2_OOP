class Supplier(Participant):
    def __init__(self, id: int, name: str, company_name: str):
        super().__init__(id, name)
        self._company_name = company_name
        print(f"[Supplier] Created Supplier: {name}, company={company_name}")

    # Залежність: постачальник залежить від проєкту під час доставки
    def deliver_materials(self, project: 'ConstructionProject') -> None:
        print(f"[Supplier] Delivering materials for project: {project.get_title()}")

    def get_role(self) -> str:
        return "Supplier"