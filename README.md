# wundergroundDemo
This repository contains a demonstrative use of the wunderground API to get weather metrics

The structural model used is the following:
App class contains the main function and executes every sub-process that is necessary during runtime.
Core package contains classes that get and store necessary info from the wunderground API. We can use the objects created from these classes to get the wanted information.
Utilities package contains classes that simplify processes such as file i/o.
Outputs folder contains files that include the program output, for example the metrics of a day.