package com.peoplenet.quickotap.service;

import com.peoplenet.comms.outbound.client.CommsOutboundApi;
import com.peoplenet.packets.mid.Mid229;
import com.peoplenet.quickotap.model.DsnList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;


@Component
public class QuickOtapService {

    @Autowired
    CommsOutboundApi commsOutboundApi;
   
    public void startOtap(DsnList dsnList)
    {
        ArrayList listOfDsns = dsnList.getDsn();

        Mid229.Params params = new Mid229.Params();
        params.installTrigger = 1;
        params.packageCount = 1;
        params.name = "blah";
        params.version = "boo";

//        for (String dsn : listOfDsns) {
//
//            Mid229 mid229 = new Mid229(params);
//            MobileTerminatedMid mobileTerminatedMid = new MobileTerminatedMid(mid229);
//
//            commsOutboundApi.queueMobileTerminatedMid(Integer.parseInt(dsn), "agent", 1, mobileTerminatedMid);
//        }
    }
}