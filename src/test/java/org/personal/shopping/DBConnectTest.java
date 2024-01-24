package org.personal.shopping;

import java.sql.Connection;
import javax.sql.DataSource;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class DBConnectTest {

    @Autowired
    private DataSource dataSource;

    @Test
    public void dbConnectTest() {
        // given
        // when
        try (Connection con = dataSource.getConnection()) {
            // then
            Assert.assertNotNull("The database connection should not be null", con);
            System.out.println("Connection successful: " + con.getMetaData().getUserName());
        } catch (Exception e) {
            Assert.fail("Connection failed: " + e.getMessage());
        }
    }
}