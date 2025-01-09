/**
 * @author Samuel Khang
 * @version 1.0
 * The IceCream class represents a specific type of Dessert with additional attributes
 * such as the number of scoops and whether it is served in a cone.
 * This class extends Dessert.
 */
public class IceCream extends Dessert {
    private int scoops;
    private boolean cone;

    /**
     * Constructs an IceCream object with the specified flavor, sweetness, scoops, and cone.
     * @param flavor   the flavor of the ice cream
     * @param sweetness the sweetness level of the ice cream
     * @param scoops   the number of scoops in this ice cream
     * @param cone     true if the ice cream has a cone, false otherwise
     */
    public IceCream(String flavor, double sweetness, int scoops, boolean cone) {
        super(flavor, sweetness);
        this.scoops = scoops;
        this.cone = cone;
    }
    /**
     * Constructs an IceCream object with specified scoops and cone status.
     * The default flavor is "vanilla" and sweetness is 45.0.
     * @param scoops the number of scoops in this ice cream
     * @param cone   true if the ice cream has a cone, false otherwise
     */
    public IceCream(int scoops, boolean cone) {
        this("vanilla", 45.0, scoops, cone);
    }
    /**
     * Constructs a default IceCream object with flavor "vanilla", sweetness 45.0,
     * 1 scoop, and no cone.
     */
    public IceCream() {
        this("vanilla", 45.0, 1, false);
    }
    /**
     * Returns a string representation of the IceCream.
     * The format is: "{flavor} ice cream with {scoops} scoops and {has/does not have} a cone."
     * @return a string representation of this IceCream
     */
    @Override
    public String toString() {
        return String.format("%s ice cream with %d scoops and %s a cone.",
                getFlavor(), scoops, cone ? "has" : "does not have");
    }
    /**
     * Checks if this IceCream is equal to another object.
     * Two ice creams are considered equal if they have the same flavor, sweetness, scoops, and cone.
     * @param o the object to compare to this IceCream
     * @return true if the specified object is equal to this IceCream, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (o == null || !this.getClass().equals(o.getClass())) {
            return false;
        }
        IceCream other = (IceCream) o;
        return this.getFlavor().equals(other.getFlavor()) && this.getSweetness() == other.getSweetness()
                && this.scoops == other.scoops && this.cone == other.cone;
    }

}
