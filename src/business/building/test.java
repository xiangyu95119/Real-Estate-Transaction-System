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
public class test {
    public static void main(String[] args){
        BuildingDirectory bdd = new BuildingDirectory();
        Building bd = bdd.createbuilding("108hem", 5, 12);
        bd.orderapartment(2, 12 ,"jim");
        bd.orderapartment(1, 11 ,"john");
        /*for(int i = 0; i < bd.getApartmentlist().length; i++){
            for(int j = 0; j < bd.getApartmentlist()[0].length; j++){
                if(bd.getApartmentlist()[i][j]){
                    System.out.print((i+1)+" "+(j+1)+" ");
                    //System.out.println(bd.getApartmentlist()[i][j].getOwner());
                    //bd.getApartmentlist().remove(j);
                }
            }
        }*/
        System.out.println("occupied");
        for(Apartment a : bd.getApartmentlist()){
            System.out.println(a.getLel()+" "+a.getNum()+" "+a.getOwner());
        }
        
        System.out.println("not yet");
        System.out.println(bd.getAvailability().length);
        System.out.println(bd.getAvailability()[0].length);
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 12; j++){
                if(!bd.getAvailability()[i][j]){
                    System.out.println((i+1)+" "+(j+1));
                }
            }
        }

    }
}
