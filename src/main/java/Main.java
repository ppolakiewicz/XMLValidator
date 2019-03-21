public class Main {
    public static void main(String[] args) {
        MyLogger logger = new MyLogger();
        String xmlPath;
        String xsdPath;

        if (args.length == 2) {
            xmlPath = args[0];
            xsdPath = args[1];
            logger.setXmlFile(xmlPath);
            logger.setXsdFile(xsdPath);

            if (FileValidator.xmlFileExists(args[0], logger) && FileValidator.xsdFileExists(args[1], logger)) {
                if (Validator.validate(xmlPath, xsdPath, logger)) System.exit(0);
                else System.exit(1);
            } else System.exit(1);
        } else {
            logger.log(Statement.NO_ARGUMENTS);
            System.exit(1);
        }
    }
}
