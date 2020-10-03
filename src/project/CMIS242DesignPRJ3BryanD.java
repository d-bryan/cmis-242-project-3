/*******************************************************************************
 * File: CMIS242DesignPRJ3BryanD.java
 * Author: Dylan Bryan
 * Date: 10/3/20, 10:34 AM
 * Purpose: Demonstrate the ability to create graphics objects
 * with the use of a Graphical User Interface
 ******************************************************************************/

package project;

import javax.swing.*;
import java.awt.*;

public class CMIS242DesignPRJ3BryanD {

  /**
   * Abstract Shape class
   */
  public static abstract class Shape extends Rectangle {
    private final Color color;
    private final boolean solid;
    private static int count;

    public Shape(Rectangle rectangle, Color color, boolean solid) {
      super(rectangle);
      this.color = color;
      this.solid = solid;
      // ensure that width and height are less than 200 for increment of shape
      if (rectangle.width < 200 && rectangle.height < 200) {
        Shape.count++;
      } // end if statement
    } // end Shape constructor

    /**
     * sets the color for the current shape
     * @param g GRAPHICS graphic object
     */
    public void setColor(Graphics g) {
      g.setColor(this.color);
    } // end setColor method

    /**
     * checks to see if shape is solid
     * @return BOOLEAN true/false
     */
    public boolean getSolid() {
      return this.solid == true ? true : false;
    } // end getSolid method

    /**
     * Gets the total number of shapes made so far
     * @return INT number of shapes
     */
    public static int getNumberOfShapes() {
      return Shape.count;
    }

    // draw method for parameters of graphics object
    public abstract void draw(Graphics g);

  } // end abstract class Shape

  /**
   * Oval class
   */
  public static class Oval extends Shape {

    public Oval(Rectangle rectangle, Color color, boolean solid) {
      super(rectangle, color, solid);
    } // end Oval constructor

    @Override
    public void draw(Graphics g) {
      g.drawOval(this.x, this.y, this.width, this.height);
      g.setColor(super.color);
      // if oval is solid
      if (super.getSolid()) {
        g.fillOval(this.x, this.y, this.width, this.height);
      } // end if statement
    } // end draw oval method

  } // end Oval class

  /**
   * Rectangular class
   */
  public static class Rectangular extends Shape {

    public Rectangular(Rectangle rectangle, Color color, boolean solid) {
      super(rectangle, color, solid);
    } // end rectangular constructor

    @Override
    public void draw(Graphics g) {
      g.drawRect(this.x, this.y, this.width, this.height);
      g.setColor(super.color);
      // if rectangle is solid
      if (super.getSolid()) {
        g.fillRect(this.x, this.y, this.width, this.height);
      } // end if statement
    } // end draw rectangular shape

  } // end Rectangular class

  /**
   * Drawing class
   */
  public static class Drawing extends JPanel {
    public ControllerLogic logic;
    private Shape shape;
    private int PREF_W = 200;
    private int PREF_H = PREF_W;
    private JLabel numberOfShapes = new JLabel("Shapes: 0", JLabel.LEFT);

    public Drawing(ControllerLogic logic, Shape shape) {
      this.logic = logic;
      this.shape = shape;
      setBackground(Color.LIGHT_GRAY);
      setBorder(BorderFactory.createTitledBorder("Shape Drawing"));
      setPreferredSize(new Dimension(PREF_W, PREF_H));
      add(numberOfShapes, 0);
    } // end Drawing constructor

    @Override
    protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      if (shape != null) {
        shape.draw(g);
      } // end if statement
    } // end paintComponent method

    @Override
    public Dimension getPreferredSize() {
      return new Dimension(PREF_W, PREF_H);
    } // end getPreferredSize method

