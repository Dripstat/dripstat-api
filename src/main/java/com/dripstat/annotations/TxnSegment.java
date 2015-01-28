package com.dripstat.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Identifies a custom segment in a transaction.
 * Parent class must contain @TxnSegmentContainer annotation
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface TxnSegment
{
    /**
     * can contain only alphabets and digits
     */
    String value() default "";
}
