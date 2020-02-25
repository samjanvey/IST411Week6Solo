
package jsonsolo;
        
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonReader;
import javax.json.JsonWriter;

public class JSONSolo {
    
    public static void main(String[] args) throws IOException {
        System.out.println("Starting JSON project...");
        
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
    
    public static void displayJSON() {
        // TO DO
    }
}