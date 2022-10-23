// Virginia Tech Honor Code Pledge:

//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Your name (dsoon0400)

package project1;

/**
 * Takes cares of the bags to be displayed.
 *
 * @author David Soon
 * @version 2022.09.11
 */

public class ProjectRunner {

    /**
     * Constructs ProjectRunner
     */
    public ProjectRunner() {
        // Nothing to construct
    }


    /**
     * Main method
     * 
     * @param args
     *            The argument
     */
    public static void main(String[] args) {
        DisplayCollection collection = new DisplayCollection();
        ShapeWindow window = new ShapeWindow(collection.getItemBag());
    }

}
