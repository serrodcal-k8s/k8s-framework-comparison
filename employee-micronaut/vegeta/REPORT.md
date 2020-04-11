# Micronaut full report

## Quick summary

* Startup time: 1.334 seconds
* Artifact size: 18MB
* Response report:
```
Requests      [total, rate, throughput]         3000, 50.02, 50.01
Duration      [total, attack, wait]             59.985s, 59.98s, 5.252ms
Latencies     [min, mean, 50, 90, 95, 99, max]  2.563ms, 11.621ms, 4.508ms, 6.075ms, 6.704ms, 319.83ms, 894.44ms
Bytes In      [total, mean]                     12470073, 4156.69
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
