package com.chalenge.fanyelll.entity;

import java.util.List;

/**
 * Created by Administrator on 2016/7/28.
 */
public class DianyingyuanshengBean {

    /**
     * nextpage : 1
     * formhash : fc00c611
     * list : [{"tid":"44599","authorid":"22886","author":"wt阿麦","dateline":"昨天 18:17","subject":"To Be By Your Side","replies":"0","liketimes":"13","special":"15","isliked":0,"movietid":"9132","image":"data/attachment/forum/201607/27/181615udaekgdcdkfqdunk.jpg","width":600,"height":600,"musicurl":"http://morguo.com/data/attachment/forum/201607/27/181701lwi526r053v6m00w.mp3","intro":"惟待今夕，与彼并肩；天明何归，复飞靡远。"},{"tid":"44601","authorid":"22886","author":"wt阿麦","dateline":"昨天 18:30","subject":"Ben","replies":"0","liketimes":"54","special":"15","isliked":0,"movietid":"44603","image":"data/attachment/forum/201607/27/183005vq9yjtnx3cxxgjg3.jpg","width":600,"height":601,"musicurl":"http://morguo.com/data/attachment/forum/201607/27/182724s9j9272jgl72rt7p.mp3","intro":"MJ14岁时候的冠军单曲，也是同名电影Ben的主题曲。不得不说MJ小时候声音太清澈，被上帝亲吻过的一样。"},{"tid":"44580","authorid":"200","author":"神秘黑衣人","dateline":"昨天 15:45","subject":"I've Seen It All","replies":"0","liketimes":"76","special":"15","isliked":0,"movietid":"7459","image":"data/attachment/forum/201607/27/154352o5y3ysrzczxyqzg4.jpg","width":500,"height":500,"musicurl":"http://morguo.com/data/attachment/forum/201607/27/154433edy5jebnl8v7djxw.mp3","intro":"汤姆献声，音乐通过模仿火车轮滚动声，拟造出富有节奏感的段落。"},{"tid":"44371","authorid":"23511","author":"离岛十一月","dateline":"6 天前","subject":"Malena","replies":"0","liketimes":"86","special":"15","isliked":0,"movietid":"9157","image":"data/attachment/forum/201607/22/100937gv1c6kstcs2k6hc9.jpg","width":300,"height":300,"musicurl":"http://morguo.com/data/attachment/forum/201607/22/100751zmj0tdxj0gmjzaba.mp3","intro":"温暖饱满的交响乐章里酝酿着源远流长的情感。"},{"tid":"44535","authorid":"200","author":"神秘黑衣人","dateline":"前天 16:53","subject":"Shall we dance?","replies":"0","liketimes":"97","special":"15","isliked":0,"movietid":"13472","image":"data/attachment/forum/201607/26/165057db1ba7tnujbynu2y.jpg","width":400,"height":400,"musicurl":"http://morguo.com/data/attachment/forum/201607/26/165155h3tf1usdq2zshtzx.mp3","intro":"谈谈情，还是跳跳舞？"},{"tid":"44053","authorid":"23531","author":"安好的不是晴天","dateline":"07月18日 14:31","subject":"Our Last Summer","replies":"0","liketimes":"98","special":"15","isliked":0,"movietid":"4165","image":"data/attachment/forum/201607/18/150108o9aww9hdw49ok97o.jpg","width":399,"height":416,"musicurl":"http://morguo.com/data/attachment/forum/201607/18/143122isscyeexoxu5is38.mp3","intro":"不知道为什么，想像科林老师一本正经唱歌的样子，脑子里出现的却是村口他胡大爷，虽说两人声线一点也不像。"},{"tid":"44477","authorid":"200","author":"神秘黑衣人","dateline":"3 天前","subject":"William Tell Overture","replies":"0","liketimes":"92","special":"15","isliked":0,"movietid":"1365","image":"data/attachment/forum/201607/25/153412exguca3j04azj40c.jpg","width":500,"height":498,"musicurl":"http://morguo.com/data/attachment/forum/201607/25/153450il6q1t56671hyvvo.mp3","intro":"《发条橙》绝对是将贝多芬的古典乐早期电子合成乐揉合得绝佳的作品，比如这首曲子你大概很难猜到搭配着什么样的场景。"},{"tid":"44424","authorid":"200","author":"神秘黑衣人","dateline":"5 天前","subject":"自我毁灭","replies":"0","liketimes":"69","special":"15","isliked":0,"movietid":"13428","image":"data/attachment/forum/201607/23/150838dio1h6kma4hn41mq.jpg","width":295,"height":295,"musicurl":"http://morguo.com/data/attachment/forum/201607/23/150917p1r3f5o131r5ll5r.mp3","intro":"机械冰冷的科技舞曲节奏加上低咽的嗓音，林强的这首台客摇滚简直不能更赞！"},{"tid":"44446","authorid":"200","author":"神秘黑衣人","dateline":"4 天前","subject":"ぼくは雨となり星となる","replies":"0","liketimes":"97","special":"15","isliked":0,"movietid":"44445","image":"data/attachment/forum/201607/24/153004oo5niinzheauzu6u.jpg","width":394,"height":371,"musicurl":"http://morguo.com/data/attachment/forum/201607/24/153146j0wz0tgsejrsujes.mp3","intro":"《死国》的片尾曲，由米良美一演唱的天籁之音。"},{"tid":"43332","authorid":"23532","author":"爱萝莉","dateline":"07月05日 18:07","subject":"Твоя тень","replies":"0","liketimes":"98","special":"15","isliked":0,"movietid":"34568","image":"data/attachment/forum/201607/05/185512if1d7y1m775r6yy7.jpg","width":420,"height":420,"musicurl":"http://morguo.com/data/attachment/forum/201607/05/181034ytcc7cu6pntsh2cs.mp3","intro":"撇开电影不谈，歌还是好听的。"}]
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private int nextpage;
        private String formhash;
        /**
         * tid : 44599
         * authorid : 22886
         * author : wt阿麦
         * dateline : 昨天 18:17
         * subject : To Be By Your Side
         * replies : 0
         * liketimes : 13
         * special : 15
         * isliked : 0
         * movietid : 9132
         * image : data/attachment/forum/201607/27/181615udaekgdcdkfqdunk.jpg
         * width : 600
         * height : 600
         * musicurl : http://morguo.com/data/attachment/forum/201607/27/181701lwi526r053v6m00w.mp3
         * intro : 惟待今夕，与彼并肩；天明何归，复飞靡远。
         */

