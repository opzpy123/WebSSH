package cn.objectspace.webssh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.nio.file.Files;

@Controller
@RequestMapping("file")
public class FileController {


    @GetMapping("/upload")
    public String fileuploadView() {
        return "fileupload";
    }

    @PostMapping("/upload")
    @ResponseBody
    public String fileUpload(MultipartFile file, String path) throws IOException {
        System.out.println(file.getOriginalFilename());
        System.out.println(path);
        upload(file, path);
        return file.getOriginalFilename() + ";;" + path;
    }

    private void upload(MultipartFile uploadFile, String path) throws IOException {
        String uploadFileName = uploadFile.getOriginalFilename();
        File file = new File(path + uploadFileName);
        Files.copy(uploadFile.getInputStream(), file.toPath());
    }

    @GetMapping("/download")
    @ResponseBody
    public void fileDownload(HttpServletResponse response,String path) throws IOException {
        System.out.println(path);
        File file = new File(path);
        FileInputStream fileInputStream = new FileInputStream(file);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        try {
            response.setHeader("Content-disposition", "attachment; filename="
                    + URLEncoder.encode(file.getName(), "UTF-8"));

            byte[] b = new byte[bufferedInputStream.available()];
            bufferedInputStream.read(b);
            OutputStream outputStream = response.getOutputStream();
            outputStream.write(b);
            bufferedInputStream.close();
            outputStream.flush();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
