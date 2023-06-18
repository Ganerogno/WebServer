package com.example.test.ServicesImpl;

import ch.qos.logback.core.util.FileUtil;
import com.example.test.Entities.Product;
import com.example.test.Repositories.ProductRepository;
import com.example.test.Services.StorageService;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

@Service
public class StorageServiceImpl implements StorageService {

    @Autowired
    private ProductRepository productRepository;
    private final String filePath = "uploads/";

    @Override
    public void save(MultipartFile file) throws IOException{
        file.transferTo(new File(Paths.get(filePath).toAbsolutePath() + "/" + file.getOriginalFilename()));
    }

    @Override
    public byte[] loadAsBytes(String name) throws IOException{

        byte[] image = Files.readAllBytes(
                new File(productRepository.findByName(
                        name).get().getURI()).toPath());
        return image;
    }
    @Override
    public byte[] loadAsBytes(Product product) throws IOException{

        byte[] image = Files.readAllBytes(
                new File(product.getURI()).toPath());
        return image;
    }
    @Override
    public void deleteAll() throws IOException{
        FileUtils.cleanDirectory(new File(filePath));
    }

    public String getFilePath() {
        return filePath;
    }
}
