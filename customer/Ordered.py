
from AbstractEvent import AbstractEvent
import json

class Ordered(AbstractEvent):
    id : int
    item : str
    colorCode : str
    size : str
    quantity : int
    
    def __init__(self):
        super().__init__()
        self.id = None
        self.item = None
        self.colorCode = None
        self.size = None
        self.quantity = None

