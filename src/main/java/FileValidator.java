import java.io.File;

public class FileValidator {

    public static boolean fileExists(String filePath) {
        File file = new File(filePath);
        return file.exists();
    }

    public static boolean xmlFileExists(String xmlPath, MyLogger logger) {
        if (FileValidator.fileExists(xmlPath))
            return true;
        else {
            logger.log(Statement.NO_XML_FILE);
            return false;
        }
    }

    public static boolean xsdFileExists(String xmlPath, MyLogger logger) {
        if (FileValidator.fileExists(xmlPath))
            return true;
        else {
            logger.log(Statement.NO_XSD_FILE);
            return false;
        }
    }

}
