public class Model {
    int clicksPerSecond;
    int clicksPerMinute;
    int clicksPerHour;

    int totalClicks;

    public Model(){
        this.clicksPerSecond = 0;
        this.clicksPerMinute = 0;
        this.clicksPerHour = 0;
        this.totalClicks = 0;
    }

    //getters
    public int getClicksPerSecond() {
        return clicksPerSecond;
    }
    public int getClicksPerMinute() {
        return clicksPerMinute;
    }
    public int getClicksPerHour() {
        return clicksPerHour;
    }
    public int getTotalClicks() {
        this.totalClicks = clicksPerSecond + clicksPerMinute * 60 + clicksPerHour * 3600;
        return totalClicks;
    }


    //setters
    public void setClicksPerSecond(int clicksPerSecond) {
        this.clicksPerSecond = clicksPerSecond;
    }
    public void setClicksPerMinute(int clicksPerMinute) {
        this.clicksPerMinute = clicksPerMinute;
    }
    public void setClicksPerHour(int clicksPerHour) {
        this.clicksPerHour = clicksPerHour;
    }

    
}
