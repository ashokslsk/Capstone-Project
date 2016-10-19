package com.ashokslsk.redditgeek.model;

import java.util.List;

/**
 * Created by ashok.kumar on 17/10/16.
 */

public class TopnewsResponse {

    private String kind;

    private DataEntity data;

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public DataEntity getData() {
        return data;
    }

    public void setData(DataEntity data) {
        this.data = data;
    }

    public static class DataEntity {
        private String modhash;
        private String after;
        private Object before;

        private List<ChildrenEntity> children;

        public String getModhash() {
            return modhash;
        }

        public void setModhash(String modhash) {
            this.modhash = modhash;
        }

        public String getAfter() {
            return after;
        }

        public void setAfter(String after) {
            this.after = after;
        }

        public Object getBefore() {
            return before;
        }

        public void setBefore(Object before) {
            this.before = before;
        }

        public List<ChildrenEntity> getChildren() {
            return children;
        }

        public void setChildren(List<ChildrenEntity> children) {
            this.children = children;
        }

        public static class ChildrenEntity {
            private String kind;

            private ChildDataEntity data;

            public String getKind() {
                return kind;
            }

            public void setKind(String kind) {
                this.kind = kind;
            }

            public ChildDataEntity getData() {
                return data;
            }

            public void setData(ChildDataEntity data) {
                this.data = data;
            }

            public static class ChildDataEntity {
                private boolean contest_mode;
                private Object banned_by;
                private String domain;
                private String subreddit;
                private Object selftext_html;
                private String selftext;
                private Object likes;
                private Object suggested_sort;
                private Object secure_media;
                private boolean saved;
                private String id;
                private int gilded;
                private boolean clicked;
                private Object report_reasons;
                private String author;
                private Object media;
                private String name;
                private int score;
                private Object approved_by;
                private boolean over_18;
                private Object removal_reason;
                private boolean hidden;
                private PreviewEntity preview;
                private String thumbnail;
                private String subreddit_id;
                private boolean edited;
                private Object link_flair_css_class;
                private Object author_flair_css_class;
                private int downs;
                private boolean archived;
                private String post_hint;
                private boolean is_self;
                private boolean hide_score;
                private String permalink;
                private boolean locked;
                private boolean stickied;
                private double created;
                private String url;
                private Object author_flair_text;
                private boolean quarantine;
                private String title;
                private double created_utc;
                private Object link_flair_text;
                private Object distinguished;
                private int num_comments;
                private boolean visited;
                private Object num_reports;
                private int ups;
                private List<?> user_reports;
                private List<?> mod_reports;

                public boolean isContest_mode() {
                    return contest_mode;
                }

                public void setContest_mode(boolean contest_mode) {
                    this.contest_mode = contest_mode;
                }

                public Object getBanned_by() {
                    return banned_by;
                }

                public void setBanned_by(Object banned_by) {
                    this.banned_by = banned_by;
                }

                public String getDomain() {
                    return domain;
                }

                public void setDomain(String domain) {
                    this.domain = domain;
                }

                public String getSubreddit() {
                    return subreddit;
                }

                public void setSubreddit(String subreddit) {
                    this.subreddit = subreddit;
                }

                public Object getSelftext_html() {
                    return selftext_html;
                }

                public void setSelftext_html(Object selftext_html) {
                    this.selftext_html = selftext_html;
                }

                public String getSelftext() {
                    return selftext;
                }

                public void setSelftext(String selftext) {
                    this.selftext = selftext;
                }

                public Object getLikes() {
                    return likes;
                }

                public void setLikes(Object likes) {
                    this.likes = likes;
                }

                public Object getSuggested_sort() {
                    return suggested_sort;
                }

                public void setSuggested_sort(Object suggested_sort) {
                    this.suggested_sort = suggested_sort;
                }

                public Object getSecure_media() {
                    return secure_media;
                }

                public void setSecure_media(Object secure_media) {
                    this.secure_media = secure_media;
                }

                public boolean isSaved() {
                    return saved;
                }

                public void setSaved(boolean saved) {
                    this.saved = saved;
                }

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public int getGilded() {
                    return gilded;
                }

                public void setGilded(int gilded) {
                    this.gilded = gilded;
                }

                public boolean isClicked() {
                    return clicked;
                }

                public void setClicked(boolean clicked) {
                    this.clicked = clicked;
                }

                public Object getReport_reasons() {
                    return report_reasons;
                }

                public void setReport_reasons(Object report_reasons) {
                    this.report_reasons = report_reasons;
                }

                public String getAuthor() {
                    return author;
                }

                public void setAuthor(String author) {
                    this.author = author;
                }

                public Object getMedia() {
                    return media;
                }

