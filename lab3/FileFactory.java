public class FileFactory {
    public FileHandler createFile(FileHandler.FileType type) {
        switch (type) {
            case PDF:
                return new PDFFileHandler();
            case Text:
                return new TextFileHandler();
            case Image:
                return new ImageFileHandler();
            default:
                return null;
        }
    }
}
