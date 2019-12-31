package com.comparator;

import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;

@SupportedAnnotationTypes("com.comparator.Log")
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class LogProcessor extends AbstractProcessor {

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        for (Element clazz : roundEnv.getElementsAnnotatedWith(Log.class)) {
            processingEnv.getMessager().printMessage(Diagnostic.Kind.NOTE, "found @Log at " + clazz);
            System.out.println("============================================================ Logger Processor Called for "+clazz.getSimpleName());
            
        }
        return true;
    }

}