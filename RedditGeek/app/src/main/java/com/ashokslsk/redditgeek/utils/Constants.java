package com.ashokslsk.redditgeek.utils;

import java.util.UUID;

/**
 * Created by ashok.kumar on 31/10/16.
 */

public class Constants {

    public static final String CLIENT_ID = "rAq8idNCZRktoA";
    public static final String REDIRECT_URI= "redditgeek://response";
    public static final String USER_AGENT ="android:com.ashokslsk.redditgeek:v1.0.0 (by /u/ashokslsk)";

    public static final String OAUTH_URL ="https://www.reddit.com/api/v1/authorize.compact";
    public static final String OAUTH_SCOPE="read mysubreddits identity save subscribe";
    public static final String OAUTH_STATE = UUID.randomUUID().toString();
    public static final String PREFERENCES_FILE = "RedditGeekPrefs";
    public static final String NEW_USER_EVENT = "new_user_event";
    public static final String MY_SUBREDDITS_RETRIEVED_EVENT = "my_subreddits_retrieved_event";
    public static final String SUBREDDITS_RETRIEVED_EVENT = "subreddits_retrieved_event";
    public static final String LINKS_RETRIEVED_EVENT = "links_retrieved_event";
    public static final String EXTRA_SUBREDDIT_NAME = "subreddit_name";
    public static final String EXTRA_LINK_COUNT = "link_count";
    public static final String EXTRA_LINK_POSITION = "link_position";
    public static final String EXTRA_LINK_URL = "link_url";
    public static final String EXTRA_LINK_TITLE = "link_title";
    public static final String HTTP_PREFIX = "http";
    public static final String[] OPEN_EXTERNAL = new String[] {"youtube.com", "youtu.be"};
    public static final String ACTION_SHOW_LINKS_FOR_SUBREDDIT =
            "com.ashokslsk.redditgeek.utils.SHOW_LINKS_FOR_SUBREDDIT";

}
