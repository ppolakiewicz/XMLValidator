import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class Statement {

    public static final String NO_ARGUMENTS = "Należy podać dwa argumenty: ścieżkę do pliku xml, ścieżkę do pliku xsd!";
    public static final String NO_XML_FILE = "Niepoprawna ścieżka do pliku xml.";
    public static final String NO_XSD_FILE = "Niepoprawna ścieżka do pliku xsd.";

    public static final String INCOMPATIBLE_XML = "Plik xml niezgodny z xsd.";
    public static final String COMPATIBLE_XML = "Plik xml zgodny z xsd.";

    public static final String LOGGER_ERROR = "Błąd tworzenia logowania";

    public static String getLoggerFileName(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd");
        Date date = new Date();
        return "xml_validator_" + dateFormat.format(date) + ".log";
    }
}
