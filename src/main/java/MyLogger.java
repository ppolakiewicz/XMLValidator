import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class MyLogger {

    private String xmlFile;
    private String xsdFile;
    private Logger logger;

    private final boolean APPEND_LOG_FILE = true;

    public MyLogger(String xmlPath, String xsdPath) {
        this();
        setXmlFile(xmlPath);
        setXsdFile(xsdPath);
    }

    public MyLogger(){
        try {
            this.logger = getLogger();
        } catch (IOException e) {
            System.out.println(Statement.LOGGER_ERROR);
        }
    }

    public void log(String message){
        String finalMessage = "XML: " + xmlFile + "\r\n";
        finalMessage += "XSD: " + xsdFile + "\r\n";
        finalMessage += message;
        logger.info(finalMessage);
    }

    public void setXmlFile(String xmlPath) {
        File file = new File(xmlPath);
        this.xmlFile = file.getName();
    }

    public void setXsdFile(String xsdPath) {
        File file = new File(xsdPath);
        this.xsdFile = file.getName();
    }

    private Logger getLogger() throws IOException {
        String logFilePath = URLDecoder.decode(MyLogger.class.getProtectionDomain().getCodeSource().getLocation().getPath(), "UTF-8");
        logFilePath += Statement.getLoggerFileName();

        Logger logger = Logger.getLogger(MyLogger.class.getName());
        logger.setLevel(Level.INFO);
        logger.setUseParentHandlers(false); //Wylaczenie logow na konsoli

        File logFile = new File(logFilePath);
        logFile.createNewFile();

        FileHandler fileTxt = new FileHandler(Statement.getLoggerFileName(), APPEND_LOG_FILE);
        SimpleFormatter formatterTxt = new SimpleFormatter();
        fileTxt.setFormatter(formatterTxt);
        logger.addHandler(fileTxt);

        return logger;
    }
}
