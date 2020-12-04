// https://www.youtube.com/watch?v=UOr9kMCCa5g
public class MyBlockingQueue<E> {

    private Queue<E> queue;
    private int max = 16;
    private ReentrantLock lock = new ReentrantLock(true);
    private Condition notEmpty = lock.newCondition();
    private Condition notFull = lock.newCondition();

    public MyBlockingQueue(int size) {
        queue = new LinkedList<>(); // can also use array, but need to track head and tail indexes
        this.max = size;
    }

    public void put(E e) {
        lock.lock();
        try {
            if (queue.size() == max) {
                notFull.await(); // block the thread until queue has at least 1 slot to add item
            }
            queue.add(e); // protected by lock
            notEmpty.signalAll(); // signal for notEmpty
        } finally {
            lock.unlock();
        }
    }

    public E take() {
        lock.lock();
        try {
            if (queue.size() == 0) {
                notEmpty.await(); // block the thread until queue has at least 1 item to take
            }
            E item = queue.remove();
            notFull.signalAll();
            return item;
        } finally {
            lock.unlock();
        }
    }
}
