package demo.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

import org.apache.commons.io.FileUtils;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.Part;

public class FileUtil {

    public static void writefile(String filename, Part photo, String realPath) {
        try {
            if (!Files.exists(Path.of(realPath))) {
                Files.createDirectory(Path.of(realPath));
            }
            try (FileOutputStream os = new FileOutputStream(realPath + "/" + filename)) {
                InputStream is = photo.getInputStream();
                byte[] data = new byte[is.available()];
                is.read(data);
                os.write(data);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void removefile(String filename, String realPath) {
        try {
            if (Files.exists(Path.of(realPath + "/" + filename))) {
                Files.delete(Path.of(realPath + "/" + filename));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void writeFileReal(HttpServletRequest req, String srcProject, String folder, String filename, String nameField) throws IOException, ServletException {
        String srcServer = req.getServletContext().getRealPath("/" + folder);
        Part field = req.getPart(nameField);
        writefile(filename, field, srcProject + "/" + folder);
        writefile(filename, field, srcServer);
    }

    public static void removeFileReal(HttpServletRequest req, String srcProject, String folder, String filename) {
        String srcServer = req.getServletContext().getRealPath("/" + folder);
        removefile(filename, srcProject + "/" + folder);
        removefile(filename, srcServer);
    }

    public static void removeAllFile(HttpServletRequest req, String srcProject, String folder) throws IOException {
        String srcServer = req.getServletContext().getRealPath("/" + folder);
        if (Files.exists(Path.of(srcProject + "/" + folder))) {
            FileUtils.cleanDirectory(new File(srcProject + "/" + folder));
            FileUtils.cleanDirectory(new File(srcServer));
        }
    }
}