    /**
     * draws a shape to the graphics pane
     * @param shape SHAPE current shape object
     * @throws OutsideBounds
     */
    public void drawShape(Shape shape) throws OutsideBounds {
      // if the shape or width is greater than 200
      if (shape.width > 200 || shape.height > 200) {
        OutsideBounds exception = new OutsideBounds("Outside Bounds: 200 x 200");
        JOptionPane.showMessageDialog(this,
                exception.getMessage(),
                "Error Creating Shape",
                JOptionPane.ERROR_MESSAGE);
        // if the shape, width, x coordinate, or y coordinate are not integers
      } else {
        Graphics g = this.getGraphics(); // create new graphics object
        g.dispose(); // dispose of old object
        shape.draw(g); // draw the shape
        numberOfShapes.setText("Shapes: " + shape.getNumberOfShapes());
        repaint();
      } // end if/else statement
    } // end drawShape method

  } // end Drawing class

  /**
   * OutsideBounds class
   */
  public static class OutsideBounds extends Exception {
    // TODO: fix the constructor for outside bounds to check for integer types
    //  to throw error upon user input in text fields

    /**
     * Creates a message constructor to alert user to exception
     * @param message STRING exception message
     */
    public OutsideBounds(String message) {
      super(message);
    } // end OutsideBounds Message Constructor

  } // end OutsideBounds class

  /**
   * Button Panel class
   */
  public static class ButtonPanel extends JPanel {
    public ControllerLogic logic;
    private GridLayout buttonLayout = new GridLayout(1, 3);
    private Button drawBtn = new Button("Draw");
    private Button clearFieldsBtn = new Button("Clear Fields");
    private Button exitBtn = new Button("Exit");

    public ButtonPanel(ControllerLogic logic) {
      this.logic = logic;
      setLayout(buttonLayout);
      setBackground(Color.LIGHT_GRAY);
      setPreferredSize(new Dimension(400, 50));
      add(drawBtn, 0);
      add(clearFieldsBtn, 1);
      add(exitBtn, 2);

      // draw button action event listener
      drawBtn.addActionListener(e -> {
        // get the string values of combo boxes
        String typeOfShape = logic.userInputPanel.shapeTypeBox.getSelectedItem().toString();
        String fillTypeSelection = logic.userInputPanel.fillTypeBox.getSelectedItem().toString();
        String colorTypeSelection = logic.userInputPanel.colorBox.getSelectedItem().toString();
        // convert values to usable objects
        Color colorType = getColor(colorTypeSelection);
        boolean isSolid = (fillTypeSelection.equalsIgnoreCase("solid")) ? true : false;
        // get integer values from input
        // TODO: create a try catch block to create exception for non integer values
        try {
          int widthValue =
                  checkForErrors(
                          logic.userInputPanel.widthTextField.getText(), "Width must be an Integer");
          int heightValue =
                  checkForErrors(
                          logic.userInputPanel.heightTextField.getText(), "Height must be an Integer");
          int xCoordinateValue =
                  checkForErrors(
                          logic.userInputPanel.xCoordinateTextField.getText(),
                          "X Coordinate must be an Integer");
          int yCoordinateValue =
                  checkForErrors(
                          logic.userInputPanel.yCoordinateTextField.getText(),
                          "Y Coordinate must be an Integer");
          // create the shape object and paint to screen
          Shape currentShape = createNewShape(typeOfShape,
                  colorType, isSolid, widthValue, heightValue, xCoordinateValue, yCoordinateValue);
          logic.drawing.shape = currentShape;
          logic.drawing.drawShape(currentShape);
        } catch (OutsideBounds err) {
          JOptionPane.showMessageDialog(logic,
                  err.getMessage(),
                  "Error Creating Shape",
                  JOptionPane.ERROR_MESSAGE);
        }

      }); // end draw button event listener
      // clear fields action listener
      clearFieldsBtn.addActionListener(e -> {
        // reset the user input fields
        resetFields(logic);
      }); // end clear fields button event listener
      // exit button action listener
      exitBtn.addActionListener(e -> {
        // end the program
        System.exit(0);
      }); // end exit button event listener

    } // end ButtonPanel constructor

    /**
     * Creates a new Shape object to be used for painting
     * @param typeOfShape STRING type of shape
     * @param color COLOR type of Color
     * @param fillType BOOLEAN solid/hollow
     * @param width INT width of object
     * @param height INT height of object
     * @param xCoordinate INT x coordinate on plane
     * @param yCoordinate INT y coordinate on plane
     * @return SHAPE new shape object
     */
    private Shape createNewShape(String typeOfShape,
                                 Color color,
                                 boolean fillType,
                                 int width,
                                 int height,
                                 int xCoordinate,
                                 int yCoordinate) {
      Shape shape = null;
      Rectangle rectangle = new Rectangle(xCoordinate, yCoordinate, width, height);
      // check to see if shape is oval
      if (typeOfShape.equalsIgnoreCase("oval")) {
        shape = new Oval(rectangle, color, fillType);
      } else {
        shape = new Rectangular(rectangle, color, fillType);
      } // end if/else

      return shape;
    } // end createNewShape method

    /**
     * Converts the string representation to a color object
     * @param color STRING color
     * @return COLOR Object
     */
    private Color getColor(String color) {
      Color newColor = null;
      switch (color.toLowerCase()) {
        case "black":
          newColor = Color.BLACK;
          break;
        case "red":
          newColor = Color.RED;
          break;
        case "orange":
          newColor = Color.ORANGE;
          break;
        case "yellow":
          newColor = Color.YELLOW;
          break;
        case "green":
          newColor = Color.GREEN;
          break;
        case "blue":
          newColor = Color.BLUE;
          break;
        case "magenta":
          newColor = Color.MAGENTA;
          break;
      } // end switch
      return newColor;
    } // end getColor method

    /**
     * Reset the text fields to their original settings
     * @param logic CONTROLLERLOGIC logic middleware
     */
    private void resetFields(ControllerLogic logic) {
      logic.userInputPanel.shapeTypeBox.setSelectedIndex(0);
      logic.userInputPanel.fillTypeBox.setSelectedIndex(0);
      logic.userInputPanel.colorBox.setSelectedIndex(0);
      logic.userInputPanel.widthTextField.setText("");
      logic.userInputPanel.heightTextField.setText("");
      logic.userInputPanel.xCoordinateTextField.setText("");
      logic.userInputPanel.yCoordinateTextField.setText("");
    } // end resetFields method

    /**
     * Check for errors when parsing integers
     * @param userInput STRING users input from the program
     * @param message STRING message to display to user
     * @return INT successfully parsed integer
     */
    private int checkForErrors(String userInput, String message) throws OutsideBounds {
      int currentUserInput = 0;
      try {
        currentUserInput = Integer.parseInt(userInput);
      } catch (NumberFormatException e) {
        throw new OutsideBounds(message);
      } // end try/catch
      return currentUserInput;
    } // end checkForErrors method

  } // end ButtonPanel class

  /**
   * User Input Panel class
   */
  public static class UserInputPanel extends JPanel {
    public ControllerLogic logic;
    private GridLayout userInputLayout = new GridLayout(7, 2);
    private JLabel shapeTypeLabel = new JLabel("Shape Type", JLabel.CENTER);
    private JLabel fillTypeLabel = new JLabel("Fill Type", JLabel.CENTER);
    private JLabel colorLabel = new JLabel("Color", JLabel.CENTER);
    private JLabel widthLabel = new JLabel("Width", JLabel.CENTER);
    private JLabel heightLabel = new JLabel("Height", JLabel.CENTER);
    private JLabel xCoordinateLabel = new JLabel("X Coordinate", JLabel.CENTER);
    private JLabel yCoordinateLabel = new JLabel("Y Coordinate", JLabel.CENTER);
    private JTextField widthTextField = new JTextField("");
    private JTextField heightTextField = new JTextField("");
    private JTextField xCoordinateTextField = new JTextField("");
    private JTextField yCoordinateTextField = new JTextField("");
    private String[] shapeOptions = { "Oval", "Rectangle" };
    private String[] fillOptions = { "Hollow", "Solid" };
    private String[] colorOptions = { "Black", "Red", "Orange", "Yellow", "Green", "Blue", "Magenta" };
    private JComboBox shapeTypeBox = new JComboBox(shapeOptions);
    private JComboBox fillTypeBox = new JComboBox(fillOptions);
    private JComboBox colorBox = new JComboBox(colorOptions);

    public UserInputPanel(ControllerLogic logic) {
      this.logic = logic;
      setLayout(userInputLayout);
      setBackground(Color.LIGHT_GRAY);
      setPreferredSize(new Dimension(200, 200));
      add(shapeTypeLabel, 0);
      add(shapeTypeBox, 1);
      add(fillTypeLabel, 2);
      add(fillTypeBox, 3);
      add(colorLabel, 4);
      add(colorBox, 5);
      add(widthLabel, 6);
      add(widthTextField, 7);
      add(heightLabel, 8);
      add(heightTextField, 9);
      add(xCoordinateLabel, 10);
      add(xCoordinateTextField, 11);
      add(yCoordinateLabel, 12);
      add(yCoordinateTextField, 13);
    } // end UserInputPanel constructor

  } // end UserInputPanel class

  /**
   * Controller Logic class
   */
  public static class ControllerLogic extends JPanel {
    Shape shape = null;
    BorderLayout logicLayout = new BorderLayout();
    ButtonPanel buttonPanel = new ButtonPanel(this);
    UserInputPanel userInputPanel = new UserInputPanel(this);
    Drawing drawing = new Drawing(this, shape);

    public ControllerLogic() {
      setLayout(logicLayout);
      setBackground(Color.LIGHT_GRAY);
      setPreferredSize(new Dimension(400, 450));
      add(userInputPanel, BorderLayout.WEST);
      add(drawing, BorderLayout.EAST);
      add(buttonPanel, BorderLayout.SOUTH);
    } // end ControllerLogic constructor

  } // end ControllerLogic class

  public static class ProgramCore extends JFrame {
    ControllerLogic logic = new ControllerLogic();

    public ProgramCore() {
      super("Geometric Drawings");
      setFrame(400, 450);
      addComponents();
    } // end ProgramCore constructor

    private void addComponents() {
      add(logic);
    } // end addComponents method

    private void setFrame(int width, int height) {
      setSize(width, height);
      setLocationRelativeTo(null);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    } // end setFrame method

  } // end ProgramCore class

  public static void main(String[] args) {
    ProgramCore frame = new ProgramCore();
    frame.setVisible(true);
  } // end main method

} // end CMIS242DesignPRJBryanD
