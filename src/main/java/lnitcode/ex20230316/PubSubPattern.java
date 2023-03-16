package lnitcode.ex20230316;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/16 18:53
 */
public class PubSubPattern {

    public static void main(String[] args) {
        PubSubPattern demo = new PubSubPattern();

    }

    private Map<String, Set<Integer>> subData;

    public PubSubPattern() {
        // Write your code here
        subData = new HashMap<>();
    }

    /**
     * @param channel: the channel's name
     * @param user_id: the user who subscribes the channel
     * @return: nothing
     */
    public void subscribe(String channel, int user_id) {
        // Write your code here
        if (subData.containsKey(channel)) {
            Set<Integer> userIdSet = subData.get(channel);
            userIdSet.add(user_id);
        } else {
            Set<Integer> userIdSet = new HashSet<>();
            userIdSet.add(user_id);
            subData.put(channel, userIdSet);
        }
    }

    /**
     * @param channel: the channel's name
     * @param user_id: the user who unsubscribes the channel
     * @return: nothing
     */
    public void unsubscribe(String channel, int user_id) {
        // Write your code here
        if (!subData.containsKey(channel)) {
            return;
        }
        Set<Integer> userIdSet = subData.get(channel);
        if (userIdSet.contains(user_id)) {
            userIdSet.remove(user_id);
        }
    }

    /**
     * @param channel: the channel's name
     * @param message: the message need to be delivered to the channel's subscribers
     * @return: nothing
     */
    public void publish(String channel, String message) {
        // Write your code here
        if (!subData.containsKey(channel)) {
            return;
        }
        Set<Integer> userIdSet = subData.get(channel);
        for (Integer userId : userIdSet) {
            PushNotification.notify(userId, message);
        }
    }
}

class PushNotification {
    public static void notify(int user_id, String the_message){

    }
}
