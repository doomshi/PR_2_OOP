class ProjectChange:
    def __init__(self, description: str, impact: str):
        self._description = description
        self._impact = impact

    def get_description(self) -> str:
        return self._description

    def get_impact(self) -> str:
        return self._impact

    def __str__(self) -> str:
        return f"Change[desc='{self._description}', impact='{self._impact}']"