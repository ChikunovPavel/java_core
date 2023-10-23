package Lesson1;

import Lesson1.iron.Monitor;
import Lesson1.iron.Ram;
import Lesson1.iron.Ssd;
import Lesson1.pc.Computer;

public class Runer {
    public static void main(String[] args) {
        Ram ram = new Ram(16);
        Ssd ssd = new Ssd(512);
        Monitor monitor = new Monitor(24,"Ips");
        Computer computer = new Computer(ssd,ram,monitor);


        computer.load();
        System.out.println(computer.getMonitor());
        System.out.println(computer.getRam());
        System.out.println(computer.getSsd());
        computer.off();






    }
}