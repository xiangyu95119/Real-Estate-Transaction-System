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
public class BuildingDirectory {
    private ArrayList<Building> buildinglist;
    private static int count = 0;
    
    public BuildingDirectory(){
        buildinglist = new ArrayList();
    }
    public void delBuilding(Building building){
    buildinglist.remove(building);
    }

    public ArrayList<Building> getBuildinglist() {
        return buildinglist;
    }
    public Building createbuilding(String address,int lel, int npl){
        Building building = new Building(lel,npl);
        count++;
        building.setId(count);
        building.setAddress(address);
        buildinglist.add(building);
        return building;
    }
}
