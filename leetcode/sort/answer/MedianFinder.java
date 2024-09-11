package sort.answer;

class MedianFinder {
    int[] hashVals;
    int median;
    int medianCount2x;

    public MedianFinder() {
        hashVals = new int[200001];
        median = Integer.MIN_VALUE;
        medianCount2x = 1;
    }

    public void addNum(int num) {
        hashVals[num + 100000]++;
        if (median != Integer.MIN_VALUE) {
            if (num > median) {
                if (medianCount2x < 2 * hashVals[median + 100000]) {
                    medianCount2x++;
                } else {
                    medianCount2x = 1;
                    while (hashVals[++median + 100000] == 0) {
                    }
                }
            } else if (num < median) {
                if (medianCount2x > 1) {
                    medianCount2x--;
                } else {
                    while (hashVals[--median + 100000] == 0) {
                    }
                    medianCount2x = 2 * hashVals[median + 100000];
                }
            } else {
                medianCount2x++;
            }
        } else {
            median = num;
        }
    }

    public double findMedian() {
        if (medianCount2x % 2 == 0) {
            if (2 * hashVals[median + 100000] > medianCount2x) {
                return median;
            } else {
                int median2 = median;
                while (hashVals[++median2 + 100000] == 0) {
                }
                return (median + median2) / 2.0;
            }
        } else {
            return median;
        }
    }
    /*
     * TreeMap<Integer,Integer> hash;
     * int medianInd;
     * int medianCount2x;
     * 
     * public MedianFinder() {
     * hash = new TreeMap<>();
     * medianInd = Integer.MIN_VALUE;
     * medianCount2x = 1;
     * }
     * 
     * public void addNum(int num) {
     * hash.compute(num, (k,v) -> v == null ? 1 : v + 1);
     * if (medianInd != Integer.MIN_VALUE) {
     * if (num > medianInd) {
     * if (medianCount2x < 2*hash.get(medianInd)) {
     * medianCount2x++;
     * } else {
     * medianCount2x = 1;
     * medianInd = hash.higherKey(medianInd);
     * }
     * } else if (num < medianInd) {
     * if (medianCount2x > 1) {
     * medianCount2x--;
     * } else {
     * Map.Entry<Integer, Integer> lower = hash.lowerEntry(medianInd);
     * medianInd = lower.getKey();
     * medianCount2x = 2*lower.getValue();
     * }
     * } else {
     * medianCount2x++;
     * }
     * } else {
     * medianInd = num;
     * }
     * }
     * 
     * public double findMedian() {
     * if (medianCount2x % 2 == 0) {
     * int count = hash.get(medianInd);
     * if (2*count > medianCount2x) {
     * return medianInd;
     * } else {
     * return (medianInd + hash.higherKey(medianInd))/2.0;
     * }
     * } else {
     * return medianInd;
     * }
     * }
     */
}

// class MedianFinder {
// PriorityQueue<Integer> pqLeft;
// PriorityQueue<Integer> pqRight;
// public MedianFinder() {
// pqLeft=new PriorityQueue<>((a,b)->b-a);
// pqRight=new PriorityQueue<>();
// }
// public void addNum(int num) {
// if(pqLeft.isEmpty() || num<=pqLeft.peek())
// pqLeft.offer(num);
// else
// pqRight.offer(num);

// if(pqLeft.size()>pqRight.size()+1){
// int extra=pqLeft.poll();
// pqRight.add(extra);
// }
// if(pqRight.size()>pqLeft.size()){
// int extra=pqRight.poll();
// pqLeft.add(extra);
// }
// }

// public double findMedian() {
// if(pqLeft.size()==pqRight.size())
// return (pqLeft.peek()+pqRight.peek())/2.0;
// else
// return pqLeft.peek();
// }
// }

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */