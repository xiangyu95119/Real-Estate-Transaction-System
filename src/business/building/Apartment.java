/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.building;

/**
 *
 * @author haowenchang
 */
public class Apartment{
    //private String number;
    private long price;
    private String roompic;
    private int bed;
    private int bath;
    private int lel;
    private int num;
    private String id;
    //private int[][] roomnum;
    //private boolean cap;
    private String owner;
    private String salesman;
    
    public Apartment(int i, int j, String name){
        owner = name;
        lel = i;
        num = j;
        id = i + "-" + j;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getRoompic() {
        return roompic;
    }

    public void setRoompic(String roompic) {
        this.roompic = roompic;
    }

    public int getBed() {
        return bed;
    }

    public void setBed(int bed) {
        this.bed = bed;
    }

    public int getBath() {
        return bath;
    }

    public void setBath(int bath) {
        this.bath = bath;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setLel(int lel) {
        this.lel = lel;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getLel() {
        return lel;
    }

    public int getNum() {
        return num;
    }

    public String getSalesman() {
        return salesman;
    }

    public void setSalesman(String salesman) {
        this.salesman = salesman;
    }

    @Override
    public String toString() {
        return id;
    }
    
}
