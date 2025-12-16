from abc import ABC, abstractmethod

class IProjectChangeHandler(ABC):

    @abstractmethod
    def handle_change(self, change: 'ProjectChange') -> None:
        pass