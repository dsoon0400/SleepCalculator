// Virginia Tech Honor Code Pledge:

//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Your name (dsoon0400)

package project1;

import bag.BagInterface;
import cs2.TextShape;
import cs2.Window;
import cs2.Button;
import cs2.WindowSide;
import java.awt.Color;
import java.util.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * The GUI for the project.
 *
 * @author David Soon
 * @version 2022.09.09
 */

public class ShapeWindow {
    private Window window;
    private TextShape textShape;
    private TextShape counterText;
    private Button quitButton;
    private Button chooseButton;
    private Button plusOne;
    private Button test;
    private Button input;
    private Button sleepCalc;
    private BagInterface<String> itemBag;
    private int counter;
    final JFrame frame = new JFrame();
// private List<TextShape> list;
// frame
    final JFrame f = new JFrame("List");
    // lists
    private JList<String> theList;
    // panel
    private JPanel panel;
    private JLabel label;

    /**
     * Constructs ShapeWindow object
     * 
     * @param theItemBag
     *            Bag of items to be displayed
     */
    public ShapeWindow(BagInterface<String> theItemBag) {
        window = new Window(); // Sets up window
        window.setTitle("David's Playground");
        itemBag = theItemBag; // Bag of items
        quitButton = new Button("Quit"); // Quit button
        quitButton.onClick(this, "clickedQuit");
        window.addButton(quitButton, WindowSide.NORTH);
        chooseButton = new Button("Choose"); // Choose button
        chooseButton.onClick(this, "clickedChoose");
        window.addButton(chooseButton, WindowSide.SOUTH);
        plusOne = new Button("+1"); // PlusOne button
        plusOne.onClick(this, "clickedPlusOne");
        window.addButton(plusOne, WindowSide.EAST);
        input = new Button("Input"); // input button
        input.onClick(this, "clickedInput");
        window.addButton(input, WindowSide.EAST);
        test = new Button("Test"); // Test button
        test.onClick(this, "clickedTest");
        window.addButton(test, WindowSide.EAST);
        sleepCalc = new Button("SleepCalc"); // SleepCalc button
        sleepCalc.onClick(this, "clickedSleepCalc");
        window.addButton(sleepCalc, WindowSide.EAST);
        textShape = new TextShape(0, 0, ""); // Textshape for itembag
        window.addShape(textShape);
        counterText = new TextShape(0, 0, "0"); // Textshape for counter
        window.addShape(counterText);
        counter = 0; // Sets up counter
// list = new ArrayList<TextShape>(); // List of textshapes.
        theList = new JList<String>();
        panel = new JPanel();
        label = new JLabel();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Makes sure
                                                                 // frame closes
    }


    /**
     * Exit application when quit button is hit.
     * 
     * @param button
     *            the quit button
     */
    public void clickedQuit(Button button) {
        System.exit(0);
    }


    /**
     * Displays text after clicking choose button.
     * 
     * @param button
     *            the choose button
     */
    public void clickedChoose(Button button) {
        if (itemBag.getCurrentSize() == 0) {
            textShape.setText("No more items.");
        }
        else {
            textShape.setText(itemBag.remove());
        }
        colorText();
        centerText();
    }


    /**
     * Adds one to a counter
     * 
     * @param button
     *            The plusOne button
     */
    public void clickedPlusOne(Button button) {
        counter++;
        counterText.setText(String.valueOf(counter));
    }


    /**
     * Name input
     * 
     * @param button
     *            input button
     */
    public void clickedInput(Button button) {
        String name = JOptionPane.showInputDialog("What is your name?");
        if (name != null) {
            if (name.equals("")) {
                JOptionPane.showMessageDialog(frame, "Please input a name!");
                this.clickedInput(button);
            }
            else {
                JOptionPane.showMessageDialog(frame, "Hello " + name + '!');
            }
        }
    }


