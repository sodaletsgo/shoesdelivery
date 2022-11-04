
from AbstractEvent import AbstractEvent
import json

class OrderCancelled(AbstractEvent):
    id : int
    orderId : int
    status : str
    
    def __init__(self):
        super().__init__()
        self.id = None
        self.orderId = None
        self.status = None

