/**
 * @author Samuel Khang
 * @version 1.0
 * The Cake class represents a specific type of Dessert with additional attributes
 * specific to cakes, such as frosting.
 * This class extends Dessert.
 */
public class Cake extends Dessert {
    private String frosting;

    /**
     * Constructs a Cake object with the specified flavor, sweetness, and frosting.
     * @param flavor   the flavor of the cake
     * @param sweetness the sweetness level of the cake
     * @param frosting the type of frosting on the cake
     */
    public Cake(String flavor, double sweetness, String frosting) {
        super(flavor, sweetness);
        this.frosting = frosting;
    }
    /**
     * Constructs a Cake object with the specified flavor. Defaults sweetness to 45.0
     * and frosting to "vanilla".
     * @param flavor the flavor of the cake
     */
    public Cake(String flavor) {
        this(flavor, 45.0, "vanilla");
    }
    /**
     * Returns a string representation of the Cake.
     * The format is: "{flavor} cake with a {frosting} frosting and has a sweetness of {sweetness}."
     * @return a string representation of this Cake
     */
    @Override
    public String toString() {
        return String.format("%s cake with a %s frosting and has a sweetness of %.2f.",
        getFlavor(), frosting, getSweetness());
    }
    /**
     * Checks if this Cake is equal to another object.
     * Two cakes are considered equal if they have the same flavor, sweetness, and frosting.
     * @param o the object to compare to this Cake
     * @return true if the specified object is equal to this Cake, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (o == null || !this.getClass().equals(o.getClass())) {
            return false;
        }
        Cake other = (Cake) o;
        return this.getFlavor().equals(other.getFlavor())
                && this.getSweetness() == other.getSweetness() && this.frosting.equals(other.frosting);
    }
}
