/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edgeverve;

/**
 *
 * @author Sushanth Bangera
 */
class Employee {
    
    private int id  = 0;
    
    public Employee(int id) {
        this.setId(id);
    }

    public int getId() {
           return id;
    }

    public void setId(int id) {
           this.id = id;
    }  

    @Override
    public boolean equals(Object o) {
        Employee employee = (Employee) o;
        if (employee.getId() == this.getId()) {
            return true;
        }
        return false;
    }
 
    @Override
    public int hashCode() {
        return this.getId();
    }
      
}
