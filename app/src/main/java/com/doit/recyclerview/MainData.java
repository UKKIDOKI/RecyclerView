package com.doit.recyclerview;


// 리사이클러뷰를 통해 보여줄 데이터 클래스
// 뷰홀더 객체를 통해 출력
// 사용한 변수 선언후 생성자와 게터세터를 추가
public class MainData {
    private int iv_profile;
    private String tv_name;
    private String tv_content;

    public MainData(int iv_profile, String tv_name, String tv_content) {
        this.iv_profile = iv_profile;
        this.tv_name = tv_name;
        this.tv_content = tv_content;
    }

    public int getIv_profile() {
        return iv_profile;
    }

    public void setIv_profile(int iv_profile) {
        this.iv_profile = iv_profile;
    }

    public String getTv_name() {
        return tv_name;
    }

    public void setTv_name(String tv_name) {
        this.tv_name = tv_name;
    }

    public String getTv_content() {
        return tv_content;
    }

    public void setTv_content(String tv_content) {
        this.tv_content = tv_content;
    }
}
