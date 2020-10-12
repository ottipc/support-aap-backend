package com.bw.springboot.control;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;





@RestController
@Controller
public class DefaultController {

    private static final Logger logger = LoggerFactory
            .getLogger(DefaultController.class);

    /**
     * Upload single file using Spring Controller
     */
    @CrossOrigin
    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    public @ResponseBody
    String uploadFileHandler(@RequestParam("name") String name,
            @RequestParam("file") MultipartFile file) {



        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                 // Creating the directory to store file
                File filedir = new File("/var/www/pics/");
                System.out.print("saving to \"/var/www/pics/\"");
                System.out.print("saving to \"/var/www/pics/\"");
                if (!filedir.exists())
                    filedir.mkdirs();

                // Create the file on server
                File serverFile = new File(filedir
                        + File.separator + name);
                BufferedOutputStream stream = new BufferedOutputStream(
                        new FileOutputStream(serverFile));
                stream.write(bytes);
                stream.close();

                logger.info("Server File Location="
                        + serverFile.getAbsolutePath());

                return "You successfully uploaded file=" + name;
            } catch (Exception e) {
                return "You failed to upload " + name + " => " + e.getMessage();
            }
        } else {
            return "You failed to upload " + name
                    + " because the file was empty.";
        }
    }

}
