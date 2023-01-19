import java.util.Scanner;

public class TimeRepresentation {

    private int hours;
    private int minutes;
    private int seconds;
    public TimeRepresentation(){
        this.hours = 0;
        this.minutes = 0;
        this.seconds = 0;
    }
    public TimeRepresentation(int hours, int minutes, int seconds){
        setHours(hours);
        setMinutes(minutes);
        setSeconds(seconds);
    }
    public int getHours() {
        return hours;
    }
    public void setHours(int hours) {
        if (hours <= 23 && hours >= 0){
            this.hours = hours;
        }else{
            this.hours = 0;
        }
    }
    public int getMinutes() {
        return minutes;
    }
    public void setMinutes(int minutes) {
        if (minutes <= 59 && minutes >= 0){
            this.minutes = minutes;
        } else{
            this.minutes = 0;
        }
    }
    public int getSeconds() {
        return seconds;
    }
    public void setSeconds(int seconds) {
        if (seconds <= 59 && seconds >= 0){
            this.seconds = seconds;
        } else{
            this.seconds = 0;
        }
    }
    public void setTime(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Set hours:");
        setHours(sc.nextInt());
        System.out.println("Set minutes:");
        setMinutes(sc.nextInt());
        System.out.println("Set seconds:");
        setSeconds(sc.nextInt());
    }
    public void displayTime(){
        System.out.print("Time is: ");

        if(getHours() == 0 && getHours() < 10){
            System.out.print("0" + getHours() + ":");
        }else{
            System.out.print(getHours() + ":");
        }

        if(getMinutes() == 0 && getMinutes()  < 10){
            System.out.print("0" + getMinutes()  + ":");
        }else{
            System.out.print(getMinutes()  + ":");
        }

        if(getSeconds() == 0 && getSeconds() < 10){
            System.out.println("0" + getSeconds());
        }else{
            System.out.println(getSeconds());
        }
    }
    public void addHours(int hours){
        int temp;
        if (hours >= 24){
            temp = hours % 24 + getHours();
            if (temp >= 24){
                temp-=24;
                setHours(temp);
            }else{
                setHours(temp);
            }
        }else{
            temp = hours + getHours();
            if (temp >= 24){
                temp-=24;
                setHours(temp);
            }else{
                setHours(temp);
            }
        }
    }
    public void addMinutes(int minutes){
        int temp;
        int extraHours;
        if (minutes >= 60){
            temp = minutes % 60 + getMinutes();
            extraHours = minutes/60;
            addHours(extraHours);
            if (temp >= 60){
                extraHours = 1;
                addHours(extraHours);
                temp-=60;
                setMinutes(temp);
            }else{
                setMinutes(temp);
            }
        }else{
            temp = minutes + getMinutes();
            if (temp >= 60){
                extraHours = 1;
                addHours(extraHours);
                temp-=60;
                setMinutes(temp);
            }else{
                setMinutes(temp);
            }
        }
    }
    public void addSeconds(int seconds){
        int temp;
        int extraMinutes;
        if (seconds >= 60){
            temp = seconds % 60 + getSeconds();
            extraMinutes = seconds/60;
            addMinutes(extraMinutes);
            if (temp >= 60){
                extraMinutes = 1;
                addMinutes(extraMinutes);
                temp-=60;
                setSeconds(temp);
            }else{
                setSeconds(temp);
            }
        }else{
            temp = seconds + getSeconds();
            if (temp >= 60){
                extraMinutes = 1;
                addMinutes(extraMinutes);
                temp-=60;
                setSeconds(temp);
            }else{
                setSeconds(temp);
            }
        }
    }
    public void subtractHours(int hours) {
        int temp;
        if(hours >= 24){
            hours%=24;
        }
        temp = getHours() - hours;
        if (temp >= 0) {
            setHours(temp);
        } else {
            if (temp <= -24) {
                temp %= 24;
                setHours(24 + temp);
            } else {
                setHours(24 + temp);
            }
        }
    }
    public void subtractMinutes(int minutes) {
        int temp;
        int extraHours;
        temp = getMinutes() - minutes;
        if (temp >= 0) {
            setMinutes(temp);
        } else {
            if (temp <= -60) {
                extraHours = Math.abs(temp/60);
                subtractHours(extraHours);
                temp %= 60;
                setMinutes(60 + temp);
            } else {
                setMinutes(60 + temp);
                extraHours = 1;
                subtractHours(extraHours);
            }
        }
    }
    public void subtractSeconds(int seconds) {
        int temp;
        int extraMinutes;
        temp = getSeconds() - seconds;
        if (temp >= 0) {
            setSeconds(temp);
        } else {
            if (temp <= -60) {
                extraMinutes = Math.abs(temp/60);
                subtractMinutes(extraMinutes);
                temp %= 60;
                setSeconds(60 + temp);
            } else {
                setSeconds(60 + temp);
                extraMinutes = 1;
                subtractMinutes(extraMinutes);
            }
        }
    }
    public void addTime(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter hours:");
        addHours(sc.nextInt());
        System.out.println("Enter minutes:");
        addMinutes(sc.nextInt());
        System.out.println("Enter seconds:");
        addSeconds(sc.nextInt());
    }
    public void subtractTime(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter hours:");
        subtractHours(sc.nextInt());
        System.out.println("Enter minutes:");
        subtractMinutes(sc.nextInt());
        System.out.println("Enter seconds:");
        subtractSeconds(sc.nextInt());
    }
}




