# Performance Optimization
## Performance in Multithreading
  - **Latency** - the time to completion of task. Measured in time units
  - **Throughput** - the amount of tasks completed in a given period. Measured in tasks/time unit
  - more threads than cores is counterproductive
  - by serving each task on a different thread, in parallel, we can improve throughput by N, where
    N is the number of threads (core)
  - using a Fixed Thread Pool, we maintain constant number of threads and eliminate 
    the need to recreate the threads
  - choose the best strategy - handling each request on a different thread
---
# Data sharing between Threads
