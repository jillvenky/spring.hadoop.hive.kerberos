package sagar.waghunde.spring.hadoop.integration;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class AccessHdfs {
    @Autowired
    private Configuration hdpConfiguration;
    
    @Value("${sample.dir.path}")
    private String sampleDirPath;
    
    @Autowired
    private JdbcTemplate hiveTemplate;
    
    public void createDir() throws IOException {
        FileSystem fileSystem = FileSystem.get(hdpConfiguration);
        Path path = new Path(sampleDirPath);
        if(fileSystem.exists(path)) {
            fileSystem.delete(path, true);
        }
        fileSystem.create(path);
        if(fileSystem.exists(path)) {
            System.out.println("Directory created successfully");
        }
    }
    
    public void countRecords() {
        int count= hiveTemplate.queryForObject("select count(*) from cv_cpa", new Object[]{}, Integer.class);
        System.out.println("count is " + count);
    }
}
