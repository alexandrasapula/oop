import java.io.File;

public class Main {
    public static void main(String[] args) {
        FileFactory fileFactory = new FileFactory();
        DocumentSystem documentSystem = new DocumentSystem(fileFactory);
        String directoryPath = "C:/Users/Sasha/IdeaProjects/lab3/src";
        processFilesInDirectory(directoryPath, documentSystem);
    }

    public static void processFilesInDirectory(String directoryPath, DocumentSystem documentSystem) {
        File folder = new File(directoryPath);
            for (File file : folder.listFiles()) {
                if (file.isFile()) {
                    String fileName = file.getName();
                    String fileExtension = getFileExtension(fileName);
                    switch (fileExtension.toLowerCase()) {
                        case "pdf":
                            documentSystem.processFileHandler(FileHandler.FileType.PDF);
                            break;
                        case "txt":
                            documentSystem.processFileHandler(FileHandler.FileType.Text);
                            break;
                        case "jpg":
                        case "jpeg":
                        case "png":
                            documentSystem.processFileHandler(FileHandler.FileType.Image);
                            break;
                        default:
                            break;
                    }
                }
            }
        }

    private static String getFileExtension(String fileName) {
        int dotIndex = fileName.lastIndexOf('.');
        return (dotIndex > 0) ? fileName.substring(dotIndex + 1) : "";
    }
}