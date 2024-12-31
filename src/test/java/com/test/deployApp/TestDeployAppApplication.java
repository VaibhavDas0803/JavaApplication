package com.test.deployApp;

import org.springframework.boot.SpringApplication;

public class TestDeployAppApplication {

    public static void main(String[] args) {
        SpringApplication.from(DeployAppApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
