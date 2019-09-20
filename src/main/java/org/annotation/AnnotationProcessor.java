package org.annotation;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.TypeElement;
import java.util.Set;

@SupportedAnnotationTypes("org.annotation.Test")
@SupportedSourceVersion(value= SourceVersion.RELEASE_8)
public class AnnotationProcessor extends AbstractProcessor {
    @Override
    public synchronized void init(ProcessingEnvironment env){
        System.out.println("init");
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment env){
        System.out.println("log");
        return true;
    }
}
