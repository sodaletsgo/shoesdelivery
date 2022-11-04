
from AbstractEvent import AbstractEvent
import json

class ShippingStarted(AbstractEvent):
    id : int
    productName : str
    deliveryAddress : str
    orderId : str
    phoneNumber : int
    deliveryDate : str
    
    def __init__(self):
        super().__init__()
        self.id = None
        self.productName = None
        self.deliveryAddress = None
        self.orderId = None
        self.phoneNumber = None
        self.deliveryDate = None

