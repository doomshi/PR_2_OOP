from abc import ABC, abstractmethod

class Participant(ABC):
    def __init__(self, id: int, name: str):
        self._id = id
        self._name = name

    def get_id(self) -> int:
        return self._id

    def get_name(self) -> str:
        return self._name

    # Абстрактний метод для ролі учасника
    @abstractmethod
    def get_role(self) -> str:
        pass