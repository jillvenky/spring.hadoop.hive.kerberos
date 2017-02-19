package sagar.waghunde.spring.hadoop.integration;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-hadoop.xml")
public class AccessHdfsIT {
    @Autowired
    private AccessHdfs accessHdfs;
    @Before
    public void setup() {
        
    }
    
    @Test
    public void shouldInjectDependecies() {
        assertNotNull(accessHdfs);
    }
}
