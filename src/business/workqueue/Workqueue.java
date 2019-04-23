/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.workqueue;

import java.util.ArrayList;

/**
 *
 * @author wenhaofeng
 */
public class Workqueue {
    private ArrayList<WorkRequest> workRequestList;

    public Workqueue() {
        workRequestList = new ArrayList();
    }

    public ArrayList<WorkRequest> getWorkRequestList() {
        return workRequestList;
    }
}
