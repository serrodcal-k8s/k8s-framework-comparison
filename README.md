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
Duration      [total, attack, wait]             59.984s, 59.98s, 4.027ms
Latencies     [min, mean, 50, 90, 95, 99, max]  2.271ms, 4.935ms, 4.263ms, 5.405ms, 5.789ms, 7.605ms, 272.2ms
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
Duration      [total, attack, wait]             59.987s, 59.981s, 5.38ms
Latencies     [min, mean, 50, 90, 95, 99, max]  2.67ms, 9.977ms, 4.51ms, 6.194ms, 6.836ms, 199.482ms, 746.414ms
Bytes In      [total, mean]                     12470582, 4156.86
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
Duration      [total, attack, wait]             59.984s, 59.979s, 4.462ms
Latencies     [min, mean, 50, 90, 95, 99, max]  2.531ms, 5.835ms, 4.567ms, 5.869ms, 6.345ms, 9.896ms, 375.005ms
Bytes In      [total, mean]                     12472215, 4157.40
Bytes Out     [total, mean]                     25000, 8.33
Success       [ratio]                           100.00%
Status Codes  [code:count]                      200:3000  
Error Set:
```

## Authors

* [Lechowsky](https://github.com/lechowsky)
* [Sergio Rodriguez](https://github.com/serrodcal)
