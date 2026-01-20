# multithreading
Exercise and small projects for practice

# exercises content
## ex01
  - thread creation.
  - thread exception handling.
## ex02
  - thread creation - another way
  - case study 01 - hackers as threads break into the vault, policeman thread caught them.
## ex03
  - remove thread (still consume resources, CPU, etc. even if not used)
  - thread.interrupt() aka stop thread gracefully
      * -> set flag isInterrupted to true, throw exception only if is in state sleep/wait/join
      * -> do not terminate thread
  - daemon threads - background threads that do not prevent the app from exiting if the main thread terminates
## ex04
  - thread.join() as a solution for waiting on the results of thread
  - thread.join(x ms) as a solution for skipping thread if executed more than x ms.
  - case study - sum result of base^power for two threads
## ex05
  - throughput as a one type of measuring thread time execution
  - thread pool eliminates some of the cost of multithreading
## ex06

