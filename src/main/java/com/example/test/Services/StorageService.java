package com.example.test.Services;

import com.example.test.Entities.Product;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface StorageService {


    void save(MultipartFile file) throws IOException;

    byte[] loadAsBytes(String name) throws IOException;
    byte[] loadAsBytes(Product product) throws IOException;

    void deleteAll() throws IOException;

}