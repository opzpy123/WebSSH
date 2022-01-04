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
    public String fileUpload(MultipartFile file, String path) {
        System.out.println(file.getOriginalFilename());
        System.out.println(path);
        try {
            upload(file, path);
        } catch (Exception e) {
            e.printStackTrace();
            return "上传失败:" + e.getMessage();
        }
        return "上传成功:" + path + file;
    }

    private void upload(MultipartFile uploadFile, String path) throws IOException {
        String uploadFileName = uploadFile.getOriginalFilename();
        File file = new File(path + uploadFileName);
        Files.copy(uploadFile.getInputStream(), file.toPath());
    }

    @GetMapping("/download")
    @ResponseBody
    public void fileDownload(HttpServletResponse response, String path) throws IOException {
        System.out.println(path);
//        File file = new File(path);
//        FileInputStream fileInputStream = new FileInputStream(file);
//        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
//        try {
//            response.setHeader("Content-disposition", "attachment; filename="
//                    + URLEncoder.encode(file.getName(), "UTF-8"));
//
//            byte[] b = new byte[bufferedInputStream.available()];
//            bufferedInputStream.read(b);
//            OutputStream outputStream = response.getOutputStream();
//            outputStream.write(b);
//            bufferedInputStream.close();
//            outputStream.flush();
//            outputStream.close();
//            fileInputStream.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        File file = new File(path);
        download(response, path, file.getName());
    }

    private void download(HttpServletResponse response, String path, String fileName) throws UnsupportedEncodingException {

        response.reset();
        response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
        response.setHeader("Connection", "close");
        response.setHeader("Content-Type", "application/octet-stream");

        OutputStream ops = null;
        FileInputStream fis = null;
        byte[] buffer = new byte[8192];
        int bytesRead = 0;

        try {
            ops = response.getOutputStream();
            fis = new FileInputStream(path);
            while ((bytesRead = fis.read(buffer, 0, 8192)) != -1) {
                ops.write(buffer, 0, bytesRead);
            }
            ops.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
                if (ops != null) {
                    ops.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
