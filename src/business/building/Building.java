/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.building;

import java.util.ArrayList;

/**
 *
 * @author haowenchang
 */
public class Building {
    private String Address;
    private long cost;
    private String pic;
    private String name;
    private int level;
    private int npl;
    //private Apartment[][] apartmentlist;
    private boolean[][] availability;
    private int id;
    //private static int count = 0;
    private ArrayList<Apartment> apartmentlist;
    private String agent;
    //private String status;

    public Building(int level, int npl) {
        apartmentlist = new ArrayList();
        //id = count;
        //count++;
        this.npl = npl;
        this.level = level;
        //apartmentlist = new Apartment[level][npl];
        availability = new boolean[level][npl];
        for(int i = 0; i < level; i++){
            for(int j = 0; j < npl; j++){
                Apartment a = new Apartment(i+1,j+1,"");
                apartmentlist.add(a);
            }
        }
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public long getCost() {
        return cost;
    }

    public void setCost(long cost) {
        this.cost = cost;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getNpl() {
        return npl;
    }

    public void setNpl(int npl) {
        this.npl = npl;
    }

    public int getId() {
        return id;
    }

    public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        this.agent = agent;
    }

    public boolean[][] getAvailability() {
        return availability;
    }
    
    public void orderapartment(int i, int j, String name){
        availability[i-1][j-1] = true;
        Apartment a = new Apartment(i,j,name);
        apartmentlist.add(a);
    }

    public ArrayList<Apartment> getApartmentlist() {
        return apartmentlist;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return Address;
    }
    
}
