package lesson12.patterns.decorator;

import java.io.Serializable;
import java.util.Date;

public class LaunchStat implements Serializable {

    private int launchCount;
    private Date lastLaunch;
    private String lastUser;


    public boolean isFirstLaunch()
    {
        return launchCount==0&&lastLaunch==null;
    }


    public void update()
    {launchCount++;
    lastLaunch=new Date();
    lastUser=System.getProperty("user.name");

    }


    @Override
    public String toString() {
        return "LaunchStat{" +
                "launchCount=" + launchCount +
                ", lastLaunch=" + lastLaunch +
                ", lastUser=" + lastUser +
                '}';
    }
}
