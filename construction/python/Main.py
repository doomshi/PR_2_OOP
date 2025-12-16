from ConstructionProject import ConstructionProject
from Foreman import Foreman
from Engineer import Engineer
from Supplier import Supplier

def main():
    print("--- Simulation start ---")

    project = ConstructionProject("New Office Building")

    foreman = Foreman(1, "Ivan", 10)
    engineer = Engineer(2, "Olena", "ENG-12345")
    supplier = Supplier(3, "Petro", "BuildSupply LLC")

    # Прораб ініціює зміну
    change = foreman.initiate_change(
        "Extend foundation depth",
        "Increased cost and time"
    )

    # Проєкт додає зміну (агрегація)
    project.add_change(change)

    # Проєкт повідомляє інженера (послідовність)
    engineer.handle_change(change)

    # Прораб закриває етап
    foreman.close_stage()

    # Постачальник доставляє матеріали (залежність)
    supplier.deliver_materials(project)

    print(f"[Main] Project status: {project.get_status()}")
    print("--- Simulation end ---")


if __name__ == "__main__":
    main()