import java.util.ArrayList;

/**
 * @author Samuel Khang
 * @version 1.0
 * The Store class represents a store that sells a collection of Dessert objects.
 * It provides methods to manage and search through the desserts in the store.
 */
public class Store {
    private String name;
    private ArrayList<Dessert> desserts;
    /**
     * Constructs a Store with the specified name and initializes an empty list of desserts.
     * @param name the name of the store
     */
    public Store(String name) {
        this.name = name;
        this.desserts = new ArrayList<>();
    }
    /**
     * Adds a dessert to the list of desserts in the store.
     * @param o the Dessert to add to the store
     */
    public void addDessert(Dessert o) {
        desserts.add(o);
    }
    /**
     * Removes the first occurrence of a dessert in the store's list that is equal to the specified dessert.
     * @param o the Dessert to remove from the store
     * @return the removed Dessert if found, otherwise returns null
     */
    public Dessert removeDessert(Dessert o) {
        for (int i = 0; i < desserts.size(); ++i) {
            if (o.equals(desserts.get(i))) {
                return desserts.remove(i);
            }
        }
        return null;
    }
    /**
     * Finds a dessert in the store's list that is equal to the specified dessert, using binary search.
     * Assumes the desserts are sorted in ascending order.
     * @param o the Dessert to search for
     * @return the Dessert found in the store if present, otherwise returns null
     */
    public Dessert findDessert(Dessert o) {
        int low = 0;
        int high = desserts.size() - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (desserts.get(mid).equals(o)) {
                return desserts.get(mid);
            }
            if (desserts.get(mid).compareTo(o) > 0) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return null;
    }
    /**
     * Sorts the store's list of desserts in ascending order based on sweetness and then flavor.
     */
    public void sortStore() {
        for (int i = 1; i < desserts.size(); ++i) {
            Dessert currentElement = desserts.get(i);
            int j;
            for (j = i - 1; j >= 0 && desserts.get(j).compareTo(currentElement) > 0; j--) {
                desserts.set(j + 1, desserts.get(j));
            }
            desserts.set(j + 1, currentElement);
        }
    }
    /**
     * Counts the number of desserts in the store that are greater than or equal to the specified dessert.
     *
     * @param o the Dessert to compare against
     * @return the number of desserts greater than or equal to the specified dessert
     */
    public int countGreaterDesserts(Dessert o) {
        int count = 0;
        for (int i = 0; i < desserts.size(); ++i) {
            if (desserts.get(i).compareTo(o) >= 0) {
                count++;
            }
        }
        return count;
    }
    /**
     * Displays the store's menu by printing the store's name and list of available desserts.
     */
    public void showMenu() {
        System.out.printf("%s's Menu of the Day:%n", name);
        for (Dessert o : desserts) {
            System.out.println(o.toString());
        }
    }
    /**
     * Returns the list of desserts in the store.
     *
     * @return the list of desserts in the store
     */
    public ArrayList<Dessert> getDesserts() {
        return desserts;
    }
}
