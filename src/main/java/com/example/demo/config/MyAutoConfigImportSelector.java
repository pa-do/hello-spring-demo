package com.example.demo.config;

import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MyAutoConfigImportSelector implements DeferredImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[] {
                "com.example.demo.config.autoconfig.DispatcherServletConfig",
                "com.example.demo.config.autoconfig.TomcatWebServerConfig",
        };
    }
}
