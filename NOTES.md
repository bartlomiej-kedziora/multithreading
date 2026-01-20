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
## Stack & Heap Memory Regions
  - what is stack? 
    - memory region where (named stack frame):
      * methods are called
      * arguments are passed
      * local variables are stored
    - stack + instruction pointer = state of each thread's execution
  - stack's properties:
    * are not shared among threads
    * statically allocated when thread is created
    * stack's size is fixed and relatively small
    * if our calling hierarchy is too deep, we may get an StackOverflow Exception 
      (i.e. recursive calls)
  - what is allocated on the Heap?
    - objects (anything created with the "new" operator):
      * String
      * Object
      * Collection
      * ...
    - Members of classes
    - Static variables
  - heap memory management:
    - governed and managed by Garbage Collector
    - members of classes - exists as long as their parent object exists
    - static variables - stay forever

  ![process_context.png](img/process_context.png)
## Resource Sharing & Introduction to Critical Sections