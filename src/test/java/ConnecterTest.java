
import Model.Connecter;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.sql.Connection;
import java.sql.SQLException;
public class ConnecterTest {
    Connecter connecter;
@Before
    public void setUp(){
    connecter=new Connecter();


}
@After
    public void tearDown(){
    connecter=null;


}
@Test
    public void connect() throws SQLException {
    Connection con=connecter.getConnection();
    Assertions.assertNotNull(con);
    Assertions.assertTrue(con.isValid(0));
    con.close();

}

}


