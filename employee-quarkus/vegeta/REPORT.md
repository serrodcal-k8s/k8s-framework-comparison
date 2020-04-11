# Quarkus full report

## Quick summary

* Startup time: 1.026s
* Artifact size: 282KB
* Response report:
```
Requests      [total, rate, throughput]         3000, 50.02, 50.01
Duration      [total, attack, wait]             59.984s, 59.979s, 4.462ms
Latencies     [min, mean, 50, 90, 95, 99, max]  2.531ms, 5.835ms, 4.567ms, 5.869ms, 6.345ms, 9.896ms, 375.005ms
Bytes In      [total, mean]                     12472215, 4157.40
Bytes Out     [total, mean]                     25000, 8.33
Success       [ratio]                           100.00%
Status Codes  [code:count]                      200:3000  
Error Set:
```

## Vegeta

We used 4 CPUs for these tests for querying and saving:

* Vegeta plot:

![](https://github.com/serrodcal/k8s-framework-comparison/blob/master/employee-quarkus/vegeta/images/quarkus-vegeta-plot.png)

* Vegeta JConsole:

![](https://github.com/serrodcal/k8s-framework-comparison/blob/master/employee-quarkus/vegeta/images/quarkus-vegeta-jconsole.png)

## JMeter

We used 1000 users concurrently for querying:

* Jmeter JConsole:

![](https://github.com/serrodcal/k8s-framework-comparison/blob/master/employee-quarkus/vegeta/images/quarkus-jmeter-jconsole.png)
