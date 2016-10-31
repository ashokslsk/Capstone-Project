package com.ashokslsk.redditgeek.view.activity;

import android.app.LoaderManager;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ShareActionProvider;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.ashokslsk.redditgeek.R;
import com.ashokslsk.redditgeek.utils.Constants;
import com.ashokslsk.redditgeek.utils.RedditContract;
import com.ashokslsk.redditgeek.utils.Util;
import com.ashokslsk.redditgeek.view.fragments.PlaceholderFragment;

/**
 * Created by ashok.kumar on 31/10/16.
 */

public class LinkWithCommentsActivity extends AppCompatActivity implements
        LoaderManager.LoaderCallbacks<Cursor> {
    public static final String LOG_TAG = LinkWithCommentsActivity.class.getSimpleName();

    private SectionsPagerAdapter mSectionsPagerAdapter;


    private ViewPager mViewPager;
    private String mSubreddit;
    private int mLinkCount;
    private int mLinkPosition;
    private Cursor mCursorLinks;
    private ShareActionProvider mShareActionProvider;

    private static final int LINKS_PAGER_LOADER = 0;

    public static final int COL_LINK_ROWID = 0;
    public static final int COL_POSITION = 1;
    public static final int COL_ID = 2;
    public static final int COL_TITLE = 3;
    public static final int COL_DOMAIN = 4;
    public static final int COL_AUTHOR = 5;
    public static final int COL_SCORE = 6;
    public static final int COL_NUM_COMMENTS = 7;
    public static final int COL_POST_HINT = 8;
    public static final int COL_STICKIED = 9;
    public static final int COL_OVER_18 = 10;
    public static final int COL_AUTHOR_FL_TEXT = 11;
    public static final int COL_SLFTXT_HTML = 12;
    public static final int COL_SLFTXT = 13;
    public static final int COL_CREATED_UTC = 14;
    public static final int COL_URL = 15;
    public static final int COL_IMG_PORT = 16;
    public static final int COL_IMG_PORT_WIDTH = 17;
    public static final int COL_IMG_PORT_HEIGHT = 18;
    public static final int COL_IMG_LAND = 19;
    public static final int COL_IMG_LAND_WIDTH = 20;
    public static final int COL_IMG_LAND_HEIGHT = 21;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_link_with_comments);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        if (intent != null && intent.getAction() == Constants.ACTION_SHOW_LINKS_FOR_SUBREDDIT) {
            mSubreddit = intent.getStringExtra(Constants.EXTRA_SUBREDDIT_NAME);
            mLinkCount = intent.getIntExtra(Constants.EXTRA_LINK_COUNT, 0);
            mLinkPosition = intent.getIntExtra(Constants.EXTRA_LINK_POSITION, 0);
        }

        getLoaderManager().initLoader(LINKS_PAGER_LOADER, null, this);

        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        //Will set adapter when cursor finished loading data (in cursor loader onfinish event)
        if (mViewPager != null) {
            mViewPager.setAdapter(mSectionsPagerAdapter);
            mViewPager.setCurrentItem(mLinkPosition);
            mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                    String url = getLinkUrl();
                    if (url != null) {
                        Intent sendIntent = new Intent();
                        sendIntent.setAction(Intent.ACTION_SEND);
                        sendIntent.putExtra(Intent.EXTRA_TEXT, url);
                        sendIntent.setType("text/plain");
                        setShareIntent(sendIntent);
                    }
                }

                @Override
                public void onPageSelected(int position) {
                }

                @Override
                public void onPageScrollStateChanged(int state) {
                }
            });
        }
    }

    public void onBackPressed() {
        int position = mViewPager.getCurrentItem();
        if (position >= 0 && position < mLinkCount) {
            Util.updateSubredditPositionInDb(LinkWithCommentsActivity.this, mSubreddit,
                    position);
        }
        super.onBackPressed();
    }

    private String getLinkUrl() {
        String res = null;
        if (mCursorLinks == null || mCursorLinks.isClosed() ||
                !mCursorLinks.moveToPosition(mViewPager.getCurrentItem()))
            return res;
        String url = mCursorLinks.getString(COL_URL);
        if (!url.startsWith(Constants.HTTP_PREFIX))
            return null;
        return mCursorLinks.getString(COL_URL);
    }

    public void onLinkClick(View view) {
        if (mCursorLinks == null || mCursorLinks.isClosed() ||
                !mCursorLinks.moveToPosition(mViewPager.getCurrentItem()))
            return;
        String url = mCursorLinks.getString(COL_URL);
        if (!url.startsWith(Constants.HTTP_PREFIX))
            return;
        Intent intent = new Intent(this, LinkWebViewActivity.class);
        intent.putExtra(Constants.EXTRA_LINK_TITLE, mCursorLinks.getString(COL_TITLE));
        intent.putExtra(Constants.EXTRA_LINK_URL, mCursorLinks.getString(COL_URL));
        startActivity(intent);
    }

    private void refreshComments() {
        mSectionsPagerAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_link_with_comments, menu);
        // Locate MenuItem with ShareActionProvider
        MenuItem item = menu.findItem(R.id.action_share_link);
        // Fetch and store ShareActionProvider
        mShareActionProvider = (ShareActionProvider) MenuItemCompat.getActionProvider(item);
        return true;
    }

    private void setShareIntent(Intent shareIntent) {
        if (mShareActionProvider != null) {
            mShareActionProvider.setShareIntent(shareIntent);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            startActivity(new Intent(this, SettingsActivity.class));
            return true;
        } else if (id == R.id.action_refresh_comments) {
            refreshComments();
        }
        return super.onOptionsItemSelected(item);
    }

    //Override method from LoaderManager.LoaderCallbacks<Cursor>
    @Override
    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        if (i == LINKS_PAGER_LOADER) {
            return new CursorLoader(this,
                    RedditContract.LinkEntry.buildUriWithSubpath(mSubreddit),
                    null /*String[] projection*/,
                    null /*String selection*/,
                    null /*String[] selectionArgs*/,
                    null /*sort order*/);
        }
        return null;
    }

    //Override method from LoaderManager.LoaderCallbacks<Cursor>
    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        if (loader.getId() == LINKS_PAGER_LOADER) {
            mCursorLinks = data;
            if (mViewPager != null) {
                mSectionsPagerAdapter.notifyDataSetChanged();
            }
        }
    }

    //Override method from LoaderManager.LoaderCallbacks<Cursor>
    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        if (loader.getId() == LINKS_PAGER_LOADER) {
            mCursorLinks = null;
        }
    }

    /**
     * A placeholder fragment containing a simple view.
     */


    public class SectionsPagerAdapter extends FragmentStatePagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }


        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position, getIntent().getExtras(), mCursorLinks,
                    LinkWithCommentsActivity.this);
        }

        @Override
        public int getCount() {
            return mLinkCount;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return null;
        }

        public int getItemPosition(Object object) {
            return POSITION_NONE;
        }
    }
}
