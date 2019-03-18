package com.laiblame.concurrent.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

@Slf4j
public class ForkJoinTaskExample01 extends RecursiveTask<Integer> {
    public static final int threshold = 2;

    private int start;

    private int end;

    public ForkJoinTaskExample01(int start,int end){
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        int sum = 0;

        boolean canCompute = (end - start) <= threshold;
        if (canCompute){
            for (int i = start; i <= end; i++) {
                sum += i;
            }
        } else {
            // 如果任务大于阈值，就分裂成两个子任务
            int middle = (start + end)/2;
            ForkJoinTaskExample01 leftTask = new ForkJoinTaskExample01(start,middle);
            ForkJoinTaskExample01 rightTask = new ForkJoinTaskExample01(middle + 1,end);

            // 执行子任务
            leftTask.fork();
            rightTask.fork();

            // 等待任务执行结果并合算
            Integer leftResult = leftTask.join();
            Integer rightResult = rightTask.join();

            // 合并任务
            sum = leftResult + rightResult;

        }
        return sum;
    }

    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();
        // 生成一个计算任务，计算1+2+3
        ForkJoinTaskExample01 task = new ForkJoinTaskExample01(1,100);
        // 执行一个任务
        ForkJoinTask<Integer> result = pool.submit(task);

        try{
            log.info("result:{}",result.get());
        } catch (Exception e){
            log.error("exception",e);
        }

        pool.shutdown();
    }
}
