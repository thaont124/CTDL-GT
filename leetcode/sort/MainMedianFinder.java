package sort;

import java.util.Collections;
import java.util.PriorityQueue;

public class MainMedianFinder {
    public static void main(String[] args) {
        String[] commands = { "MedianFinder", "addNum", "findMedian", "addNum", "findMedian", "addNum", "findMedian",
                "addNum", "findMedian", "addNum", "findMedian", "addNum", "findMedian", "addNum", "findMedian",
                "addNum", "findMedian", "addNum", "findMedian", "addNum", "findMedian", "addNum", "findMedian" };

        int[][] inputs = { {}, { 6 }, {}, { 10 }, {}, { 2 }, {}, { 6 }, {}, { 5 }, {}, { 0 }, {}, { 6 }, {}, { 3 }, {},
                { 1 }, {}, { 0 }, {}, { 0 }, {} };

        MedianFinder medianFinder = null; // Khởi tạo ban đầu

        for (int i = 0; i < commands.length; i++) {
            String command = commands[i];
            if (command.equals("MedianFinder")) {
                medianFinder = new MedianFinder(); // Tạo đối tượng MedianFinder
                System.out.println("MedianFinder initialized.");
            } else if (command.equals("addNum")) {
                int num = inputs[i][0];
                medianFinder.addNum(num);
                System.out.println("addNum(" + num + ") called.");
            } else if (command.equals("findMedian")) {
                double median = medianFinder.findMedian();
                System.out.println("findMedian() called. Median is: " + median);
            }
        }
    }
}

class MedianFinder {
    private PriorityQueue<Integer> maxHeap;
    private PriorityQueue<Integer> minHeap;

    public MedianFinder() {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());

        if (maxHeap.size() < minHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {
        if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        } else {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }
    }
}