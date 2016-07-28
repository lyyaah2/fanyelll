package com.chalenge.fanyelll.entity;

import java.util.List;

/**
 * Created by Administrator on 2016/7/26.
 */
public class DuanpianBean {


    /**
     * nextpage : 1
     * formhash : 3d050c10
     * list : [{"tid":"44503","authorid":"200","author":"神秘黑衣人","dateline":"16&nbsp;小时前","subject":"仓鼠","replies":"0","liketimes":"44","special":"16","isliked":0,"movietid":"0","image":"data/attachment/forum/201607/26/003833r8o68mow8tj66sch.jpg","width":770,"height":433,"videourl":"http://morguo.com/data/attachment/movietrailer/threadvideo/2015/44503_thehamaster.mp4","intro":"这是一个关于爱和恐惧的故事。可爱的仓鼠在女儿面前代表着快乐，在父亲眼中却不那么简单。"},{"tid":"44478","authorid":"23511","author":"离岛十一月","dateline":"昨天&nbsp;15:38","subject":"虐心结局法国动画短片《CARN》","replies":"0","liketimes":"90","special":"16","isliked":0,"movietid":"0","image":"data/attachment/forum/201607/25/154821wh1anzzh1zyvqgoh.jpg","width":1725,"height":1035,"videourl":"http://morguo.com/data/attachment/movietrailer/threadvideo/2015/44478_carn.mp4","intro":"饥寒交迫的雪地里，你会相信自己，还是相信一匹淌血的狼？"},{"tid":"44452","authorid":"200","author":"神秘黑衣人","dateline":"昨天&nbsp;00:33","subject":"厨师大赛的意外收获","replies":"0","liketimes":"93","special":"16","isliked":0,"movietid":"0","image":"data/attachment/forum/201607/25/003321yto7ia788ip75idu.jpg","width":1200,"height":750,"videourl":"http://morguo.com/data/attachment/movietrailer/threadvideo/2015/44452_chushidasai.mp4","intro":"自打一出生，我们就开始竞争。我们被告知优胜劣汰，机会需要抢夺。但在这样的狼性环境里，忙于竞争的我们是不是丢失了什么？"},{"tid":"40577","authorid":"22099","author":"E木易","dateline":"05月19日 12:18","subject":"超萌动画短片《灰尘家族》","replies":"0","liketimes":"90","special":"16","isliked":0,"movietid":"0","image":"data/attachment/forum/201607/24/174148wlrcztfyykwtkcgf.jpg","width":1280,"height":720,"videourl":"http://morguo.com/data/attachment/movietrailer/threadvideo/2015/40577_dustbuddies.mp4","intro":"平时看起来有点儿讨厌的灰尘在这则短片里却是毛绒绒超可爱！小灰尘这是要上天！"},{"tid":"44081","authorid":"23511","author":"离岛十一月","dateline":"07月18日 17:25","subject":"杰克的寓言","replies":"0","liketimes":"89","special":"16","isliked":0,"movietid":"0","image":"data/attachment/forum/201607/18/173154tmmhfi4c52i5o75u.jpg","width":1642,"height":822,"videourl":"http://morguo.com/data/attachment/movietrailer/threadvideo/2015/44081_shidanli.mp4","intro":"你有没有经历过，坐在办公间里、教室里，可是心却早已神游物外？"},{"tid":"44397","authorid":"200","author":"神秘黑衣人","dateline":"4&nbsp;天前","subject":"变装酷童","replies":"1","liketimes":"99","special":"16","isliked":0,"movietid":"0","image":"data/attachment/forum/201607/22/174711p5tu5t34t7pz6pip.jpg","width":720,"height":480,"videourl":"http://morguo.com/data/attachment/movietrailer/threadvideo/2015/44397_franswasharl.mp4","intro":"还记得《怦然心动》里那个青涩害羞的小正太吗？这则短片真实记录了一下卡兰妖孽的花样正太时光......"},{"tid":"44400","authorid":"23511","author":"离岛十一月","dateline":"4&nbsp;天前","subject":"波斯音乐动画短片《凤凰》","replies":"0","liketimes":"88","special":"16","isliked":0,"movietid":"0","image":"data/attachment/forum/201607/22/181036nzdqy88hy6dx2xde.jpg","width":1858,"height":1038,"videourl":"http://morguo.com/data/attachment/movietrailer/threadvideo/2015/44400_fenghuang.mp4","intro":"一只普通燕雀视角里面的世界是什么样子呢？"},{"tid":"36808","authorid":"20878","author":"皮皮历险记","dateline":"03月30日 14:44","subject":"迷你催泪弹：CARGO","replies":"2","liketimes":"94","special":"16","isliked":0,"movietid":"0","image":"data/attachment/forum/201607/22/170534aihrvaivi0vx00xa.jpg","width":1280,"height":720,"videourl":"http://morguo.com/data/attachment/movietrailer/threadvideo/2015/36808_Cargo.mp4","intro":"我叫Rosie，我的爸爸没吃我......"},{"tid":"43945","authorid":"23511","author":"离岛十一月","dateline":"07月14日 17:01","subject":"BreakingPoint","replies":"0","liketimes":"84","special":"16","isliked":0,"movietid":"0","image":"data/attachment/forum/201607/22/094112x1alxxo4n9bekll1.jpeg","width":1239,"height":774,"videourl":"http://morguo.com/data/attachment/movietrailer/threadvideo/2015/43945_BreakingPoint.mp4","intro":"承受着多大的痛苦，就爆发出多大的能量。"},{"tid":"44328","authorid":"23511","author":"离岛十一月","dateline":"5&nbsp;天前","subject":"人生哲理隐喻动画《AGAIN》","replies":"1","liketimes":"79","special":"16","isliked":0,"movietid":"0","image":"data/attachment/forum/201607/21/165209ab72zrv1yex7rxz6.jpg","width":1070,"height":605,"videourl":"http://morguo.com/data/attachment/movietrailer/threadvideo/2015/44328_again.mp4","intro":"假设你永远不会死，你的生命将在命运的轮回里无限循环，将会发生什么呢？"}]
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
         * tid : 44503
         * authorid : 200
         * author : 神秘黑衣人
         * dateline : 16&nbsp;小时前
         * subject : 仓鼠
         * replies : 0
         * liketimes : 44
         * special : 16
         * isliked : 0
         * movietid : 0
         * image : data/attachment/forum/201607/26/003833r8o68mow8tj66sch.jpg
         * width : 770
         * height : 433
         * videourl : http://morguo.com/data/attachment/movietrailer/threadvideo/2015/44503_thehamaster.mp4
         * intro : 这是一个关于爱和恐惧的故事。可爱的仓鼠在女儿面前代表着快乐，在父亲眼中却不那么简单。
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
            private String videourl;
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

            public String getVideourl() {
                return videourl;
            }

            public void setVideourl(String videourl) {
                this.videourl = videourl;
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
