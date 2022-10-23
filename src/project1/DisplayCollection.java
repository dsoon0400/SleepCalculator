// Virginia Tech Honor Code Pledge:

//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Your name (dsoon0400)

package project1;

import bag.Bag;
import bag.BagInterface;
import java.util.Random;

/**
 * Takes cares of the bags to be displayed.
 *
 * @author David Soon
 * @version 2022.09.09
 */

public class DisplayCollection {
    /**
     * STRINGS is used to contain the four different strings
     * that the itemBag should contain.
     */
    public static final String[] STRINGS = { "red circle", "blue circle",
        "red square", "blue square" };
    private BagInterface<String> itemBag;

    /**
     * Constructs DisplayCollection object
     */
    public DisplayCollection() {
        itemBag = new Bag<>();
        Random random = new Random();
        int size = random.nextInt(11) + 5;
        for (int i = 0; i < size; i++) {
            itemBag.add(STRINGS[random.nextInt(4)]);
        }
    }


    /**
     * Returns itemBag
     * 
     * @return The Item Bag
     */
    public BagInterface<String> getItemBag() {
        return itemBag;
    }

}
