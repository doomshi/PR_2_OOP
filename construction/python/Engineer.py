from abc import ABC, abstractmethod

class Engineer(Participant, IProjectChangeHandler):
    def __init__(self, id: int, name: str, license_number: str):
        super().__init__(id, name)
        self._license_number = license_number
        print(f"[Engineer] Created Engineer: {name}, license={license_number}")

    def approve_change(self, change: 'ProjectChange') -> bool:
        print(f"[Engineer] Approving change: {change}")
        return True  # у прототипі завжди погоджуємо

    def update_schedule(self) -> None:
        print("[Engineer] Updating schedule to reflect approved changes.")

    def handle_change(self, change: 'ProjectChange') -> None:
        print(f"[Engineer] Notified about change: {change}")
        if self.approve_change(change):
            self.update_schedule()

    def get_role(self) -> str:
        return "Engineer"