                public void setMedia(Object media) {
                    this.media = media;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public int getScore() {
                    return score;
                }

                public void setScore(int score) {
                    this.score = score;
                }

                public Object getApproved_by() {
                    return approved_by;
                }

                public void setApproved_by(Object approved_by) {
                    this.approved_by = approved_by;
                }

                public boolean isOver_18() {
                    return over_18;
                }

                public void setOver_18(boolean over_18) {
                    this.over_18 = over_18;
                }

                public Object getRemoval_reason() {
                    return removal_reason;
                }

                public void setRemoval_reason(Object removal_reason) {
                    this.removal_reason = removal_reason;
                }

                public boolean isHidden() {
                    return hidden;
                }

                public void setHidden(boolean hidden) {
                    this.hidden = hidden;
                }

                public PreviewEntity getPreview() {
                    return preview;
                }

                public void setPreview(PreviewEntity preview) {
                    this.preview = preview;
                }

                public String getThumbnail() {
                    return thumbnail;
                }

                public void setThumbnail(String thumbnail) {
                    this.thumbnail = thumbnail;
                }

                public String getSubreddit_id() {
                    return subreddit_id;
                }

                public void setSubreddit_id(String subreddit_id) {
                    this.subreddit_id = subreddit_id;
                }

                public boolean isEdited() {
                    return edited;
                }

                public void setEdited(boolean edited) {
                    this.edited = edited;
                }

                public Object getLink_flair_css_class() {
                    return link_flair_css_class;
                }

                public void setLink_flair_css_class(Object link_flair_css_class) {
                    this.link_flair_css_class = link_flair_css_class;
                }

                public Object getAuthor_flair_css_class() {
                    return author_flair_css_class;
                }

                public void setAuthor_flair_css_class(Object author_flair_css_class) {
                    this.author_flair_css_class = author_flair_css_class;
                }

                public int getDowns() {
                    return downs;
                }

                public void setDowns(int downs) {
                    this.downs = downs;
                }

                public boolean isArchived() {
                    return archived;
                }

                public void setArchived(boolean archived) {
                    this.archived = archived;
                }

                public String getPost_hint() {
                    return post_hint;
                }

                public void setPost_hint(String post_hint) {
                    this.post_hint = post_hint;
                }

                public boolean isIs_self() {
                    return is_self;
                }

                public void setIs_self(boolean is_self) {
                    this.is_self = is_self;
                }

                public boolean isHide_score() {
                    return hide_score;
                }

                public void setHide_score(boolean hide_score) {
                    this.hide_score = hide_score;
                }

                public String getPermalink() {
                    return permalink;
                }

                public void setPermalink(String permalink) {
                    this.permalink = permalink;
                }

                public boolean isLocked() {
                    return locked;
                }

                public void setLocked(boolean locked) {
                    this.locked = locked;
                }

                public boolean isStickied() {
                    return stickied;
                }

                public void setStickied(boolean stickied) {
                    this.stickied = stickied;
                }

                public double getCreated() {
                    return created;
                }

                public void setCreated(double created) {
                    this.created = created;
                }

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }

                public Object getAuthor_flair_text() {
                    return author_flair_text;
                }

                public void setAuthor_flair_text(Object author_flair_text) {
                    this.author_flair_text = author_flair_text;
                }

                public boolean isQuarantine() {
                    return quarantine;
                }

                public void setQuarantine(boolean quarantine) {
                    this.quarantine = quarantine;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public double getCreated_utc() {
                    return created_utc;
                }

                public void setCreated_utc(double created_utc) {
                    this.created_utc = created_utc;
                }

                public Object getLink_flair_text() {
                    return link_flair_text;
                }

                public void setLink_flair_text(Object link_flair_text) {
                    this.link_flair_text = link_flair_text;
                }

                public Object getDistinguished() {
                    return distinguished;
                }

                public void setDistinguished(Object distinguished) {
                    this.distinguished = distinguished;
                }

                public int getNum_comments() {
                    return num_comments;
                }

                public void setNum_comments(int num_comments) {
                    this.num_comments = num_comments;
                }

                public boolean isVisited() {
                    return visited;
                }

                public void setVisited(boolean visited) {
                    this.visited = visited;
                }

                public Object getNum_reports() {
                    return num_reports;
                }

                public void setNum_reports(Object num_reports) {
                    this.num_reports = num_reports;
                }

                public int getUps() {
                    return ups;
                }

                public void setUps(int ups) {
                    this.ups = ups;
                }

                public List<?> getUser_reports() {
                    return user_reports;
                }

                public void setUser_reports(List<?> user_reports) {
                    this.user_reports = user_reports;
                }

                public List<?> getMod_reports() {
                    return mod_reports;
                }

                public void setMod_reports(List<?> mod_reports) {
                    this.mod_reports = mod_reports;
                }

                public static class PreviewEntity {


                    private List<ImagesEntity> images;

                    public List<ImagesEntity> getImages() {
                        return images;
                    }

                    public void setImages(List<ImagesEntity> images) {
                        this.images = images;
                    }

                    public static class ImagesEntity {


                        private SourceEntity source;
                        private String id;

                        private List<ResolutionsEntity> resolutions;

                        public SourceEntity getSource() {
                            return source;
                        }

                        public void setSource(SourceEntity source) {
                            this.source = source;
                        }

                        public String getId() {
                            return id;
                        }

                        public void setId(String id) {
                            this.id = id;
                        }

                        public List<ResolutionsEntity> getResolutions() {
                            return resolutions;
                        }

                        public void setResolutions(List<ResolutionsEntity> resolutions) {
                            this.resolutions = resolutions;
                        }

                        public static class SourceEntity {
                            private String url;
                            private int width;
                            private int height;

                            public String getUrl() {
                                return url;
                            }

                            public void setUrl(String url) {
                                this.url = url;
                            }

                            public int getWidth() {
                                return width;
                            }

                            public void setWidth(int width) {
                                this.width = width;
                            }

                            public int getHeight() {
                                return height;
                            }

                            public void setHeight(int height) {
                                this.height = height;
                            }
                        }

                        public static class ResolutionsEntity {
                            private String url;
                            private int width;
                            private int height;

                            public String getUrl() {
                                return url;
                            }

                            public void setUrl(String url) {
                                this.url = url;
                            }

                            public int getWidth() {
                                return width;
                            }

                            public void setWidth(int width) {
                                this.width = width;
                            }

                            public int getHeight() {
                                return height;
                            }

                            public void setHeight(int height) {
                                this.height = height;
                            }
                        }
                    }
                }
            }
        }
    }
}
