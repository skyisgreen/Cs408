# Cs408
1. 进程与线程
1.1 进程

主要是为了支持伪并发能力



运行态 : 实际占用 CPU 资源
就绪态 : 可运行，但是由于没有时间片而被暂停等待 CPU 重新调度
阻塞态 : 外部某种事件导致（资源不足）不可运行

CPU 利用率 = 1 - p ^ n p : IO 等待时间比 n : 进程数
1.2 线程

每一个进程有一个地址空间和一个控制线程，主要是使某个进程内的任务之间不被相互阻塞，实现一种进程内并行操作的假象。创建销毁更加轻量级。
共享一组资源，协同完成任务。每个线程有自己的堆栈区（因为要区分同一进程内的线程，CPU 调度要进行状态的保存）


线程模型
用户空间中实现线程
内核中实现线程
混合实现
1.3 进程间通信（IPC）
1.竞争条件

两个或者多个进程读写某些共享数据

2.临界区

将共享内存的访问代码称为临界区，确保在每个时刻两个进程不可能同时处于临界区中，这样可以避免竞争条件。核心思想为互斥。

并发程序准确高效要满足一下四个条件

任何两个进程不能同时处于其临界区
不应对 CPU 的速度和数量做任何假设
临界区外运行的程序不得阻塞其他进程
不得使进程无限期等待进入临界区

3.忙等待的互斥

互斥实现方案

屏蔽中断

每个进程进入临界区后立即屏蔽所有中断，这样 CPU 无法进行进程切换，就要离开临界区是打开中断。

锁变量

设置一个共享锁变量，初始值为 0。当一个进程想要进入临界区，必须检测锁的值是否为 0，是则置 1 进入临界区。不是则等待其他进程退出临界区时释放锁直到自己能获取到锁开始进入临界区。
锁变量还是会产生竞争条件

严格轮换法

一直循环等待直到出现允许该进程进入临界区的条件才开始运行，十分消耗 CPU 资源。
避免了竞争条件，但是临界区外运行的程序会发生阻塞
用于忙等待的锁称为自旋锁。

A:
while (TRUE) {
    while (turn != 0);
    critical_region();
    turn = 1;
    noncritical_region();
}

B:
while (TRUE) {
    while (turn != 1); 
    critical_region();
    turn = 0;
    noncritical_region();
}复制代码Peterson 解法

一种互斥算法

#define FALSE 0
#define TRUE 1
#define N 2

int turn;
int interested[N];

void enter_region(int process) {
    int other;
    other = 1 - process;
    interested[process] = TRUE;
    turn = process;
    // 如果有另一个程序进入临界区的话则一直空循环
    while (turn == process && interested[other] == TRUE);
}

void leave_region(int process) {
    interested[process] = FALSE;
}复制代码4.睡眠与唤醒

前面的弊端是忙等待会消耗 CPU 资源。如果在等待进入临界区时可以挂起，等到某个信号到达再唤醒就可以避免这种情况了。

生产者-消费者问题

利用资源缓冲区实现进程间的协调

#define N 100 
int count = 0;

void producer(void) {
    int item;
    while (TURE) {
        item = produce_item();
        if (count == N) {
            sleep();
        }
        insert_item(item);
        count = count + 1;
        if (count == 1) {
            wakeup(consumer);
        }
    }
}

void consumer(void) {
    int item;
    while (TURE) {
        if (count == 0) {
            sleep();
        }
        item = remove_item();
        count = count - 1;
        if (count == N - 1) {
            wakeup(producer);
        }
        consume_item(item);
    }
}复制代码5.信号量

引入一个信号量来累计唤醒次数，可以为 0 或正数 使用 down 和 up 操作代替 sleep 和 wakeup

#define N 100
typedef int semaphore
semaphore mutex = 1;  // 控制对临界区的访问
semaphore empty = N; // 计数缓冲区的空槽数目
semaphore full = 0; // 计数缓冲区的满槽数目

void producer(void) {
    int item;
    while (TRUE) {
        utem = produce_item();
        down(&empty);
        down(&mutex);
        insert_item(item);
        up(&mutex);
        up(&full);
    }
}

void consumer(void) {
    int item;
    while (TRUE) {
        down(&full);
        down(&mutex);
        item = remove_item();
        up(&mutex);
        up(&empty);
        consume_item(item);
    }
}复制代码
mutex : 用于互斥，保证任一时刻只有一个进程读写缓冲区
full && empty : 实现同步，保证某种时间的顺序发生或者不发生

6.互斥量

仅仅适用于管理共享资源或一小段代码

7.管程
8.消息传递
9.屏障
1.4 调度

当有多个进程处于就绪态时就面临调度的选择。内核管理线程时调度可以认为是线程级别的。进程行为有 计算密集型 和 I/O 密集型。而现在由于 CPU 改进速度加快，进程行为更倾向于后者，所以应该多运行该类进程保持 CPU 的利用率。

调度算法

批处理

先来先服务
最短作业优先
最短剩余时间优先


交互式

轮转调度（每个进程一个时间片，用完就轮转）
优先级调度
多级队列
最短进程优先 （aT0 + (1 - a)T1）
保证优先
彩票调度
公平分享调度


实时


线程调度

和系统支持的线程实现方式有关（理解 : 线程表存在哪的区别）

用户级线程 : 内核并不知道，内核只是选中该进程，至于进程中跑哪个线程由用户态调度决定。内核级线程 : 直接调度某个进程内的线程。以上两种方式在性能上有主要差别 : 前面提及 I/O 操作其实是很耗时的，所以在进程间切换比在线程间切换更加耗时。因为线程轻量，而进程完成切换要完整的山下文切换，修改内存映像。而且同一进程内的线程 I/O 访问 cache 的局部性更高，不同进程间切换的清理缓存，这也会消耗时间。

