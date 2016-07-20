package com.example.fangyi.googleplay.manager;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 管理线程池
 * Created by FANGYI on 2016/7/19.
 */

public class ThreadManager {

    private ThreadPoolProxy longPoolProxy;
    private ThreadPoolProxy shorPoolProxy;

    private ThreadManager() {
    }

    private static ThreadManager instance = new ThreadManager();

    public static ThreadManager getInstance() {
        return instance;
    }

    /**
     * 开启线程数：cpu的核数*2 +1
     *
     * @return
     */
    public synchronized ThreadPoolProxy createLongPool() {
        if (longPoolProxy == null) {
            longPoolProxy = new ThreadPoolProxy(5, 5, 5000L);
        }
        return longPoolProxy;
    }

    /**
     * 根据不同情景开启不同线程池
     *
     * @return
     */
    public synchronized ThreadPoolProxy createShorPool() {
        if (shorPoolProxy == null) {
            shorPoolProxy = new ThreadPoolProxy(3, 3, 5000L);
        }
        return shorPoolProxy;
    }

    public class ThreadPoolProxy {
        private ThreadPoolExecutor pool;
        private int corePoolSize;
        private int maximumPoolSize;
        private long aliveTime;

        public ThreadPoolProxy(int corePoolSize, int maximumPoolSize, long aliveTime) {
            this.corePoolSize = corePoolSize;
            this.maximumPoolSize = maximumPoolSize;
            this.aliveTime = aliveTime;
        }


        /**
         * 执行任务
         * @param runnable
         */
        public void execute(Runnable runnable) {
            if (pool == null) {
                /**
                 * 创建线程池
                 *
                 * 1.线程池管理多少个线程
                 * 2.如果排队满了，额外的开的线程数
                 * 3.如果线程池没有要执行的任务，存货多久
                 * 4.时间的单位(毫秒)
                 * 5.如果线程池管理的线程都已经用了，剩下的任务都临时存到LinkedBlockingDeque对象中排队
                 */
                pool = new ThreadPoolExecutor(
                        corePoolSize,
                        maximumPoolSize,
                        aliveTime,
                        TimeUnit.MILLISECONDS,
                        new LinkedBlockingDeque<Runnable>(10));
            }
            pool.execute(runnable);//调用线程池，执行异步任务
        }

        /**
         * 取消任务
         * @param runnable
         */
        public void cancel(Runnable runnable) {
            if (pool != null && !pool.isShutdown() && !pool.isTerminated()) {
                pool.remove(runnable);//取消异步任务
            }
        }
    }
}
