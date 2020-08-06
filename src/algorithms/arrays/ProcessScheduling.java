/*
 * Multiprocessor Systems use multiple CPUs to perforem various tasks.
 * This increses throughput and reduces time. 
 *
 * In this problem, a multiprocessor system has a 
 * certain no. of processors. Each processor jas the abitlity to schedule a limited nuumber of
 * processes in one second. 
 *
 * However, after this scheduling, the processir's ability is reduced to floor(ability/2).
 * Given the processor ability and np .of processros, what is the minimum time requried to schedule
 * all the processes in the system?
 */
package algorithms.arrays;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 *
 * @author Sushanth Bangera
 */
public class ProcessScheduling {

    /*
     * Time: O(NlogN) 
    */
    public static int minimumTime(int[] ability, int processes) {
        int minTime = 0;
        PriorityQueue<Integer> maxHeap = 
                new PriorityQueue<>(ability.length, Collections.reverseOrder());

        for (int a : ability) {
            maxHeap.offer(a);
        }

        while (processes > 0) {
            int processorAbility = maxHeap.poll();
            processes = processes - processorAbility;
            processorAbility = processorAbility / 2;
            maxHeap.offer(processorAbility);
            minTime++;
        }
        return minTime;
    }

    public static void main(String[] args) {

        int N = 5;
        int ability[] = {3, 1, 7, 2, 4};
        int processes = 15;
        System.out.println(minimumTime(ability, processes));
    }
}
