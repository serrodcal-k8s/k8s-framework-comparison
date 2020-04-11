# k8s-framework-comparison

We are going to compare three frameworks in Kubernetes:

* [Spring](https://spring.io/) - _/employee-spring_
* [Micronaut](https://micronaut.io/) - _/employee-micronaut_
* [Quarkus](https://quarkus.io/) - _/employee-quarkus_

Same project and three flavour, we want to analyse some topics like:

* Artifact size
* Startup time
* Memory usage
* CPU usage
* Time to response

## Report quick summary

### Spring

Full report [here](/employee-spring/vegeta/REPORT.md).

* Startup time: 2.651 seconds
* Artifact size: 21MB
* Response report:
```
Requests      [total, rate, throughput]         3000, 50.02, 50.01
Duration      [total, attack, wait]             59.989s, 59.975s, 13.354ms
Latencies     [min, mean, 50, 90, 95, 99, max]  9.253ms, 14.223ms, 13.185ms, 15.703ms, 16.782ms, 21.164ms, 300.85ms
Bytes In      [total, mean]                     12472054, 4157.35
Bytes Out     [total, mean]                     25000, 8.33
Success       [ratio]                           100.00%
Status Codes  [code:count]                      200:3000  
Error Set:
```

### Micronaut

Full report [here](/employee-micronaut/vegeta/REPORT.md).

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

### Quarkus

Full report [here](/employee-quarkus/vegeta/REPORT.md).

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

## Authors

* [Lechowsky](https://github.com/lechowsky)
* [Sergio Rodriguez](https://github.com/serrodcal)
