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
public class Producer 
{
    public Producer()
    {
        
    }
   
    public void produce(int p)
    {
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
            String file ="C:\\student"+p+".xml";
            StreamResult result = new StreamResult(new File(file));
            ts.transform(source,result);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
