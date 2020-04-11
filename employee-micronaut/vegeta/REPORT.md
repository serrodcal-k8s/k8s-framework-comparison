# Micronaut full report

## Quick summary

* Startup time: 1.334 seconds
* Artifact size: 18MB
* Response report:
```
Requests      [total, rate, throughput]         3000, 50.02, 50.01
Duration      [total, attack, wait]             59.987s, 59.981s, 5.38ms
Latencies     [min, mean, 50, 90, 95, 99, max]  2.67ms, 9.977ms, 4.51ms, 6.194ms, 6.836ms, 199.482ms, 746.414ms
Bytes In      [total, mean]                     12470582, 4156.86
Bytes Out     [total, mean]                     25000, 8.33
Success       [ratio]                           100.00%
Status Codes  [code:count]                      200:3000  
Error Set:
```

## Vegeta

We used 4 CPUs for these tests for querying and saving:

* Vegeta plot:

![](https://github.com/serrodcal/k8s-framework-comparison/blob/master/employee-micronaut/vegeta/images/micronaut-vegeta-plot.png)

* Vegeta JConsole:

![](https://github.com/serrodcal/k8s-framework-comparison/blob/master/employee-micronaut/vegeta/images/micronaut-vegeta-jconsole.png)

## JMeter

We used 1000 users concurrently for querying:

* Jmeter JConsole:

![](https://github.com/serrodcal/k8s-framework-comparison/blob/master/employee-micronaut/vegeta/images/micronaut-jmeter-jconsole.png)
