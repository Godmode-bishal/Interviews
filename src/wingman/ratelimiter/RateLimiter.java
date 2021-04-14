package wingman.ratelimiter;
import wingman.service.ServiceClient;
import wingman.service.ServiceInterface;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * limits: They define the limit for each resource, customer_id pair. Each line in limits is a
 *  3-tuple in the following format <resouceId customerId maxQps>
 * client: Use the client.callAPI() to invoke the service. This always returns true.
 *
 * The task is to ensure that you never exceed the QPS of each resourceId, customerId specified in limits when calling callAPI.
 */
public class RateLimiter {
    ServiceInterface client;
    Map<String,Long> getQPSMap;
    Map<String,Long> timePerQMap;
    Map<String,Long> lastQtimeMap;

    int i =1;

    public RateLimiter(List<String> limits, ServiceInterface client) {
        // Parse the limits variable to find out what the limits for each resourceId customerId pair into whatever datastructure that is convenient to you.
        getQPSMap = new HashMap<>();
        timePerQMap = new HashMap<>();
        lastQtimeMap = new HashMap<>();
        String[] temp;
        for(String Qps:limits) {
            temp = Qps.split(" ");
            String key = temp[0]+temp[1];
            long qps = Long.parseLong(temp[2]);
            getQPSMap.put(key, qps);
            timePerQMap.put(key,1000/qps);
            lastQtimeMap.put(key,0L);
        }
        this.client = client;
    }

    /**
     This is the ONLY method that you need to implement.
     returns: A long representing the number of milliseconds that callAPI should wait before invoking client.callService in order to respect the limits for this resourceId, customerId pair (as specified in the limits passed to the constructor).
     */
    private long canExecute(String resourceId, String customerId) {
        /*long startTime = System.currentTimeMillis();
        long qps = this.getQPSMap.get(resourceId+customerId);
        double timePerQuery = (1000/qps);
        double diff;
        String[] temp;
        List<String> tempList;
        tempList = ((ServiceClient)this.client).getRequestLogs();
        for(int i = tempList.size(); i-- >0;) {
            if(tempList.get(i).startsWith(resourceId+"_"+customerId)) {
              temp = tempList.get(i).split(" ");
              diff = (double)(System.currentTimeMillis()-Long.parseLong(temp[1]));
              return diff<timePerQuery?(long)(timePerQuery-diff):0L;
            }
        }*/


        ///////////////////////////////////////////////////////////////////
        String key = resourceId+customerId;

        long qps = getQPSMap.get(key);
        long lastQtime = lastQtimeMap.get(key);
        long timePerQuery = timePerQMap.get(key);
        long currTime = System.currentTimeMillis();

        long diff = currTime - lastQtime;

        if(diff>=timePerQuery) {
            lastQtimeMap.put(key,currTime);
            return 0L;
        }else {
            long waitTime = timePerQuery - diff;
            lastQtimeMap.put(key,currTime+waitTime);
            return waitTime;
        }
        ///////////////////////////////////////////////////////////////////////


    }

    /**
     Anyone who wants to invoke ServiceInterface.callService needs to do so through the RateLimiter to do this in a rate-limited manner. The rate limiter will wait to make the call if necessary in order to respect the qps
     */
    public boolean callAPI(String resourceId, String customerId) throws InterruptedException {
        long waitTime = canExecute(resourceId, customerId);
        if (waitTime > 0) {
            Thread.sleep(waitTime);
        }
        this.client.callService(resourceId, customerId);
        return true;
    }

}
