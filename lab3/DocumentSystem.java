public class DocumentSystem {
    private final FileFactory fileFactory;

    public DocumentSystem(FileFactory fileFactory) {
        this.fileFactory = fileFactory;
    }

    public FileHandler processFileHandler(FileHandler.FileType type) {
        FileHandler file = fileFactory.createFile(type);
        if (file != null) {
            file.process();
            System.out.println("File has been processed");
        } else {
            System.out.println("Unsupported file type");
        }
        return file;
    }
}
