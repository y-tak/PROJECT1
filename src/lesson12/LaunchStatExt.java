package lesson12;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Date;

public class LaunchStatExt implements Externalizable {
    private int launchCount;
    private Date lastLaunch;
    private String lastUser;
    private static final long seriakVersionUID = 0L;
    private static final int VERSION = 0;


    public boolean isFirstLaunch() {
        return launchCount == 0 && lastLaunch == null;
    }


    public void update() {
        launchCount++;
        lastLaunch = new Date();
        lastUser = System.getProperty("user.name");

    }


    @Override
    public String toString() {
        return "LaunchStat{" +
                "launchCount=" + launchCount +
                ", lastLaunch=" + lastLaunch +
                ", lastUser=" + lastUser +
                '}';
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {

        out.writeInt(VERSION);
        out.writeInt(launchCount);
        out.writeObject(lastLaunch);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        int version = in.readInt();
        {
            if (version > VERSION) {
                throw new IOException("версии не совпадают");
            }
            lastLaunch = (Date) in.readObject();
            launchCount = in.readInt();
            if (version>0){lastUser=in.readUTF();
            };

        }
    }
}
