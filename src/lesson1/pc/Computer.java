package lesson1.pc;

import lesson1.iron.Monitor;
import lesson1.iron.Ram;
import lesson1.iron.Ssd;



public class Computer {

    private Ssd ssd;
    private Ram ram;
    private Monitor monitor;


    public Computer(Ssd ssd, Ram ram, Monitor monitor) {
        this.ssd = ssd;
        this.ram = ram;
        this.monitor = monitor;
    }

    public Ssd getSsd() {
        return ssd;
    }

    public Ram getRam() {
        return ram;
    }

    public Monitor getMonitor() {
        return monitor;
    }

    public void load(){
        System.out.println("PS ON");
    }

    public void off(){
        System.out.println("PS OFF");
    }


    @Override
    public String toString() {
        return "Computer{" +
                "ssd='" + ssd + '\'' +
                ", ram='" + ram + '\'' +
                ", monitor=" + monitor +
                '}';


    }
}
