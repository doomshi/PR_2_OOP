from typing import List

# Клас проєкту з агрегованими змінами
class ConstructionProject:
    def __init__(self, title: str):
        self._title = title
        self._changes: List['ProjectChange'] = []
        print(f"[Project] Created project: {title}")

    def get_title(self) -> str:
        return self._title

    def add_change(self, change: 'ProjectChange') -> None:
        self._changes.append(change)
        print(f"[Project] Change added: {change}")

    # "final" у Python реалізується домовленістю (не перевизначати)
    def get_status(self) -> str:
        return f"Active (changes: {len(self._changes)})"

    def get_changes(self) -> List['ProjectChange']:
        return self._changes