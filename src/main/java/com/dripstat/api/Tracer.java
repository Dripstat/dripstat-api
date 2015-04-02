package com.dripstat.api;

import java.com.chronon.apm.txn.MethodTracer;

/**
 * @author Prashant Deva
 */
public class Tracer
{
    public static final Tracer noOp = new Tracer(null);

    public final MethodTracer methodTracer;

    public Tracer(MethodTracer methodTracer)
    {

        this.methodTracer = methodTracer;
    }
}
