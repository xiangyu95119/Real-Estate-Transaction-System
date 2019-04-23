/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.useraccount;
import business.employee.Employee;
import business.role.Role;
import business.workqueue.Workqueue;
import java.util.ArrayList;
/**
 *
 * @author wenhaofeng
 */
public class UserAccount {
    
    private String username;
    private String password;
    private Employee employee;
    private Role role;
    private Workqueue workQueue;
    private ArrayList<Integer> scoreList;
    private Float score;

    public UserAccount() {
        workQueue = new Workqueue();
        scoreList = new ArrayList<Integer>();
    }
    
    public Float getScore() {
        if(scoreList.size()==0){
            return 0.0f;
        }else{
            int sum =0;
            for(int i =0;i<scoreList.size();i++){
                sum =sum + scoreList.get(i);
            }
            return (float)sum/scoreList.size();
        }
    }

    public ArrayList<Integer> getScoreList() {
        return scoreList;
    }
    
    
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Employee getEmployee() {
        return employee;
    }

    public Workqueue getWorkqueue() {
        return workQueue;
    }

    
    
    @Override
    public String toString() {
        return username;
    }
    
    
    
}