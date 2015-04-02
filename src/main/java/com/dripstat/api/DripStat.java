package com.dripstat.api;

import java.com.chronon.apm.instrument.InstrumentationCode;
import java.com.chronon.apm.txn.MethodTracer;

/**
 * @author Prashant Deva
 */
public class DripStat
{
    private static boolean agentActive;

    static {
        String value = System.getProperty("dripstat.version");
        if (value != null)
        {
            agentActive = true;
        }
    }


    public static Tracer startTrace(String txnName)
    {
        if(agentActive)
        {
            if(txnName!=null && !txnName.isEmpty())
            {
                MethodTracer methodTracer = InstrumentationCode.api_onTxnBegin(txnName);
                return new Tracer(methodTracer);
            }
        }
        return Tracer.noOp;
    }

    public static void endTrace(Tracer tracer)
    {
        if(agentActive)
        {
            if (tracer != Tracer.noOp)
            {
                InstrumentationCode.onMethodEnd(null,tracer.methodTracer);
            }
        }
    }

    public static void currentTxnError(Throwable throwable)
    {
        if(agentActive)
        {
            if(throwable!=null)
            {
                InstrumentationCode.api_setTxnException(throwable);
            }
        }
    }
}
