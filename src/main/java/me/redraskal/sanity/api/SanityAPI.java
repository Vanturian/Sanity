package me.redraskal.sanity.api;

import me.redraskal.sanity.api.events.BirdsEvent;
import me.redraskal.sanity.api.events.BlindnessEvent;
import me.redraskal.sanity.api.events.NauseaEvent;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Redraskal_2 on 11/7/2016.
 */
public class SanityAPI {

    private static SanityAPI instance;

    public static SanityAPI getInstance() {
        if(instance == null) {
            instance = new SanityAPI();
        }
        return instance;
    }

    private List<SanityEvent> sanityEventList = new ArrayList<SanityEvent>();

    private SanityAPI() {
        this.registerEvent(new NauseaEvent());
        this.registerEvent(new BlindnessEvent());
        this.registerEvent(new BirdsEvent());
    }

    public SanityEvent[] getEvents() {
        return this.sanityEventList.toArray(new SanityEvent[this.sanityEventList.size()]);
    }

    public void registerEvent(SanityEvent sanityEvent) {
        this.sanityEventList.add(sanityEvent);
    }

    public void unregisterEvent(SanityEvent sanityEvent) {
        this.sanityEventList.remove(sanityEvent);
    }
}