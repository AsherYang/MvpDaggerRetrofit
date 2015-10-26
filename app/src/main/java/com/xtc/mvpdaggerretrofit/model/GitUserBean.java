package com.xtc.mvpdaggerretrofit.model;

/**
 * Created by ouyangfan on 2015/10/26.
 *
 * @see "http://www.open-open.com/lib/view/open1429672286823.html"
 *
 * model 实体Bean
 *
 * Demo: 获取github搜索结果,URL如下:
 * https://api.github.com/users/ + “search term”
 */
public class GitUserBean {

    /**
     * organizations_url : https://api.github.com/users/AsherYang/orgs
     * received_events_url : https://api.github.com/users/AsherYang/received_events
     * avatar_url : https://avatars.githubusercontent.com/u/13010560?v=3
     * gravatar_id :
     * public_gists : 0
     * location : Guangdong, China
     * site_admin : false
     * type : User
     * blog : null
     * id : 13010560
     * following : 1
     * followers : 1
     * public_repos : 3
     * name : YangFan Ou
     * following_url : https://api.github.com/users/AsherYang/following{/other_user}
     * created_at : 2015-06-23T02:54:36Z
     * events_url : https://api.github.com/users/AsherYang/events{/privacy}
     * login : AsherYang
     * subscriptions_url : https://api.github.com/users/AsherYang/subscriptions
     * repos_url : https://api.github.com/users/AsherYang/repos
     * gists_url : https://api.github.com/users/AsherYang/gists{/gist_id}
     * starred_url : https://api.github.com/users/AsherYang/starred{/owner}{/repo}
     * url : https://api.github.com/users/AsherYang
     * html_url : https://github.com/AsherYang
     * hireable : true
     * updated_at : 2015-10-26T08:22:27Z
     * bio : null
     * email : ouyangfan1991@gmail.com
     * company : eebbk, Inc.
     * followers_url : https://api.github.com/users/AsherYang/followers
     */
    private String organizations_url;
    private String received_events_url;
    private String avatar_url;
    private String gravatar_id;
    private int public_gists;
    private String location;
    private boolean site_admin;
    private String type;
    private String blog;
    private int id;
    private int following;
    private int followers;
    private int public_repos;
    private String name;
    private String following_url;
    private String created_at;
    private String events_url;
    private String login;
    private String subscriptions_url;
    private String repos_url;
    private String gists_url;
    private String starred_url;
    private String url;
    private String html_url;
    private boolean hireable;
    private String updated_at;
    private String bio;
    private String email;
    private String company;
    private String followers_url;

    public void setOrganizations_url(String organizations_url) {
        this.organizations_url = organizations_url;
    }

    public void setReceived_events_url(String received_events_url) {
        this.received_events_url = received_events_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public void setGravatar_id(String gravatar_id) {
        this.gravatar_id = gravatar_id;
    }

    public void setPublic_gists(int public_gists) {
        this.public_gists = public_gists;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setSite_admin(boolean site_admin) {
        this.site_admin = site_admin;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setBlog(String blog) {
        this.blog = blog;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFollowing(int following) {
        this.following = following;
    }

    public void setFollowers(int followers) {
        this.followers = followers;
    }

    public void setPublic_repos(int public_repos) {
        this.public_repos = public_repos;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFollowing_url(String following_url) {
        this.following_url = following_url;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public void setEvents_url(String events_url) {
        this.events_url = events_url;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setSubscriptions_url(String subscriptions_url) {
        this.subscriptions_url = subscriptions_url;
    }

    public void setRepos_url(String repos_url) {
        this.repos_url = repos_url;
    }

    public void setGists_url(String gists_url) {
        this.gists_url = gists_url;
    }

    public void setStarred_url(String starred_url) {
        this.starred_url = starred_url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setHtml_url(String html_url) {
        this.html_url = html_url;
    }

    public void setHireable(boolean hireable) {
        this.hireable = hireable;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setFollowers_url(String followers_url) {
        this.followers_url = followers_url;
    }

    public String getOrganizations_url() {
        return organizations_url;
    }

    public String getReceived_events_url() {
        return received_events_url;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public String getGravatar_id() {
        return gravatar_id;
    }

    public int getPublic_gists() {
        return public_gists;
    }

    public String getLocation() {
        return location;
    }

    public boolean isSite_admin() {
        return site_admin;
    }

    public String getType() {
        return type;
    }

    public String getBlog() {
        return blog;
    }

    public int getId() {
        return id;
    }

    public int getFollowing() {
        return following;
    }

    public int getFollowers() {
        return followers;
    }

    public int getPublic_repos() {
        return public_repos;
    }

    public String getName() {
        return name;
    }

    public String getFollowing_url() {
        return following_url;
    }

    public String getCreated_at() {
        return created_at;
    }

    public String getEvents_url() {
        return events_url;
    }

    public String getLogin() {
        return login;
    }

    public String getSubscriptions_url() {
        return subscriptions_url;
    }

    public String getRepos_url() {
        return repos_url;
    }

    public String getGists_url() {
        return gists_url;
    }

    public String getStarred_url() {
        return starred_url;
    }

    public String getUrl() {
        return url;
    }

    public String getHtml_url() {
        return html_url;
    }

    public boolean isHireable() {
        return hireable;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public String getBio() {
        return bio;
    }

    public String getEmail() {
        return email;
    }

    public String getCompany() {
        return company;
    }

    public String getFollowers_url() {
        return followers_url;
    }
}
