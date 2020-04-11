# Vegeta load test

[Vegeta](https://github.com/tsenart/vegeta) is a versatile HTTP load testing tool
built out of a need to drill HTTP services with a constant request rate. It can
be used both as a command line utility and a library.

## Install it

Follow this [page](https://github.com/tsenart/vegeta#install) to install Vegeta
load testing tool.

## Run tests

Once your application is up and running, attack your application with:
```
vegeta attack -duration=60s -targets=targets.txt | tee results.bin | vegeta report
```

Then, generate report with:
```
vegeta report -type=json results.bin > metrics.json
```

Finally, generate HTML page to show report with:
```
cat results.bin | vegeta plot > plot.html
```

Optionally, you can generate a report in console with:
```
cat results.bin | vegeta report -type="hist[0,100ms,200ms,300ms]"
```