        private List<ListBean> list;

        public int getNextpage() {
            return nextpage;
        }

        public void setNextpage(int nextpage) {
            this.nextpage = nextpage;
        }

        public String getFormhash() {
            return formhash;
        }

        public void setFormhash(String formhash) {
            this.formhash = formhash;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            private String tid;
            private String authorid;
            private String author;
            private String dateline;
            private String subject;
            private String replies;
            private String liketimes;
            private String special;
            private int isliked;
            private String movietid;
            private String image;
            private int width;
            private int height;
            private String musicurl;
            private String intro;

            public String getTid() {
                return tid;
            }

            public void setTid(String tid) {
                this.tid = tid;
            }

            public String getAuthorid() {
                return authorid;
            }

            public void setAuthorid(String authorid) {
                this.authorid = authorid;
            }

            public String getAuthor() {
                return author;
            }

            public void setAuthor(String author) {
                this.author = author;
            }

            public String getDateline() {
                return dateline;
            }

            public void setDateline(String dateline) {
                this.dateline = dateline;
            }

            public String getSubject() {
                return subject;
            }

            public void setSubject(String subject) {
                this.subject = subject;
            }

            public String getReplies() {
                return replies;
            }

            public void setReplies(String replies) {
                this.replies = replies;
            }

            public String getLiketimes() {
                return liketimes;
            }

            public void setLiketimes(String liketimes) {
                this.liketimes = liketimes;
            }

            public String getSpecial() {
                return special;
            }

            public void setSpecial(String special) {
                this.special = special;
            }

            public int getIsliked() {
                return isliked;
            }

            public void setIsliked(int isliked) {
                this.isliked = isliked;
            }

            public String getMovietid() {
                return movietid;
            }

            public void setMovietid(String movietid) {
                this.movietid = movietid;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
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

            public String getMusicurl() {
                return musicurl;
            }

            public void setMusicurl(String musicurl) {
                this.musicurl = musicurl;
            }

            public String getIntro() {
                return intro;
            }

            public void setIntro(String intro) {
                this.intro = intro;
            }
        }
    }
}
