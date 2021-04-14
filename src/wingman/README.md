Hello and welcome to the Code Challenge. I hope you'll enjoy this as much as we did setting it up.

## Scenario:
Wolf Gupta is a 6 year old engineer who is working on a service that needs to access many rate limited resources on behalf of his customers. E.g, His service needs to access Google Calendar API on behalf of CustomerA. But, these resources have rate limits (expressed in max QPS, queries per second) that have to be respected at any 1 second window for a given resource + customer pair. E.g. Given a limit of q, the service cannot hit the Calendar API more than q times per second in any sliding window of time that you can consider. 


## Problem
For the purpose of this problem, we have abstracted out the various moving parts into a few components. There are three components,

1. **Service**: There is an interface [ServiceInterface] and an implementation of the interface [ServiceClient]. They represent your method to access what ever rate limited api that your service is trying to access. In the above example [Google Calendar]. In the real world this would likely have been a http client. If the limit on this client is k qps. The client will return an error if you call this service more than k times per second.
  
2. **RateLimiter**. This is the class that handles the rate limiting functionality. The class exposes the above client in a rate limited manner. Your service should only access the client through the rate limiter.
The Rate limiter has two methods, 
> private long canExecute(): **This is the method that you will need to implement**. This returns the number of milliseconds that the callAPI method must wait before invoking the ServiceClient [or 0 if it can execute immediately]
> public callAPI: This is the public method for using the RateLimiter. This calls the canExecute to check when the next invocation of ServiceClient can happen. 

3. **RateLimitTester**: This is the test bed which simulates a client at differnt QPS values to test your RateLimiter. This creates an instance of ServiceClient and instantiates your RateLimiter with this and the QPS that must be respected for this client.

  
## Process
* Go through the README
* Ping me on the same channel that I communicated with you if you have any questions.
* Use the RUN button to test your code
* When youre satisfied or have passed the 1 hour mark, please shoot me a note. I'll look at this and get back to you. 