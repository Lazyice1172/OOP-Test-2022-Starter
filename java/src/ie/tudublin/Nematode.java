package ie.tudublin;

import processing.data.TableRow;

public class Nematode {
    private String name;
    private int length;
    private String limbs;
    private String gender;
    private String eyes;

    @Override
    public String toString() {
        return "Roundworms [name=" + name + ", length=" + length + ", limbs=" + limbs + ", gender=" + gender
                + ", eyes=" + eyes + "]";
    }

    public Nematode(String name, int length, String limbs, String gender, String eyes) {
        this.name = name;
        this.length = length;
        this.limbs = limbs;
        this.gender = gender;
        this.eyes = eyes;
    }

    public Nematode(TableRow tr) {
        this(
                tr.getString("name"),
                tr.getInt("length"),
                tr.getString("limbs"),
                tr.getString("gender"),
                tr.getString("eyes")
        );
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getLimbs() {
        return limbs;
    }

    public void setLimbs(String limbs) {
        this.limbs = limbs;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEyes() {
        return eyes;
    }

    public void setEyes(String eyes) {
        this.eyes = eyes;
    }
}
