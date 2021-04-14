package javapractice.io;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FilesExample {
    public static void main(String[] args) {
        try(Stream<Path> list = Files.list(Paths.get("C:\\Users\\HP\\Desktop"));) {
            list.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void linesExample() throws IOException {
        String filename = "C:\\Users\\HP\\Desktop\\pondicherry.docx";
        try(Stream<String> stream = Files.lines(Paths.get(filename))) {
            stream.forEach(System.out::println);
        }
    }

    @Test
    public void findExample() throws IOException {
        Path testPath = Paths.get("C:\\Users\\HP\\Desktop");
        //finding files containing 'items' in name
        Stream<Path> stream =
                Files.find(testPath, 100,
                        (path, basicFileAttributes) -> {
                            File file = path.toFile();
                            return !file.isDirectory() &&
                                    file.getName().contains("pondicherry");
                        });
        stream.forEach(System.out::println);
    }

    @Test
    public void threadLocalWithInitialTest() {
        ThreadLocal threadLocal = ThreadLocal.withInitial(
                () -> { return String.valueOf(System.currentTimeMillis()); } );
        System.out.println(threadLocal.get());
    }
}
