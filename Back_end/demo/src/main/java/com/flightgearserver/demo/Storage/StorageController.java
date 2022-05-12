package com.flightgearserver.demo.Storage;



import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;

import com.google.cloud.storage.Storage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


@RestController
public class StorageController {
    @Autowired
    private Storage storage;



    @GetMapping("/write-file/{filename}")
    public String WriteFileToBucket(@PathVariable(name = "filename") String Filename) throws IOException {
        BlobId blobId=BlobId.of("flightgear-storage",Filename);
        BlobInfo blobInfo=BlobInfo.newBuilder(blobId).build();
        File fileToRead =new File("src/test.txt");
        if(!fileToRead.exists())
            return "file not found";
        byte[] data = Files.readAllBytes(Path.of(fileToRead.toURI()));
        storage.create(blobInfo,data);
        return "File uploaded!";

    }

}
