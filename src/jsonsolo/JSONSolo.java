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
        
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonValue;
import javax.json.JsonWriter;

public class JSONSolo {
    
    public static void main(String[] args) throws IOException {
        System.out.println("Starting JSON project...\n");
        
        // Create the JSON Object
        try {
            objToJSON();
        } catch(IOException e) {
            System.out.println("Something went wrong...try again");
        }
        
        try {
            displayJSON();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void objToJSON() throws FileNotFoundException, IOException {
        // Create 3 Students
        Student s1 = new Student("Sam", "Janvey", 3.5, 3, 30);
        Student s2 = new Student("Nate", "Janvey", 3.7, 3, 42);
        Student s3 = new Student("Katya", "Janvey", 3.9, 3, 60);
        
        // Add 3 students to Student Array
        ArrayList<Student> students = new ArrayList<Student>();
        students.add(s1);
        students.add(s2);
        students.add(s3);
        
        JsonArrayBuilder jsonArrayBuilder = Json.createArrayBuilder();
        
        // Iterate over Student array and create JSON Objects for each
        for(Student student : students) {
            jsonArrayBuilder.add(
                Json.createObjectBuilder()
                .add("firstName", student.getfName())
                .add("lastName", student.getlName())
                .add("gpa", student.getGPA())
                .add("currentCredits", student.getCurrentCredits())
                .add("totalCredits", student.getTotalCredits())
            );
        }
        // Return the JSON array holding student details
        JsonArray studentArray = jsonArrayBuilder.build();
        
        // Write the array to a file
        try (OutputStream out = new FileOutputStream("Student.json");
                JsonWriter jsonWriter = Json.createWriter(out);) {
            jsonWriter.writeArray(studentArray);
            // Close the stream
            out.close();
            jsonWriter.close();
        }
    }
    
    public static void displayJSON() throws FileNotFoundException {
        File jsonFile = new File("Student.json");
        try (InputStream inputStream = new FileInputStream(jsonFile);
            JsonReader reader = Json.createReader(inputStream);){
            JsonArray studentArray = reader.readArray();
            reader.close();
                        
            List<Student> studentList = new ArrayList<Student>();
            for (JsonValue jsonValue : studentArray) {
                if(JsonValue.ValueType.OBJECT == jsonValue.getValueType()) {
                    JsonObject jsonObject = (JsonObject) jsonValue;
                    Student student = new Student();
                    student.setfName(jsonObject.getString("firstName"));
                    System.out.println("First Name: " + student.getfName());
                    student.setlName(jsonObject.getString("lastName"));
                    System.out.println("Last Name: " + student.getlName());
                    student.setGPA(jsonObject.getInt("gpa"));
                    System.out.println("GPA: " + student.getGPA());
                    student.setCurrentCredits(jsonObject.getInt("currentCredits"));
                    System.out.println("Current Credits: " + student.getCurrentCredits());
                    student.setTotalCredits(jsonObject.getInt("totalCredits"));
                    System.out.println("Total Credits: " + student.getTotalCredits() + '\n');
                    System.out.println("****************************\n");
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            
        }
    }
}