/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniproject_csc411;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.*;
import java.io.File;
import java.nio.IntBuffer;
import java.util.concurrent.Semaphore;


/**
 *
 * @author Simphiwe
 */
public class MiniProject_CSC411 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        // TODO code application logic here
        //producer
        /*
        try
        {
            ITstudents stud = new ITstudents();
            
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.newDocument();
            
            Element root = doc.createElement("ITStudent");
            doc.appendChild(root);
            
            Element studentn = doc.createElement("Student");
            root.appendChild(studentn);
            System.out.println("ID" + stud.getStud_id());
            Element stud_id = doc.createElement("Student_ID");
            stud_id.appendChild(doc.createTextNode(stud.getStud_id()));
            studentn.appendChild(stud_id);
            
            System.out.println("Name" + stud.getFull_name());
            Element name = doc.createElement("Name");
            name.appendChild(doc.createTextNode(stud.getFull_name()));
            studentn.appendChild(name);
            
            
            System.out.println("Programe" + stud.getProgramme());
            Element program = doc.createElement("Programe");
            program.appendChild(doc.createTextNode(stud.getProgramme()));
            studentn.appendChild(program);
            
            
            ArrayList<Stud_Courses> courses = stud.getCourses();
            for(int i = 0; i <4; i++)
            {   
                Element course = doc.createElement("Course");
                studentn.appendChild(course);
                Stud_Courses student = courses.get(i);
                System.out.println(student.getCourse_name() + " " + student.getMark());
                Element coursename = doc.createElement("Course_Name");
                coursename.appendChild(doc.createTextNode(student.getCourse_name()));
                course.appendChild(coursename);
                Element mark = doc.createElement("Mark");
                Integer mc = student.getMark();
                mark.appendChild(doc.createTextNode(mc.toString()));
                course.appendChild(mark);
            }
            
            //write to xml file
            TransformerFactory tsf = TransformerFactory.newInstance();
            Transformer ts = tsf.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("C:\\Users\\Simphiwe\\Desktop\\student.xml"));
            ts.transform(source,result);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }*/
        
        //consumer
       /* try
        {
            ITstudents student = new ITstudents();
            File file = new File("C:\\Users\\Simphiwe\\Desktop\\student.xml");
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(file);
            doc.getDocumentElement().normalize();
            System.out.println("Root Element :" + doc.getDocumentElement().getNodeName());
            NodeList nodeList = doc.getElementsByTagName("Student");
            Node node = nodeList.item(0);
            if(node.getNodeType() == Node.ELEMENT_NODE)
            {
               Element element = (Element) node;
               String stud_id = element.getElementsByTagName("Student_ID").item(0).getTextContent();
               System.out.println("ID " + stud_id);
               student.setStud_id(stud_id);
               String name = element.getElementsByTagName("Name").item(0).getTextContent();
               System.out.println("Name " + name);
               student.setFull_name(name);
               String program = element.getElementsByTagName("Programe").item(0).getTextContent();
               System.out.println("Programe " + program);
               student.setProgramme(program);
               NodeList subjects = doc.getElementsByTagName("Course");
               ArrayList<Stud_Courses> courses = new ArrayList<Stud_Courses>();
               for(int i = 0; i < subjects.getLength(); i++)
               {
                   Stud_Courses courseItem = new Stud_Courses();
                   Node course = subjects.item(i);
                   Element courseElement = (Element) course;
                   String courseName = courseElement.getElementsByTagName("Course_Name").item(0).getTextContent();
                   courseItem.setCourse_name(courseName);
                   System.out.println(courseName);
                   String mark = courseElement.getElementsByTagName("Mark").item(0).getTextContent();
                   courseItem.setMark(Integer.parseInt(mark));
                   System.out.println(mark);
                   courses.add(courseItem);
        
               }
               student.setCourses(courses);
               
            }
            
            double average = student.getAverage();
            System.out.println("Average Mark " + average);
            if(average >= 50)
            {
                System.out.println("Pass");
            }
            else
            {
                System.out.println("Fail");
            }
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }*/
        //initialize buffer
        IntBuffer  buffer = IntBuffer.allocate(10);
        
        
        int buf[] = new int[10];
        Producer p = new Producer();
        int current = 1;
        Consumer c = new Consumer();
        while(current <= 10 )
        {
           p.produce(current); 
           current++;
           buf[current]=current;
           c.consume(current-1);
           current--;
           buf[current]=0;
           
        }
         
       
        
    }
    
}
