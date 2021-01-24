package ru.itis.pool;

/**
 * 07.09.2020
 * 01. Threads
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Main {
    public static void main(String[] args) {
        /*
        Сделать проверки:

        1) Одна задача - один поток
        2) Две задачи - один поток (поочередно выполнить каждую)
        3) Три задачи - три потока (каждый поток выполняет свою задачу)
        4) Четыре задачи - три потока (три потока выполняют три задачи, четвертая задача выполняется первым свободным)
         */
        ThreadPool threadPool = new ThreadPool(3);
        Tirex tirex = new Tirex();
        Thread threadTirex = new Thread(tirex);
        threadPool.submit(threadTirex);

        Cat cat = new Cat();
        Thread threadCat = new Thread(cat);
        threadPool.submit(threadCat);

        Dog dog = new Dog();
        Thread threadDog = new Thread(dog);
        threadPool.submit(threadDog);

        Mouse mouse = new Mouse();
        Thread threadMouse = new Thread(mouse);
        threadPool.submit(threadMouse);
    }
}

class Tirex implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " Tirex");
        }
    }
}

class Cat implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " Cat");
        }
    }
}

class Dog implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " Dog");
        }
    }
}

class Mouse implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " Mouse");
        }
    }
}