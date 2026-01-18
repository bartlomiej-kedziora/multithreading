# Java Multithreading, Concurrency & Performance – Learning Map

This repository is a structured knowledge base and practice companion for the course:

**Java Multithreading, Concurrency & Performance Optimization**

The goal is not only to *understand* multithreading concepts, but to **retain them long-term** through structured notes, mini-projects, and periodic revision.

---

## 🧠 Course Learning Map

This course can be divided into logical cognitive blocks.  
Each block builds on the previous one — skipping fundamentals will cause confusion later.

---

## 🟢 BLOCK 1: FUNDAMENTALS (ABSOLUTE BASE)

These topics must fully "click". Without them, everything else breaks.

### 1. Introduction & Operating System Fundamentals
- Motivation for multithreading
- Processes vs Threads
- OS scheduling fundamentals
- Thread states (NEW, RUNNABLE, BLOCKED, WAITING, TERMINATED)

**Goal:**  
Understand what really happens at the OS + JVM level, not just Java APIs.

---

### 2. Thread Creation
- `Thread` vs `Runnable`
- Thread inheritance
- Thread debugging
- MultiExecutor exercise

**Key takeaways:**
- Why extending `Thread` is usually a bad idea
- Why `Runnable` is preferred
- Why manual thread creation does not scale

---

### 3. Thread Coordination (Basics)
- Thread termination
- Daemon threads
- `Thread.join()`
- Multithreaded calculation

**Important:**  
`join()` is synchronization **without locks** — often underestimated.

---

## 🟢 BLOCK 2: DATA SHARING BETWEEN THREADS

This is where *real* concurrency begins.

### 4. Memory Model Basics
- Stack vs Heap
- Thread-local vs shared data

**Key concept:**  
Explains why data:
- "disappears"
- is not visible across threads

---

### 5. Critical Sections & Synchronization
- Resource sharing
- Critical sections
- `synchronized` keyword

**Critical block of the course.**  
Without this, concepts like `volatile`, atomics, and locks make no sense.

---

### 6. Atomic Operations & `volatile`
- Atomic operations
- `volatile`
- Java Memory Model (advanced reading)

**Key focus:**
- Visibility vs atomicity
- When `volatile` is enough (and when it is not)

---

## 🟢 BLOCK 3: CONCURRENCY PROBLEMS (THE "WHY IT’S HARD" PART)

### 7. Race Conditions & Data Races
- Race conditions
- Data races

**Must be able to:**
- Recognize them in code
- Explain them to others

---

### 8. Locking Strategies & Deadlocks
- Lock ordering
- Deadlock scenarios

**This will become a core mini-project later.**

---

## 🟡 BLOCK 4: ADVANCED LOCKING

Important, but only after fundamentals are solid.

### 9. ReentrantLock
- `tryLock`
- Interruptible locks
- UI-based example

---

### 10. ReadWriteLock
- `ReentrantReadWriteLock`
- Database-style example

**Key questions to answer:**
- When does this help?
- When does it hurt performance?

---

## 🟡 BLOCK 5: INTER-THREAD COMMUNICATION

### 11. Semaphores
- Producer–Consumer
- Barriers

---

### 12. Condition Variables
- `Condition`
- `wait()`, `notify()`, `notifyAll()`

**Important:**  
Only makes sense after understanding `synchronized` and locks.

---

### 13. CountDownLatch
- Simple but extremely useful coordination tool

---

## 🔴 BLOCK 6: LOCK-FREE & HIGH PERFORMANCE

Advanced topics — focus on concepts, not memorization.

### 14. Lock-Free & Non-Blocking Algorithms
- AtomicInteger
- AtomicReference
- Compare-And-Set (CAS)

**Important:**  
Understand *why* they work, not every implementation detail.

---

## 🔴 BLOCK 7: THREADING MODELS & IO ARCHITECTURE

### 15. Blocking IO Models
- Thread-per-request
- Thread-per-task

---

### 16. Non-Blocking IO Models
- Thread-per-core
- Netty / Vert.x / WebFlux (conceptual overview)

**Architectural knowledge, not API memorization.**

---

## 🔴 BLOCK 8: VIRTUAL THREADS (PROJECT LOOM)

### 17. Virtual Threads
- What they are
- How they work
- Best practices
- High-performance IO with virtual threads

**Important:**  
Virtual Threads make sense *only* after understanding classic threading.

---

## 🧠 BLOCK 9: BEYOND MULTITHREADING

- Distributed systems
- Big data
- Performance engineering mindset
- What to learn next

---

## 📝 How to Take Notes

- Do **not** write notes for every video
- Write notes **per block**, not per lecture
- Limit notes to **1–2 pages per block**
- Focus on concepts, trade-offs, and failure cases

---

## 🎯 What Must Be Remembered Long-Term

High priority concepts:
1. Thread lifecycle
2. Critical sections
3. Memory visibility (`volatile`)
4. Race condition vs data race
5. Deadlocks
6. Executor mindset (even before learning the full API)

---

## 🔜 What’s Next

After completing **the first 2–3 blocks** and writing short notes:

- Create **mini-projects** aligned exactly with these topics
- Create **flashcards** (definitions + small code snippets)
- Follow a revision plan:
    - After 7 days
    - After 28 days
    - After 90 days

⚠️ **Important reminder:**  
Understanding comes from the course.  
**Memory comes from writing code.**

Watching the course alone is not enough — practice is mandatory.

---
