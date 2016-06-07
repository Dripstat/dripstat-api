package com.dripstat.api;

import java.com.chronon.apm.instrument.InstrumentationCode;
import java.util.Map;

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

    public static void setException(Throwable e, Map<String,String> customParms)
    {
        if (agentActive)
        {
            InstrumentationCode.api_setException(e,customParms);
        }
    }

    /**
     * @return true is a DripStat transaction is currently active in the context of calling method.<br/>
     * Returns false on asynchronous segments<br/>
     *
     * Requires DripStat Agent 8.0.6 or higher.
     */
    public static boolean isTxnActive()
    {
        if(agentActive)
        {
            InstrumentationCode.api_hasActiveTxn();
        }

        return false;
    }

    /**
     * Custom attributes for the current transaction in progress.
     * These will be visible in the Transaction Traces.
     *
     * Requires DripStat Agent 7.2.4 or higher.
     *
     *
     * @param attributes Can have a maximum of 25 entries.
     * Each key/value cannot be longer than 255 characters.
     *
     *
     */
    public static void setCurrentTransactionAttributes(Map<String,String> attributes)
    {
        if (agentActive)
        {
            InstrumentationCode.api_setTxnAttributes(attributes);
        }
    }

}
