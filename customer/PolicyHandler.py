import util

from Ordered import Ordered

def wheneverOrdered_NotifyKakaotalk(data):
    event = Ordered()
    event = util.AutoBinding(data, event)
    
    
from OrderCancelled import OrderCancelled

def wheneverOrderCancelled_NotifyKakaotalk(data):
    event = OrderCancelled()
    event = util.AutoBinding(data, event)
    
    
from ShippingStarted import ShippingStarted

def wheneverShippingStarted_NotifyKakaotalk(data):
    event = ShippingStarted()
    event = util.AutoBinding(data, event)
    
    

