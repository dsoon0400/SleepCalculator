// Virginia Tech Honor Code Pledge:

//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Your name (dsoon0400)

package project1;

import student.TestCase;
import bag.BagInterface;

/**
 * Tests DisplayCollection class.
 *
 * @author David Soon
 * @version 2022.09.13
 */

public class DisplayCollectionTest extends TestCase {
    /**
     * Constructs DisplayCollectionTest
     */
    public DisplayCollectionTest() {
        // Nothing to construct
    }


    /**
     * Sets up for methods
     */
    public void setUp() {
        // Empty as there are no fields.
    }


    /**
     * Tests bagContents()
     */
    public void testBagContents() {
        DisplayCollection collection = new DisplayCollection();
        BagInterface<String> bag = collection.getItemBag();
        for (int i = 0; i < bag.getCurrentSize(); i++) {
            String check = bag.remove();
            assertTrue((check.equals(DisplayCollection.STRINGS[0])) || (check
                .equals(DisplayCollection.STRINGS[1])) || (check.equals(
                    DisplayCollection.STRINGS[2])) || (check.equals(
                        DisplayCollection.STRINGS[3])));
        }
    }


    /**
     * Tests bagSize()
     */
    public void testBagSize() {
        for (int i = 0; i < 20; i++) {
            DisplayCollection collection = new DisplayCollection();
            BagInterface<String> bag = collection.getItemBag();
            assertTrue((5 <= bag.getCurrentSize()) && (bag
                .getCurrentSize() <= 15));
        }

    }
}
