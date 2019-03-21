import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.io.IOException;

public class Validator {

    public static boolean validate(String xmlPath, String xsdPath, MyLogger logger) {
        SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        try {
            Schema schema = schemaFactory.newSchema(new File(xsdPath));

            javax.xml.validation.Validator validator = schema.newValidator();
            validator.validate(new StreamSource(new File(xmlPath)));

            logger.log(Statement.COMPATIBLE_XML);
            return true;

        } catch (SAXException | IOException e) {
            logger.log(Statement.INCOMPATIBLE_XML + " -> " + e.getMessage());
            return false;
        }
    }
}
