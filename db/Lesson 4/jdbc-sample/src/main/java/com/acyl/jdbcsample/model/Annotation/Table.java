package com.acyl.jdbcsample.model.Annotation;

import java.lang.annotation.*;

@Target(value = ElementType.TYPE)
@Retention(value = RetentionPolicy.RUNTIME)
public @interface Table {
    String name();
}
