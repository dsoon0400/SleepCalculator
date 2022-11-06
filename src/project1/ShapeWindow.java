package project1;

import cs2.Window;
import cs2.Button;
import cs2.WindowSide;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * The GUI for the project.
 *
 * @author David Soon
 * @version 2022.09.09
 */

public class ShapeWindow {
    private Window window;
    private Button quitButton;
    private Button sleepCalc;
    final JFrame frame = new JFrame();

    /**
     * Constructs ShapeWindow object
     * 
     * @param theItemBag
     *            Bag of items to be displayed
     */
    public ShapeWindow() {
        window = new Window(); // Sets up window
        window.setTitle("Playground");
        quitButton = new Button("Quit"); // Quit button
        quitButton.onClick(this, "clickedQuit");
        window.addButton(quitButton, WindowSide.NORTH);
        sleepCalc = new Button("SleepCalc"); // SleepCalc button
        sleepCalc.onClick(this, "clickedSleepCalc");
        window.addButton(sleepCalc, WindowSide.EAST);
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
                    else if (Integer.valueOf(wakeTime) % 100 == 0){
                        timeBetween = Integer.valueOf(wakeTime) - 40 - Integer
                            .valueOf(currentTime);
                    } else {
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
                    theSleepTime = theSleepTime.substring(0, 2) + ":" + theSleepTime.substring(2,4);
                    JOptionPane.showMessageDialog(frame, "Head to bed at: "
                        + theSleepTime + ", for " + sleepTimeHours
                        + " hours and " + sleepTimeMinutes
                        + " minutes of sleep.");

                }

            }
        }
    }

}
