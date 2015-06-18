package com.peoplenet.quickotap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import com.peoplenet.retrofit.client.ClientApiBuilder;
import com.peoplenet.comms.outbound.client.CommsOutboundApi;
import org.springframework.beans.factory.annotation.Value;
        

@Configuration @EnableAutoConfiguration
@ComponentScan(basePackageClasses = { App.class },basePackages = { "com.peoplenet.quickotap" }) public class App {

    @Value("${commsOutboundApi.uri}")
    String commsOutboundApi;
    

    private static final Logger LOG = LoggerFactory.getLogger(App.class);

    public static void main(final String[] args) {
        SpringApplication application = new SpringApplication(App.class);
        application.setShowBanner(false);

        LOG.info("Starting quickOtap");
        application.run(args);
    }

    @Bean
    public CommsOutboundApi commsOutboundApi() {

        return (CommsOutboundApi) (new ClientApiBuilder<CommsOutboundApi>()).withEndpoint(commsOutboundApi).build(CommsOutboundApi.class);

    }
}