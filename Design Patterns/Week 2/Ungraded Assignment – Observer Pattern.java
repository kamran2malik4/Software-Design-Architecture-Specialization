/*  Youtube allows users to follow their favorite Youtube stars so that they will be notified when the channel is live.
    This is commonly done using the observer pattern. Complete the provided code and use the following UML class diagram as a guide: */

import java.util.ArrayList;
import java.util.List;

interface Observable{
    public void registerObserver(Observer observer);
    public void removeOberserver(Observer observer);
    public void notifyObserver();
}

interface Observer{
    public void update(String data);
}

class Channel implements Observable{
    private List<Observer> mObservers;
    private String mChannelName;
    private String mStatus;
    public Channel(){
        mObservers = new ArrayList<>();
        mChannelName = "Channel";
        mStatus = "idle";
    }
    @Override
    public void registerObserver(Observer observer) {
        mObservers.add(observer);
    }
    @Override
    public void removeOberserver(Observer observer) {
        mObservers.remove(observer);
    }
    public void setStatus(String status){
        mStatus = status;
    }
    @Override
    public void notifyObserver() {
        for(int i = 0; i < mObservers.size(); i++){
            mObservers.get(i).update(mChannelName + " is " + mStatus);
        }
    }
}

class Follower implements Observer{
    private String mName;
    public Follower(String name){
        mName = name;
    }
    @Override
    public void update(String data) {
        System.out.println("Hey " + mName + ", " + data + ".");
    }
}

// Client class
public class App {
    public static void main(String[] args) {
        Follower kamran = new Follower("Kamran");
        Follower hamza = new Follower("Hamza");
        Follower danish = new Follower("Danish");

        Channel channel = new Channel();

        channel.registerObserver(kamran);
        channel.registerObserver(hamza);
        channel.registerObserver(danish);

        channel.setStatus("Live");

        channel.notifyObserver();

        channel.setStatus("Idle");

        channel.notifyObserver();

    }
}
