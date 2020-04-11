# Quarkus full report

## Quick summary

* Startup time: 1.026s
* Artifact size: 282KB
* Response report:
```
Requests      [total, rate, throughput]         3000, 50.02, 50.01
Duration      [total, attack, wait]             59.984s, 59.979s, 5.321ms
Latencies     [min, mean, 50, 90, 95, 99, max]  2.408ms, 5.815ms, 4.433ms, 5.817ms, 6.197ms, 9.463ms, 378.02ms
Bytes In      [total, mean]                     12472330, 4157.44
Bytes Out     [total, mean]                     25000, 8.33
Success       [ratio]                           100.00%
Status Codes  [code:count]                      200:3000  
Error Set:
```

## Vegeta

We used 4 CPUs for these tests for querying and saving:

* Vegeta plot:

![](/images/quarkus-vegeta-plot.png)

* Vegeta JConsole:

![](/images/quarkus-vegeta-jconsole.png)

## JMeter

We used 1000 users concurrently for querying:

* Jmeter JConsole:

![](/images/quarkus-jmeter-jconsole.png)
