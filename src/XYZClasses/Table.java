/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package XYZClasses;

/**
 *
 * @author us
 */
public class Table {
    private String tableid;
    private int capacity;
    private double bprice;

    public Table(String tableid, int capacity, double bprice) {
        this.tableid = tableid;
        this.capacity = capacity;
        this.bprice = bprice;
    }

    public String getTableid() {
        return tableid;
    }

    public void setTableid(String tableid) {
        this.tableid = tableid;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public double getBprice() {
        return bprice;
    }

    public void setBprice(double bprice) {
        this.bprice = bprice;
    }
    
    
}
