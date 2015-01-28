package com.dripstat.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * A class marked with this can contain @TxnSegment annotations
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface TxnSegmentContainer
{
    /**
     * can contain only alphabets and digits
     */
    String value() default "";
}
