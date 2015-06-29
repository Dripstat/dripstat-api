package com.dripstat.api;

import java.com.chronon.apm.instrument.InstrumentationCode;

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


    public static void setCurrentTransactionName(String txnName)
    {
        if(agentActive)
        {
            InstrumentationCode.api_setTxnName(txnName);
        }
    }

    public static void ignoreCurrentTransaction()
    {
        if (agentActive)
        {
            InstrumentationCode.api_ignoreTxn();
        }
    }

    public static void setException(Throwable e)
    {
        if (agentActive)
        {
            InstrumentationCode.api_setException(e);
        }
    }

}
