package com.peoplenet.quickotap.service;

import com.peoplenet.comms.outbound.client.CommsOutboundApi;
import com.peoplenet.comms.outbound.domain.MobileTerminatedMid;
import com.peoplenet.packets.mid.Mid229;
import com.peoplenet.quickotap.model.Otap;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class QuickOtapService {

    @Autowired
    CommsOutboundApi commsOutboundApi;

    public void startOtap(Otap otap) {
        ArrayList<Integer> listOfDsns = otap.getDsn();

        Mid229.Params params = new Mid229.Params();
        params.installTrigger = 1;
        params.packageCount = 1;
        params.name = "tempName";
        params.version = "tempVersion";

        for (int dsn : listOfDsns) {

            Mid229 mid229 = new Mid229(params);
            mid229.putUInt32(4, 1);  // quick put to add ASN
            MobileTerminatedMid mobileTerminatedMid = new MobileTerminatedMid(mid229);

            commsOutboundApi.queueMobileTerminatedMid(dsn, "MISC", 1, mobileTerminatedMid);
        }
    }
}