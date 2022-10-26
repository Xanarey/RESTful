package com.service;

import com.model.File;
import com.repository.FileRepo;
import com.repository.Hibernate.HibernateFileRepoImpl;

import java.util.List;

public class FileService {

    private FileRepo fileRepo = new HibernateFileRepoImpl();

    public File getById(Long id) {
        return fileRepo.getById(id);
    }

    public List<File> getAllFiles() {return fileRepo.getAll();}

    public File updateFile(File file) {return fileRepo.update(file);}

    public File createFile(File file) {return fileRepo.insert(file);}

    public void deleteById(Long id) {fileRepo.deleteById(id);}

}
