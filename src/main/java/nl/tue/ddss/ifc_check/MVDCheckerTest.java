package nl.tue.ddss.ifc_check;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.xml.bind.JAXBException;



public class MVDCheckerTest{

	public MVDCheckerTest(String ifcSchema,String ifcFile,String mvdXMLFile,String reportOutput) throws Exception{
		MvdXMLParser mvdXMLParser=new MvdXMLParser(mvdXMLFile, getClass().getClassLoader());
		try {
			List<MVDConstraint> constraints=mvdXMLParser.generateConceptTrees();

		for (MVDConstraint constraint:constraints){
				IfcChecker ifcChecker=new IfcChecker(ifcSchema,ifcFile,constraint);
				ifcChecker.checkIfcModel(new FileOutputStream(new File(reportOutput)));
			}
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) throws Exception{
	new MVDCheckerTest(args[0],args[1],args[2],args[3]);
	}
}