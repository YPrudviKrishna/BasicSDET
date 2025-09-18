'''

@author: HP
'''

import math

class CircleComp:
    
    def __init__(self, radius):
        self.radius = radius
        self.diameter = self.radius * 2
        self.area = math.pi * self.radius * self.diameter
        

    def display(self):
        print(f"Radius: {self.radius}")
        print(f"Diameter: {self.diameter}")
        print(f"Area: {self.area}")
       

r = float(input("Enter the radius of the circle: "))
circle = CircleComp(r)
circle.display()
