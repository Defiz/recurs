import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Recur {

    public static void traverseAndCreateFiles(File path) throws IOException {
        createJavaFile(path);
        File[] files = path.listFiles();
        if (files == null)
            return;
        for (File file : files) {
            if (file.isDirectory()) {
                traverseAndCreateFiles(file);
            }
        }
    }
    public static void createJavaFile(File path) throws IOException {
        final String JAVA_CODE = "hello world";
        File javaFile = new File(path, "joke.java");
        try (FileWriter writer = new FileWriter(javaFile)) {
            writer.write(JAVA_CODE);
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String path = sc.nextLine();
        File dir = new File(path);
        dir.mkdirs();
        traverseAndCreateFiles(dir);
    }
}





