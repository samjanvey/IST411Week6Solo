/* 
Project: Lesson 6 - Solo Work
Purpose Details: Write Student Objects to JSON file and read back and display to console
Course: IST 411
Author: Sam Janvey
Date Developed: 2/25/20
Last Date Changed: 2/25/20
Revision: 3
*/
package jsonsolo;

public class Student {
    private String lName;
    private double GPA;
    private int currentCredits;
    private int totalCredits;
    private String fName;
    
    public Student(String fName, String lName, double gpa, int currCredit, int totalCredit) {
        this.fName = fName;
        this.lName = lName;
        this.GPA = gpa;
        this.currentCredits = currCredit;
        this.totalCredits = totalCredit;
    }
    
    public Student() {
        
    }

    /**
     * @return the lName
     */
    public String getlName() {
        return lName;
    }

    /**
     * @param lName the lName to set
     */
    public void setlName(String lName) {
        this.lName = lName;
    }

    /**
     * @return the GPA
     */
    public double getGPA() {
        return GPA;
    }

    /**
     * @param GPA the GPA to set
     */
    public void setGPA(double GPA) {
        this.GPA = GPA;
    }

    /**
     * @return the currentCredits
     */
    public int getCurrentCredits() {
        return currentCredits;
    }

    /**
     * @param currentCredits the currentCredits to set
     */
    public void setCurrentCredits(int currentCredits) {
        this.currentCredits = currentCredits;
    }

    /**
     * @return the totalCredits
     */
    public int getTotalCredits() {
        return totalCredits;
    }

    /**
     * @param totalCredits the totalCredits to set
     */
    public void setTotalCredits(int totalCredits) {
        this.totalCredits = totalCredits;
    }

    /**
     * @return the fName
     */
    public String getfName() {
        return fName;
    }

    /**
     * @param fName the fName to set
     */
    public void setfName(String fName) {
        this.fName = fName;
    }
}
