# Project 3 Rubric

## Shape Class (15 points)
An abstract class that extends the predefined Java class Rectangle. It should have three instance methods, one class method and one abstract method:
1. A constructor that accepts three parameters for the purpose of initializing the characteristics of the shape: Dimensions & Position, Color, Density (solid or hollow)
Update the number of shapes appropriately.
2. The setColor accepts Graphics object and sets the color of the current shape.
3. The getSolid returns either solid or hollow shape.
4. The getNoOfShapes returns valid number of shapes.
5. The abstract method draw that accepts a Graphics object.

## Oval Subclass (15 points)
It should have the following two methods:
1. A constructor that accepts three parameters for the purpose of initializing the characteristics of a Rectangle object: Dimensions & Position, Color, Density (solid or hollow)
2. An overridden method draw that draws the Oval object on the Graphics object passed as a parameter.

## Rectangular Subclass (15 points)
It should have the following two methods:
1. A constructor that accepts three parameters for the purpose of initializing the characteristics of a Rectangle object: Dimensions & Position, Color, Density (solid or hollow)
2. An overridden method draw that draws the Rectangular object on the Graphics object passed as a parameter.

## Drawing Class (15 Points)
Extends the predefined Java class JPanel with one instance variable that contains the shape that is currently drawn. It should have three methods:
1. The paintComponent method that draws the current shape on the Graphics object passed to it as a parameter. Number of shapes are drawn in upper left corner.
2. An overridden getPreferredSize method specifies the Drawing Panel the dimensions of 200 pixels wide and 200 pixels high.
3. The drawShape instance method is passed the current shape to be drawn, checking whether the shape fits within the Drawing Panel. If not, it throws an OutsideBounds exception. Otherwise, it saves the shape in the corresponding instance variable. It then calls repaint to cause that shape to be drawn.

## OutsideBounds Class (5 points)
Defines a checked exception. The width and height of the shape are not greater than 200 pixels.

## Program Core (15 points)
It should contain the main method. It should generate the GU.
1. Shape Type combo-box: Rectangle or Oval. 
2. Fill Type combo-box: Hollow or Solid. 
3. Color combo-box: Black, Red, Orange, Yellow, Green, Blue or Magenta.
4. Clicking the Draw button should check for non-integer entered in any TextField box. Unique error message displayed in a JOptionPane window identifying the TextField.
5. If that call results in an OutsideBounds exception being thrown, an appropriate error message should be displayed in a JOptionPane window.
6. Otherwise an appropriate Shape object should be created and passed to the drawShape method of the Drawing class.

## Test Cases (10 points)
1. Test cases are supplied in the form of a table with columns indicating the input values, processes, outputs, messages, and supporting screen shots.
2. Enough data examples selected to completely test the program.
3. Test cases were included in the supporting word or PDF documentation.

## Documentation and Style Guide (10 points)
1. Screen captures were provided and labeled for compiling your code and running each of your test cases.
2. Header comments include filename, author, date and brief purpose of the program.
3. In-line comments used to describe major functionality of the code.
4. Meaningful variable names and prompts applied.
5. Class names are written in UpperCamelCase.
6. Variable names are written in LowerCamelCase.
7. Constant names are in written in All Capitals.
8. Braces use K&R style.
9. Declare all instance variables private.
10. Avoids the duplication of code.
