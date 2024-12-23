## Design

### Milestones & Tests

1. Declare interface Translation.
2. Add method translate to Translation.
****
3. Declare interface Rotation.
4. Add method translate to Rotation.
****
5. Declare abstract class Point.
6. Outline methods translate, rotate, and toString methods for Point.
****
7. Declare class PolarPoint.
8. Add angle and radius attributes to PolarPoint.
9. Add translate, rotate, and toString methods to PolarPoint.
10. Run first test:
    * Create a PolarPoint with angle 50, radius 10.
    * Print the PolarPoint and assess the accuracy of these attributes.
    * Translate by: x + 9, y + 13
    * Print the PolarPoint and assess accuracy of translation with manual calculation.
    * Rotate by: + 77 degrees
    * Print the PolarPoint and assess accuracy of rotation with manual calculation.
11. Run second test:
    * Create a PolarPoint with angle -268, radius 8.5.
    * Print the PolarPoint and assess the accuracy of these attributes.
    * Translate by: x + 80, y - 35
    * Print the PolarPoint and assess accuracy of translation with manual calculation.
    * Rotate by: + 90 degrees
    * Print the PolarPoint and assess accuracy of rotation with manual calculation.
****
12. Declare class CartesianPoint.
13. Add x and y attributes to PolarPoint.
14. Add translate, rotate, and toString methods to CartesianPoint.
15. Run third test:
    * Create a CartesianPoint with x-coordinate 0, y-coordinate 0.
    * Print the CartesianPoint and assess the accuracy of these attributes.
    * Translate by: x - 0.5, y + 440
    * Print the CartesianPoint and assess accuracy of translation with manual calculation.
    * Rotate by: + 100 degrees
    * Print the CartesianPoint and assess accuracy of rotation with manual calculation.
16. Run fourth test:
    * Create a CartesianPoint with x-coordinate 476, y-coordinate 62.
    * Print the CartesianPoint and assess the accuracy of these attributes.
    * Translate by: x - 744, y + 9
    * Print the CartesianPoint and assess accuracy of translation with manual calculation.
    * Rotate by: + 360 degrees
    * Print the CartesianPoint and assess accuracy of rotation with manual calculation.

### Reflection
PolarPoint and CartesianPoint are concrete classes that extend the Point class. They provide specific implementations for the translate and rotate methods based on their own systems (polar and cartesian).
Because the PolarPoint and CartesianPoint classes inherit from the abstract Point class, they can reuse the common methods (translate and rotate). 
The Translation and Rotation interfaces outline the methods that the Point class must have, and also consequently the PolarPoint and CartesianPoint must too. 
I followed the milestones outlined above and did not need to make any significant changes but I did encounter an issue with the use of radians for trigonometric functions (instead of degrees).
Overall, I found this project to be a valuable learning experience. The use of abstract classes, concrete classes, inheritance, and interfaces helped me understand OOP better. The biggest challenge I faced was just the misunderstanding with the use of radians in the Math class's functions, which caused me frustration during testing. Once I realized this, I was able to successfully confirm the accuracy of the computations!


