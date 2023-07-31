/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniproject_csc411;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author Simphiwe
 */
public class ITstudents {
    
    private String stud_id;
    private String full_name;
    private String Programme;
   
    
    ArrayList<Stud_Courses> Courses;
    
    
   // private String [] Courses;

    public ITstudents() {
        this.stud_id = this.generateStudentID();
        this.full_name = this.generateName();
        this.Programme = this.generateProgramm();
        this.Courses = new ArrayList<Stud_Courses>();
        
        String cname;
        int mark;
        
        for(int i = 0; i < 4; i++)
        {
            Stud_Courses course = new Stud_Courses();
            cname = this.generateCourseCode();
            Random rnd = new Random();
            mark = rnd.nextInt(100);
            course.setCourse_name(cname);
            course.setMark(mark);
            Courses.add(course);
        }
        
    }

    public ITstudents(String stud_id, String first_name, String surname, String Programme, ArrayList<Stud_Courses> Courses) {
        this.stud_id = stud_id;
        this.full_name = first_name;
        this.Programme = Programme;
    //    this.Courses = Courses;
    }
    
    public String getStud_id() {
        return stud_id;
    }

    public void setStud_id(String stud_id) {
        this.stud_id = stud_id;
    }

    public String getFull_name() {
        return full_name;
    }

    

    

    public String getProgramme() {
        return Programme;
    }

    public void setProgramme(String Programme) {
        this.Programme = Programme;
    }
    
    public ArrayList<Stud_Courses> getCourses()
    {
        return this.Courses;
    }
    //generate course code
    private String generateCourseCode()
    {
        String code="";
        Random rd = new Random();// create a random object to generate numbers
        
       String courses[] = {"Database and Design", "Computer Networking", "Security",
                   "Data Structures and Algorithms", "Software Engineering",
                   "Modern Operating Systems", "Web Technology and Development",
                   "Data Mining", "Graphics"};
       code = courses[rd.nextInt(courses.length)];
        
        
        return code;
    }
    private String generateName()
    {
        String name = "";
        
        String names[] = {"Simphiwe","Bright","Sifiso","Ncamiso","Sipho","Siviwe","Mandisa","Ntombikayise","Sphelele","Mndeni"};
        String last[] = {"Dlamini","Khoza","Simelane","Ginindza","Mkhabela","Hlophe","Silwana","Manyatsi","Manana","Msibi"};
        Random rnd = new Random();
        
        name += names[rnd.nextInt(names.length)] + " " + last[rnd.nextInt(10)];
        
        return name;
    }
    
    private String generateStudentID()
    {
        String id = "";
        int num = ThreadLocalRandom.current().nextInt(10000000, 99999999);
        
        id += num;
        return id;
    }
    
    private String generateProgramm()
    {
        String program="";
        String programs [] = {"Computer Science Ed","Bsc Information Technology", "Bsc Information Science","Bsc","Accounting Science","Informatics"};
        Random rnd = new Random();
        program = programs[rnd.nextInt(programs.length)];
        return program;
    }
    
    public double getAverage()
    {
        double avg = 0.0;
        int total=0;
        for(int i =0; i < this.Courses.size(); i++ )
        {
            Stud_Courses current = this.Courses.get(i);
            total += current.getMark();
        }
        
        avg = total/this.Courses.size();
        return avg;
    }
    
     

    /*public ArrayList<Stud_Courses> getCourses() {
        return Courses;
    }

    public void setCourses(ArrayList<Stud_Courses> Courses) {
        this.Courses = Courses;
    } */

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public void setCourses(ArrayList<Stud_Courses> Courses) {
        this.Courses = Courses;
    }
    
    
    
    
    @Override
    protected void finalize() throws Throwable {
        super.finalize(); //To change body of generated methods, choose Tools | Templates.
    }

    

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int hashCode() {
        return super.hashCode(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
}
