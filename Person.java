public class Person {
    /**
     * Attribute
     */
    protected String name;
    protected String vorname;

    public Person() {}

    public Person(String name, String vorname) {
        this.name = name;
        this.vorname = vorname;
    }

    public String getName() {
        return name;
    }

    public void setName(String n) {
        name = n;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vn) {
        vorname = vn;;
    }

    public void ausgeben() {
        System.out.println(name + ", " + vorname);
    }

    public String toString() {
        return name + ", " + vorname;
    }
}