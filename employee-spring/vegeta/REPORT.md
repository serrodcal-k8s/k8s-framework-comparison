# Spring full report

## Quick summary

* Startup time: 2.651 seconds
* Artifact size: 21MB
* Response report:
```
Requests      [total, rate, throughput]         3000, 50.02, 50.01
Duration      [total, attack, wait]             59.984s, 59.98s, 4.027ms
Latencies     [min, mean, 50, 90, 95, 99, max]  2.271ms, 4.935ms, 4.263ms, 5.405ms, 5.789ms, 7.605ms, 272.2ms
Bytes In      [total, mean]                     12472054, 4157.35
Bytes Out     [total, mean]                     25000, 8.33
Success       [ratio]                           100.00%
Status Codes  [code:count]                      200:3000  
Error Set:
```

## Vegeta

We used 4 CPUs for these tests for querying and saving:

* Vegeta plot:

![](https://github.com/serrodcal/k8s-framework-comparison/blob/master/employee-spring/vegeta/images/spring-vegeta-plot.png)

* Vegeta JConsole:

![](https://github.com/serrodcal/k8s-framework-comparison/blob/master/employee-spring/vegeta/images/spring-vegeta-jconsole.png)

## JMeter

We used 1000 users concurrently for querying:

* Jmeter JConsole:

![](https://github.com/serrodcal/k8s-framework-comparison/blob/master/employee-spring/vegeta/images/spring-jmeter-jconsole.png)
