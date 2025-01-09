import java.util.ArrayList;
/**
 * @author Samuel Khang
 * @version 1.0
 * The Bob class contains static methods that interact with Store objects
 * to find and compare desserts across multiple stores.
 */

public class Bob {

    /**
     * Compares two stores to determine if all desserts in the first store are also found in the second store.
     * Assumes that desserts in store2 are sorted in ascending order.
     * @param store1 the first Store object
     * @param store2 the second Store object
     * @return true if all desserts in store1 are found in store2, false otherwise
     */
    public static boolean compareStores(Store store1, Store store2) {
        store1.sortStore();
        for (Dessert dessert : store1.getDesserts()) {
            if (store2.findDessert(dessert) == null) {
                return false;
            }
        }
        return true;
    }
    /**
     * Checks if a specified dessert is available in a given store.
     * The store's desserts are sorted before searching.
     * @param o the Store object to search in
     * @param a the Dessert object to look for
     * @return true if the dessert is found in the store, false otherwise
     */
    public static boolean shop(Store o, Dessert a) {
        o.sortStore();
        return o.findDessert(a) != null;
    }
    /**
     * Finds all stores from a list that contain a specified dessert.
     * @param stores the list of Store objects to search through
     * @param target the Dessert object to look for
     * @return an ArrayList of Store objects containing the target dessert
     */
    public static ArrayList<Store> findAvailableStores(ArrayList<Store> stores, Dessert target) {
        ArrayList<Store> availableStores = new ArrayList<>();
        for (Store store : stores) {
            if (store.findDessert(target) != null) {
                availableStores.add(store);
            }
        }
        return availableStores;
    }
}
