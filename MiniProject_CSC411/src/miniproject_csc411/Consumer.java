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

/**
 *
 * @author Manyatsi
 */
public class Consumer
{
    public Consumer()
    {
        
    }
    public void consume(int p)
    {
        try
        {
            ITstudents student = new ITstudents();
            String filen = "C:\\student"+p+".xml";
            File file = new File(filen);
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
               System.out.println("ID : " + stud_id);
               student.setStud_id(stud_id);
               String name = element.getElementsByTagName("Name").item(0).getTextContent();
               System.out.println("Name : " + name);
               student.setFull_name(name);
               String program = element.getElementsByTagName("Programe").item(0).getTextContent();
               System.out.println("Programe : " + program);
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
                   String mark = courseElement.getElementsByTagName("Mark").item(0).getTextContent();
                   courseItem.setMark(Integer.parseInt(mark));
                   System.out.println(courseName +"\t" +mark);
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
            System.out.println("\n");
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
}
