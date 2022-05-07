## 线程池

- 参数corePoolSize, 线程池中核心线程数量值
- 参数maxPoolSize, 线程池允许最大值

### 线程池的执行策略

task --> blocking queue --> tread pool

- 如果当前的线程数小于corePoolSize, 则任务不进入queue排队，直接创建新线程运行，图示：
 task --> pool
 
- 如果当前的运行线程数大于corePoolSize，则任务始终首选被放入阻塞队列，不添加新线程；图示：
task --> queue (q++) --> pool

- 如果无法把任务放入队列，则创建新的线程, 除非超过了maxPoolSize。图示
task --> queue --> pool (thread++) --> Reject (if maxPoolSize exceeds)

### 阻塞队列类型
线程池底层使用了阻塞队列。队列类型有：
#### 无界队列
- linkedBlockingQueue, 无界，默认没有队列大小限制。线程池类型newFixedThreadPool底层使用；

缺点：当任务执行时间较长可能会导致大量新任务在队列中堆积，导致Out of Memory内存溢出。
内存很高

#### 有界队列
- ArrayBlockingQueue
- 有界的LinkedBlockingQueue

使用有界队列时，队列大小和线程池大小互相配合。
线程池小于队列长度可以减少内存消耗，降低cpu上下文切换，但会限制吞吐。
- minor changes
- major changes: