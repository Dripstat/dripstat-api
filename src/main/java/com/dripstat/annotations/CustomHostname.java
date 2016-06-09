package com.dripstat.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Uses the hostname specifed instead of the actual hostname used for making external service calls.<br>
 * Used to prevent metric grouping issues when you are calling an unlimited number of domains, eg during web crawling.<br>
 * Parent class must contain <code>@CustomHostnameContainer</code> annotation.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface CustomHostname
{
    /**
     * @return custom domain name. Can contain only alphabets and digits
     */
    String value();

}