    /**
     * Calculate next time to sleep for optimal rest.
     * 
     * @param button
     *            SleepCalc button
     */
    public void clickedSleepCalc(Button button) {
        String currentTime = JOptionPane.showInputDialog(
            "What time is it right now? (Army Time 'HHMM')");
        if (currentTime != null) {
            if (currentTime.equals("")) {
                JOptionPane.showMessageDialog(frame, "Please input a time!");
                this.clickedSleepCalc(button);
            }
            else {
                String wakeTime = JOptionPane.showInputDialog(
                    "When do you want to wake up? (Army Time 'HHMM')");
                if (wakeTime != null) {
                    while (wakeTime.equals("")) {
                        JOptionPane.showMessageDialog(frame,
                            "Please input a time!");
                        wakeTime = JOptionPane.showInputDialog(
                            "When do you want to wake up? (Army Time 'HHMM')");
                    }

                    int timeBetween = 0;
                    if (Integer.valueOf(currentTime) >= Integer.valueOf(
                        wakeTime)) {
                        int wakey = Integer.valueOf(wakeTime) + 2400;
                        int current = Integer.valueOf(currentTime);
                        timeBetween = wakey - current;
                    }
                    else {
                        timeBetween = Integer.valueOf(wakeTime) - Integer
                            .valueOf(currentTime);
                    }
                    int minutes = timeBetween % 100;
                    int hours = (int)(timeBetween / 100);
                    int totalMinutes = minutes + hours * 60;
                    int cyclesPossible = (int)((totalMinutes - 150) / 90) + 1;
                    int sleepTime = 120 + (cyclesPossible - 1) * 90;
                    int sleepTimeMinutes = sleepTime % 60;
                    int sleepTimeHours = (int)(sleepTime / 60);
                    int wakeMinutes = Integer.valueOf(wakeTime) % 100;
                    int wakeHours = (int)(Integer.valueOf(wakeTime) / 100);
                    int wakeTotalMinutes = wakeMinutes + wakeHours * 60;
                    int sleepStart = wakeTotalMinutes - sleepTime - 30;
                    if (sleepStart < 0) {
                        sleepStart = (24 * 60) + sleepStart;
                    }
                    int sleepMinutes = sleepStart % 60;
                    int sleepHours = (int)(sleepStart / 60);
                    sleepTime = sleepHours * 100 + sleepMinutes;
                    String theSleepTime = Integer.toString(sleepTime);
                    while (theSleepTime.length() < 4) {
                        theSleepTime = "0" + theSleepTime;
                    }
                    JOptionPane.showMessageDialog(frame, "Head to bed at: "
                        + theSleepTime + ", for " + sleepTimeHours
                        + " hours and " + sleepTimeMinutes
                        + " minutes of sleep.");

                }

            }
        }
    }


    /**
     * Test method for test button
     * 
     * @param button
     *            test button
     */
    public void clickedTest(Button button) {
        String test = JOptionPane.showInputDialog("Enter Task:");
        if (test != null) {
            if (test.equals("")) {
                JOptionPane.showMessageDialog(frame, "Please enter a task!");
                this.clickedTest(button);
            }
            else {
// JOptionPane.showMessageDialog(frame, "Hello " + test + '!');
                TextShape newTask = new TextShape(0, 0, test);
                window.addShape(newTask);
                newTask.moveTo(window.getGraphPanelWidth() / 2 - newTask
                    .getWidth() / 2, window.getGraphPanelHeight() / 2 - newTask
                        .getHeight() / 2);
                if (newTask.getText().contains("red")) {
                    newTask.setForegroundColor(Color.RED);
                }
                else if (newTask.getText().contains("blue")) {
                    newTask.setForegroundColor(Color.BLUE);
                }
                else {
                    newTask.setForegroundColor(Color.BLACK);
                }
                counter++;
                counterText.setText(String.valueOf(counter));
            }
        }
    }


    /**
     * Sets color of text
     */
    private void colorText() {
        if (textShape.getText().contains("red")) {
            textShape.setForegroundColor(Color.RED);
        }
        else if (textShape.getText().contains("blue")) {
            textShape.setForegroundColor(Color.BLUE);
        }
        else {
            textShape.setForegroundColor(Color.BLACK);
        }
    }


    /**
     * Centers the text
     */
    private void centerText() {
        textShape.moveTo(window.getGraphPanelWidth() / 2 - textShape.getWidth()
            / 2, window.getGraphPanelHeight() / 2 - textShape.getHeight() / 2);
    }
}
