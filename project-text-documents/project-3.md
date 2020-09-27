# Programming Project 3

## Assignment Requirements: 

Two documents are expected: (1) One Java program containing all the code for the assignment. I do not accept multiple 
Java files in a single assignment folder and (2) a Test Plan document containing a table and screen captures. 
`Please review the information in the Project 3 Deliverables thread. All the attached files are there to aid in your 
skill development and enhanced knowledge.`

Caution: I often send feedback to you after reviewing your assignment. I always send it to your email account that UMGC 
has on record. It seems to happen often that the feedback email goes to SPAM. Please check your SPAM folder regularly to 
ensure you are not missing my communications. I expect a response to those emails that deal with feedback

The third programming project involves writing one program that draws two types of shapes: `ovals and rectangles`. This 
program consists of five classes and a Program Core.

### Shape Class 
The first class is the `Shape class`, which is an abstract class that extends the predefined Java class `Rectangle`. 
It should contain `two instance variables`, the color of the shape and the density of the shape `solid or hollow`. It 
should also contain a `class (static) variable` that keeps track of how many shapes have been created. It should have 
three instance methods, one class method, and one abstract method:

1. A constructor that accepts three parameters for the purpose of initializing the characteristics of the shape:
    - Rectangle object that defines the dimensions and position of the shape
    - Color of the shape
    - Density of the shape: solid or hollow
    - It should also update the number of shapes created from the beginning of the program.

2. An instance method named `setColor` that accepts the Graphics object as a parameter and sets the color for the next 
draw operation to the color of the current shape.
3. An instance method named `getSolid` that returns whether the shape is solid or hollow.
4. A class method named `getNoOfShapes` that returns the number of shapes created so far excluding processing errors, 
like an entry that is not an integer.
5. An abstract method named `draw` that accepts a Graphics object as a parameter.

<strong>The Shape class has two subclasses: Oval and Rectangular.</strong>

### Oval Class - Extends Shape
The first subclass is Oval. It should have the following two methods:
1. A constructor that accepts three parameters for the purpose of initializing the characteristics of the shape, 
a Rectangle object that defines:
    - Dimensions and Position of the shape
    - Color of the shape
    - Density of the shape: solid or hollow
    
2. An overridden method `draw` that draws the Oval object on the Graphics object passed as a parameter.

### Rectangular Class - Extends Shape
The second subclass is Rectangular. It should have the following two methods:
1. A constructor that accepts three parameters for the purpose of initializing the characteristics of the shape, a 
Rectangle object that defines:
    - Dimensions and Position of the shape
    - Color of the shape
    - Density of the shape: solid or hollow
    
2. An overridden method `draw` that draws the Rectangular object on the Graphics object passed as a parameter.

### Drawing class - Extends JPanel
The fourth class is named Drawing, which should extend the predefined Java class JPanel. 
It has one instance variable that contains the shape that is currently drawn. It should have three methods:
1. An overridden `paintComponent` method that draws the current shape on the 
Graphics object that is passed to it as a parameter. It should also draw the number 
of shapes that have been created thus far in the upper left corner. 
2. An overridden `getPreferredSize` method that specifies the dimensions of the 
drawing panel as 200 pixels wide and 200 pixels high.
3. An instance method named `drawShape` that is passed the current shape to be drawn. It first checks whether
 the shape provided is no greater than `200 pixels x 200` pixels in width and height. This check has no 
 relation to the coordinate positioning of the shape. If the parameters are greater than the shape, it throws 
 an `OutsideBounds exception`. Otherwise, it saves the shape in the corresponding instance variable. It then calls 
 `repaint` to cause that shape to be drawn. For this program, the effect of positioning of the shape that might have 
 part of the shape go outside one or more boundaries of the Drawing Panel should not be considered. 
 `Example: The width of the shape is 190 and the x coordinate is 50. 
 Those values combined will place the shape 40 pixels outside the right boundary of the Drawing Panel. 
 Do not consider these scenarios for this project.`

<strong>No additional public methods should be included in any of the above classes.</strong>

### OutsideBounds Class - Extends Exception
The fifth class named OutsideBounds should define a checked exception.

### ProgramCore Class

The Program Core should contain the main method. It should generate the GUI shown below:

- The combo-box for the Shape Type should allow two choices, either Rectangle or Oval. 
- The combo-box for the Fill Type should also allow two choices, either Hollow or Solid. 
- The combo-box for the Color should allow seven choices, Black, Red, Orange, Yellow, Green, Blue, or Magenta.

![GUI Example](/Users/dylan/dev/UMGC/cmis-242/CMIS242DesignPRJ3BryanD/project-text-documents/gui-example.png)

Clicking the Draw button should first check whether any non-integer values have been entered 
in any of the fields that require integers. If so, an error message should be displayed in a JOptionPane 
window for the specific TextField without the integer. A generic message is not acceptable. Otherwise an 
appropriate Shape object should be created and passed to the drawShape method of the Drawing class. If that 
call results in an OutsideBounds exception being thrown, an appropriate error message should be displayed in 
a JOptionPane window. Note: only successful shapes that are displayed add to the count for Shapes.

It might be more user-friendly to add two additional buttons to the Geometric Drawing Window: 
  - a Clear Field button for the width, height, and two coordinates TextFields and 
  - an Exit button to end the program in a user-friendly manner.

Be sure to follow good programming style, which means making all instance variables private, naming all constants, 
and avoiding the duplication of code. Furthermore, you must select enough different kinds of shapes for a comprehensive 
Test Plan for the program.

