/**
 * @author Samuel Khang
 * @version 1.0
 * The Dessert class represents a generic dessert with properties such as flavor and sweetness.
 * This class implements Comparable to allow for sorting based on sweetness and flavor.
 * It is designed to be extended by specific types of desserts.
 */
public abstract class Dessert implements Comparable<Dessert> {
    private String flavor;
    private double sweetness;
    /**
     * Constructs a Dessert with the specified flavor and sweetness.
     * @param flavor    the flavor of the dessert
     * @param sweetness the sweetness level of the dessert
     */
    public Dessert(String flavor, double sweetness) {
        this.flavor = flavor;
        this.sweetness = sweetness;
    }
    /**
     * Constructs a Dessert with default flavor "vanilla" and sweetness 25.0.
     */
    public Dessert() {
        flavor = "vanilla";
        sweetness = 25.0;
    }
    /**
     * Returns the flavor of the dessert.
     * @return the flavor of the dessert
     */
    public String getFlavor() {
        return flavor;
    }
    /**
     * Returns the sweetness level of the dessert.
     * @return the sweetness level of the dessert
     */
    public double getSweetness() {
        return sweetness;
    }
    /**
     * Returns a string representation of the Dessert in the format:
     * "{flavor} dessert with a sweetness of {sweetness}".
     * @return a string representation of this Dessert
     */
    @Override
    public String toString() {
        return String.format("%s dessert with a sweetness of %.2f.", flavor, sweetness);
    }
    /**
     * Checks if this Dessert is equal to another object.
     * Two desserts are considered equal if they have the same flavor and sweetness.
     * @param o the object to compare to this Dessert
     * @return true if the specified object is equal to this Dessert, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (o == null || !this.getClass().equals(o.getClass())) {
            return false;
        }
        Dessert other = (Dessert) o;
        return this.flavor.equals(other.flavor) && this.sweetness == other.sweetness;
    }
    /**
     * Compares this Dessert to another Dessert for ordering.
     * Desserts are compared first by sweetness, and if sweetness is equal, by flavor.
     * @param o the Dessert to compare to
     * @return a negative integer, zero, or a positive integer as this Dessert is
     *         less than, equal to, or greater than the specified Dessert
     */
    @Override
    public int compareTo(Dessert o) {
        if (this.sweetness == o.sweetness) {
            return this.flavor.compareTo(o.flavor);
        }
        return Double.compare(this.sweetness, o.sweetness);
    }

}