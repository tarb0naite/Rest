package lt.viko.eif.rest;

import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.ext.wadl.WADLGenerator;
import org.apache.cxf.jaxrs.lifecycle.SingletonResourceProvider;

public class WADLGenerator {
    public static void main(String[] args) {
        // Create the JAXRSServerFactoryBean
        JAXRSServerFactoryBean factory = new JAXRSServerFactoryBean();

        // Set the resource classes
        factory.setResourceClasses(HelloController.class);

        // Set the resource providers
        factory.setResourceProvider(HelloController.class, new SingletonResourceProvider(new HelloController()));

        // Enable WADL generation
        factory.setProvider(new WADLGenerator());

        // Set the base address
        factory.setAddress("http://localhost:8080/api");

        // Create the server
        factory.create();
    }
}
