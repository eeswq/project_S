package com.uos.smsmsm.data

data class TimeLineDTO(
    var postState : Int ? = null, //
    var title : String ? = null,
    var contents : MutableMap<String,ContentDTO> = mutableMapOf()
){
    companion object {
        //post state
        const val POST_STATE_PUBLIC = 1         //공개
        const val POST_STATE_PRIVATE = 2        //비공개
        const val POST_STATE_ONLYFRIENDS = 3    //친구공개
        const val POST_STATE_DELETE = 4         //삭제
    }
}

