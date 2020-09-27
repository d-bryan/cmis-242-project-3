package project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CMIS242DesignPRJ3BryanD {

  // Shape class
  public abstract static class Shape extends Rectangle {

    // declare attributes
    private final Color color;
    private final boolean solid;
    private static int count = 0;

    // constructor
    public Shape(Rectangle rectangle, Color color, boolean solid) {

      super(rectangle);
      this.color = color;
      this.solid = solid;
      Shape.count++;
    } // end constructor

    // draw method for parameters of graphic object
    public abstract void draw(Graphics graphics);
  } // end Shape class

  // Oval class, subclass of Shape
  public static class Oval extends Shape {

    // constructor
    public Oval(Rectangle rectangle, Color color, boolean solid) {
      super(rectangle, color, solid);
      // TODO: Need four parameters for this constructor
    } // end constructor

    // override for drawing oval
    @Override
    public void draw(Graphics graphics) {

      // draw the oval shape.

    } // end draw method
  } // end Oval class

  // Rectangular class, subclass of Shape
  public static class Rectangular extends Shape {

    // constructor
    public Rectangular(Rectangle rectangle, Color color, boolean solid) {
      super(rectangle, color, solid);
      // TODO: need four parameters for this constructor
    } // end constructor

    // override for drawing rectangle
    @Override
    public void draw(Graphics graphics) {

      // draw the rectangular shape.
    } // end drawing
  } // end Rectangular class

  // Drawing class
  public static class Drawing extends JPanel {

    // declare attributes
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

      // checking boundaries
      // repainting the shape
      repaint();
    } // end drawShape method
  } // end Drawing class

  // OutsideBounds class
  public static class OutsideBounds extends Exception {

    // define checked exceptions through extension

  } // ends OutsideBounds class

  // ProgramCore class
  static class ProgramCore extends JFrame {

    // declare attributes for GUI

    // constructor
    public ProgramCore() {

      // GUI parameters
      // call for the GUI window
      // GUI bottons
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

    // add components
    private void addComponents() {

      // drawing the shape

    } // end addComponents
  } // end ProgramCore class

  // main method
  public static void main(String[] args) {

    // instantiate new object from ProgramCore
    ProgramCore frame = new ProgramCore();
    // make GUI appear
    frame.setVisible(true);
  } // end public static void main
} // end public class CMIS242DesignPRJ3BryanD
