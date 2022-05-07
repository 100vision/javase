### 任务队列（阻塞队列）

任务队列，一般都是阻塞队列。对任务进行阻塞等待，让任务有序执行。可以解耦。
线程池Executors底层则使用了阻塞队列

## 任务队列类型

- LinkedBlockingQueue （无界队列）
- ArrayBlockingQueue  （有界队列，有长度限定）

### 无界队列

- linkedBlockingQueue, 默认无界，默认没有队列大小限制。线程池类型newFixedThreadPool底层使用；

缺点：当任务执行时间较长可能会导致大量新任务在队列中堆积，导致Out of Memory内存溢出。
内存很高。

### 有界队列

- ArrayBlockingQueue
- 有界的LinkedBlockingQueue

使用有界队列时，队列大小和线程池大小互相配合。
线程池小于队列长度可以减少内存消耗，降低cpu上下文切换，但会限制吞吐。
