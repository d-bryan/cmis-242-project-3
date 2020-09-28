package project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CMIS242DesignPRJ3BryanD {

  /** Abstract Shape Class - Extends Rectangle class */
  public abstract static class Shape extends Rectangle {
    private final Color color;
    private final boolean solid;
    private static int count = 0;
//    private Dimension d;

    /**
     * Creates a new {@code Shape} Object which is used as
     * the base shape for subclasses
     * @param rectangle RECTANGLE 2D rectangle object
     * @param color COLOR sRGB color value of {@code Shape} Object
     * @param solid BOOLEAN true/false value whether shape is solid or hollow
     */
    public Shape(Rectangle rectangle, Color color, boolean solid) {
      super(rectangle);
      this.color = color;
      this.solid = solid;
      Shape.count++;
    } // end Shape constructor

    /**
     * Set the color for the next drawn operation to
     * the color of the current shape
     * @param graphics GRAPHICS graphics object
     */
    public void setColor(Graphics graphics) {
      // TODO: Set the color for the next drawn operation to the color of the current shape
      graphics.setColor(this.color);
    } // end setColor method

    /**
     * Checks to see if the object is solid or hollow
     * @return BOOLEAN solid or hollow object
     */
    public boolean getSolid() {
      // if solid is true the object is solid
      // else the object is hollow
      return (this.solid == true) ? true : false;
    } // end getSolid method

    /**
     * @return INT The total number of Shapes created so far * excluding processing errors,
     *     such as an entry that is * not an integer.
     */
    public static int getNoOfShapes() {
      return count;
    } // end getNoOfShapes method

    /**
     * Draw method for parameters of graphic object
     * @param graphics GRAPHICS graphic object
     */
    public abstract void draw(Graphics graphics);

  } // end Shape class

  /** Oval Class - Extends Shape Class */
  public static class Oval extends Shape {

    /**
     * Creates a new Oval {@code Shape} Object
     * @param rectangle RECTANGLE 2D rectangle object
     * @param color COLOR sRGB color value of {@code Shape} Object
     * @param solid BOOLEAN true/false value whether shape is solid or hollow
     */
    public Oval(Rectangle rectangle, Color color, boolean solid) {
      super(rectangle, color, solid);
      // TODO: Need four parameters for this constructor
    } // end constructor

    // override for drawing oval
    @Override
    public void draw(Graphics graphics) {
      // TODO: implement draw method for Oval class
      graphics.create(this.x, this.y, this.width, this.height);
    } // end draw method Oval
  } // end Oval class

  /** Rectangular class - Extends Shape Class */
  public static class Rectangular extends Shape {

    /**
     * Creates a new Rectangular {@code Shape} Object
     * @param rectangle RECTANGLE 2D rectangle object
     * @param color COLOR sRGB color value of {@code Shape} Object
     * @param solid BOOLEAN true/false value whether shape is solid or hollow
     */
    public Rectangular(Rectangle rectangle, Color color, boolean solid) {
      super(rectangle, color, solid);
      // TODO: need four parameters for this constructor
    } // end constructor

    // override for drawing rectangle
    @Override
    public void draw(Graphics graphics) {
      // TODO: implement draw method for Rectangular
      graphics.create(this.x, this.y, this.width, this.height);
    } // end draw method Rectangular
  } // end Rectangular class

  /** Drawing Class - Extends JPanel */
  public static class Drawing extends JPanel {
    private Shape shape;

    // overridden paintComponent method
    @Override
    public void paintComponent(Graphics graphics) {
      // draw shape of graphics
      super.paintComponent(graphics);
      // checking if the shape is null.

    } // end paintComponent method

    // overridden getPreferredSize method
    @Override
    public Dimension getPreferredSize() {

      // make the dimensions 200 by 200
      return new Dimension(200, 200);
    } // end getPreferredSize method

    // drawShape method
    public void drawShape(Shape shape) throws OutsideBounds {

      // TODO: check for boundaries
      // TODO: repaint the shape
      // TODO: call repaint method
//      repaint();
    } // end drawShape method
  } // end Drawing class

  /** OutsideBounds Class - Extends Exception */
  public static class OutsideBounds extends Exception {
    private int xCoordinate;
    private int yCoordinate;
    private int width;
    private int height;

    /**
     * Creates OutsideBounds object with Shape information to check against
     * @param obj SHAPE Shape object with information about
     *            current shape being processed
     */
    public OutsideBounds(Shape obj) {
      // check to ensure dimensions are within 200 x 200
      if (!this.checkDimensions(obj)) {
        // ensure width must be an integer
        if (((Object)obj.width).getClass().getName() != "java.lang.Integer") {
          new OutsideBounds("Width must be an Integer");
        } else {
          this.width = obj.width;
        } // end if/else
        // ensure height is an integer
        if (((Object)obj.height).getClass().getName() != "java.lang.Integer") {
          new OutsideBounds("Height must be an Integer");
        } else {
          this.height = obj.height;
        } // end if/else
      } else {
        new OutsideBounds("Out of Bounds: 200 x 200");
      } // end if/else statement
      // ensure x coordinate is an integer
      if (((Object)obj.x).getClass().getName() != "java.lang.Integer") {
        new OutsideBounds("x Coordinate must be an integer");
      } else {
        this.xCoordinate = obj.x;
      } // end if/else statement
      // ensure y coordinate is an integer
      if (((Object)obj.y).getClass().getName() != "java.lang.Integer") {
        new OutsideBounds("y Coordinate must be an integer");
      } else {
        this.yCoordinate = obj.y;
      } // end if/else statement
    } // end OutsideBounds constructor

    /**
     * Creates a message constructor to alert user to exception
     * @param message STRING exception message
     */
    public OutsideBounds(String message) {
      super(message);
    } // end OutsideBounds Message Constructor

    /**
     * Checks to see if dimensions are out of bounds,
     * limit shapes to 200 x 200
     * @param obj SHAPE shape object with information about current shape
     * @return BOOLEAN true/false value
     */
    public boolean checkDimensions(Shape obj) {
      boolean outOfBounds = false;
      // check to see if dimensions are out of bounds
      if (obj.width > 200 || obj.height > 200) {
        outOfBounds = true;
      } // end if statement

      return outOfBounds;
    } // end checkDimensions method

  } // end OutsideBounds class

  /** ProgramCore class - Extends JFrame */
  static class ProgramCore extends JFrame {
    // TODO: Declare attributes for GUI

    // TODO: Clean up comments for ProgramCore constructor
    /**
     * Core Program constructor
     */
    public ProgramCore() {

      // GUI parameters
      // call for the GUI window
      // GUI buttons
      // TODO: create action event listener with lambda expression to get rid of methods
      //  and ensure that constructor is setup properly


      //      drawButton.addActionListener(new ActionListener() {
      //
      //        // action performed according to user input
      //        @Override
      //        public void actionPerformed(ActionEvent e) {
      //
      //          // taking data from user input
      //          // creating the rectangle
      //          // checking the colors
      //          // checking the shape type
      //          // drawing the shape
      //          // shape count
      //          drawingPanel.drawShape(shape);
      //
      //        }// end actionPerformed
      //
      //      }); // end ActionListener

    } // end constructor

    /**
     * Add the components by drawing the shape
     */
    private void addComponents() {
      // TODO: draw the shape
    } // end addComponents
  } // end ProgramCore class

  // main method
  public static void main(String[] args) {
    // TODO: instantiate new object from ProgramCore
//    ProgramCore frame = new ProgramCore();
    // TODO: make the GUI appear
//    frame.setVisible(true);
  } // end public static void main
} // end public class CMIS242DesignPRJ3BryanD
