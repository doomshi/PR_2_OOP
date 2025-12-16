class Foreman(Participant, IProjectChangeHandler):
    def __init__(self, id: int, name: str, experience_years: int):
        super().__init__(id, name)
        self._experience_years = experience_years
        print(f"[Foreman] Created Foreman: {name}, exp={experience_years}")

    def initiate_change(self, description: str, impact: str) -> 'ProjectChange':
        print(f"[Foreman] Initiating change: {description}")
        return ProjectChange(description, impact)

    def close_stage(self) -> None:
        print("[Foreman] Closing stage (acceptance).\n")

    def handle_change(self, change: 'ProjectChange') -> None:
        print(f"[Foreman] Handling change event: {change}")

    def get_role(self) -> str:
        return "Foreman"