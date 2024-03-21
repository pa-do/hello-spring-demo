package com.example.demo.config;

import org.springframework.boot.context.annotation.ImportCandidates;
import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyAutoConfigImportSelector implements DeferredImportSelector {
    private final ClassLoader classLoader;

    public MyAutoConfigImportSelector(ClassLoader classLoader) {
        this.classLoader = classLoader;
    }

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        List<String> autoConfigs = new ArrayList<>();

        for (String candidate: ImportCandidates.load(MyAutoConfiguration.class, classLoader)) {
            autoConfigs.add(candidate);
        }

        return Arrays.copyOf(autoConfigs.toArray(), autoConfigs.size(), String[].class);
    }
}
