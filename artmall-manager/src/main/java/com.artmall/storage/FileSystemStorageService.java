package com.artmall.storage;

import com.artmall.exception.StorageException;
import com.artmall.mapper.BusinessAttachmentMapper;
import com.artmall.pojo.BusinessAttachment;
import com.artmall.response.ServerResponse;
import com.artmall.service.StorageService;
import com.artmall.utils.IDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;

/**
 * @author
 * @create 2018-08-20 16:18
 **/
@Service
public class FileSystemStorageService implements StorageService {
    private final Path rootLocation;

    @Autowired
    public FileSystemStorageService(StorageProperties properties) {
        this.rootLocation = Paths.get(properties.getLocation());
    }

    @Override
    public void init() {
        try {
            Files.createDirectories(rootLocation);
        }
        catch (IOException e) {
            throw new StorageException("Could not initialize storage", e);
        }
    }

    @Override
    public String store(MultipartFile file)  {
        String filename = StringUtils.cleanPath(file.getOriginalFilename());
        System.out.println("filename为"+filename);
        System.out.println("root为"+rootLocation);

            if (file.isEmpty()) {
                throw new StorageException("Failed to store empty file " + filename);

            }
            if (filename.contains("..")) {
                throw new StorageException(
                        "Cannot store file with relative path outside current directory "
                                + filename);            }

        try {
                System.out.println("I AM HERE");
                InputStream inputStream = file.getInputStream();
                System.out.println("can i");
                Files.copy(inputStream, this.rootLocation.resolve(filename),
                            StandardCopyOption.REPLACE_EXISTING);
            return filename;
        } catch (IOException e) {
            throw new StorageException("Failed to store file " + filename, e);

        }


    }
    @Override
    public void deleteAll() {
        FileSystemUtils.deleteRecursively(rootLocation.toFile());
    }




    @Autowired
    BusinessAttachmentMapper businessAttachmentMapper;

    public ServerResponse<Object> addInfoAttachment(MultipartFile file,
                                                    Long id
    ) {
        System.out.println("I AM HERE");
        String fileName = store(file);
        BusinessAttachment businessAttachment = new BusinessAttachment();
        businessAttachment.setId(new IDUtils(5, 6).nextId());
        businessAttachment.setAttachmentName(fileName);
        businessAttachment.setAttachmentPath(ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("upload-dir")
                .path(fileName)
                .toUriString());
        businessAttachment.setAttachmentSize(file.getSize());
        businessAttachment.setAttachmentType("0");
        businessAttachment.setBusinessId(id);
        businessAttachment.setGmtCreate(new Date());
        businessAttachment.setGmtModified(new Date());

        try {
            businessAttachmentMapper.insert(businessAttachment);
        } catch (Exception e) {
            return ServerResponse.Failure("插入失败");
        }

        return ServerResponse.Success("插入成功");
    }
}


