package com.peoplenet.quickotap.service;

import com.peoplenet.comms.outbound.client.CommsOutboundApi;
import com.peoplenet.comms.outbound.domain.MobileTerminatedMid;
import com.peoplenet.packets.mid.Mid229;
import com.peoplenet.quickotap.model.Otap;
import com.peoplenet.quickotap.model.Packages;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class QuickOtapService {

    @Autowired
    CommsOutboundApi commsOutboundApi;

    public void startOtap(Otap otap) {



        ArrayList<Integer> listOfDsns = otap.getDsn();
        ArrayList<Packages> packages = otap.getPackages();
        String[] names = new String[packages.size()];
        String[] versions = new String[packages.size()];

        Mid229.Params params = new Mid229.Params();

        params.installTrigger = 2;
        params.packageCount = packages.size();

        for (int i = 0; i < packages.size(); i++) {
            names[i] = packages.get(i).getName();
            versions[i] = packages.get(i).getVersion();
        }
        params.name = names;
        params.version = versions;

        for (int dsn : listOfDsns) {

            Mid229 mid229 = new Mid229(params);
            MobileTerminatedMid mobileTerminatedMid = new MobileTerminatedMid(mid229);

            commsOutboundApi.queueMobileTerminatedMid(dsn, "MISC", 1, mobileTerminatedMid);
        }
    }
}