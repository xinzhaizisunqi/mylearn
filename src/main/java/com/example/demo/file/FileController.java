package com.example.demo.file;
import com.example.demo.file.utils.UploadUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * @author 孙琦
 * @version 1.0
 * @description: TODO
 * @date 2020/12/14 16:49
 */
@RestController
public class FileController {

    @GetMapping("/download")
    public String downloadFile(HttpServletRequest request, HttpServletResponse response) {
        String fileName = "downloaddog.jpeg";// 文件名
        String pname = request.getParameter("pname");
        File fileDir = UploadUtils.getImgDirFile();
        if (fileName != null) {
            File file = new File(fileDir.getAbsolutePath() + File.separator + pname);
            if (file.exists()) {
                response.setContentType("application/force-download");// 设置强制下载不打开
                response.addHeader("Content-Disposition", "attachment;fileName=" + fileName);// 设置文件名
                byte[] buffer = new byte[1024];
                FileInputStream fis = null;
                BufferedInputStream bis = null;
                try {
                    fis = new FileInputStream(file);
                    bis = new BufferedInputStream(fis);
                    OutputStream os = response.getOutputStream();
                    int i = bis.read(buffer);
                    while (i != -1) {
                        os.write(buffer, 0, i);
                        i = bis.read(buffer);
                    }
                    return "下载成功";
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (bis != null) {
                        try {
                            bis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (fis != null) {
                        try {
                            fis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return "文件下载路径"+fileDir.getAbsolutePath() + File.separator + pname;
    }

    @RequestMapping(path = "/upload", method = RequestMethod.POST)
    public String uploadPicture(@RequestParam("file") MultipartFile multipartFile) throws IOException {
        // 拿到文件名
        String filename = multipartFile.getOriginalFilename();

        // 存放上传图片的文件夹
        File fileDir = UploadUtils.getImgDirFile();
        // 输出文件夹绝对路径  -- 这里的绝对路径是相当于当前项目的路径而不是“容器”路径
        System.out.println(fileDir.getAbsolutePath());
        try {
            // 构建真实的文件路径
            File newFile = new File(fileDir.getAbsolutePath() + File.separator + filename);
            System.out.println(newFile.getAbsolutePath());

            // 上传图片到 -》 “绝对路径”
            multipartFile.transferTo(newFile);


        } catch (IOException e) {
            e.printStackTrace();
        }

        return "文件上传路径:"+fileDir.getAbsolutePath();

    }
}
