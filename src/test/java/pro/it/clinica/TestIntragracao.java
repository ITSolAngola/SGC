package pro.it.clinica;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import pro.it.clinica.GestaoClinicaApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = GestaoClinicaApplication.class,webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class TestIntragracao {

    @LocalServerPort
    private int porta;

    private String url;

    @Before
    public void init(){
        url = "http://localhost:"+porta+"/clinica";
    }


    @Test
    public void test(){
        HttpEntity httpEntity = new HttpEntity(null,null);
        TestRestTemplate restTemplate = new TestRestTemplate();
        ResponseEntity<String> response =  restTemplate.exchange(url,HttpMethod.GET,httpEntity,String.class);
        Assert.assertTrue(porta!=0);
        System.out.println(response.getBody());
    }

}
