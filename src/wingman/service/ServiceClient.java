package wingman.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ServiceClient implements  ServiceInterface {

    private List<String> requestLog = new ArrayList<>();

    public boolean callService(String resourceName, String customerId) {
        long start = System.currentTimeMillis();
        String key = resourceName + "_" + customerId;
        long currMsecs = System.currentTimeMillis();
        String log = key + " " + currMsecs;
        //System.out.println(log);
        requestLog.add(log);
        //System.out.println("Diff = "+(System.currentTimeMillis()-start));
        return true;
    }

    public List<String> getRequestLogs() {
        return requestLog;
    }
}
