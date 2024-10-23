package com.pcity.project.domain.enums;

public enum BedType {
    KING("킹"), TWIN("트윈"), KING_ONLY("킹온리"), BOTH("킹+트윈"), DOUBLE_KING("킹+킹");

    private final String render;

    //Enum 생성자
    BedType(String render){
        this.render = render;
    }

    //한글 타입명 반환
    public String renderType(){
        return render;
    }
}
