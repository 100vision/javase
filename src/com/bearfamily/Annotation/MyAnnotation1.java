package com.bearfamily.Annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD,ElementType.ANNOTATION_TYPE,ElementType.TYPE})

//RetentionPolicy.RUNTIME tags enables reflection ability for the annotation defined.
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation1 {
    String name();
    String number();
    int size();
    MyEnum Weekday() default MyEnum.MON;
}
