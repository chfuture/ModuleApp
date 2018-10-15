package com.ycwang.moduleapp.thread;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author ycwang.
 * @date 2018-10-15.
 */
public class ThreadManager {


    public static class ThreadPool {

        private int corePoolSize;
        private int maximumPoolSize;
        private int keepAliveTime;
        private ThreadPoolExecutor executor;

        public ThreadPool(int corePoolSize, int maximumPoolSize, int keepAliveTime, ThreadPoolExecutor executor) {
            this.corePoolSize = corePoolSize;
            this.maximumPoolSize = maximumPoolSize;
            this.keepAliveTime = keepAliveTime;
            this.executor = executor;
        }

        public void execute(Runnable runnable) {
            if (executor == null) {
                executor = new ThreadPoolExecutor(corePoolSize,
                        maximumPoolSize,
                        keepAliveTime,
                        TimeUnit.SECONDS,
                        new LinkedBlockingDeque<Runnable>(),
                        Executors.defaultThreadFactory(),
                        new ThreadPoolExecutor.AbortPolicy());
            }
            executor.execute(runnable);
        }

        public void cancel(Runnable runnable) {
            if (executor != null) {
                executor.getQueue().remove(runnable);
            }
        }
    }


}
