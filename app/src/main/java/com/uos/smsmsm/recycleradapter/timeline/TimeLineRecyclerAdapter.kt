package com.uos.smsmsm.recycleradapter.timeline

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.uos.smsmsm.data.TimeLineDTO
import com.uos.smsmsm.databinding.ItemTimelinePostBinding
import com.uos.smsmsm.repository.UserRepository
import com.uos.smsmsm.repository.UtilRepository

class TimeLineRecyclerAdapter(private val context : Context, private val list : LiveData<ArrayList<TimeLineDTO>>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val userRepository = UserRepository()
    private val utilRepository = UtilRepository()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = ItemTimelinePostBinding.inflate(
            LayoutInflater.from(context),
            parent,
            false
        )
        return TimeLinePostViewHolder(binding = binding)
    }


    override fun getItemCount(): Int = list.value!!.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as TimeLinePostViewHolder).onBind(list.value!![position])

        //글쓴 유저의 uid를 가져온뒤 프로필 이미지

        //글쓴 유저의 닉네임

        //viewpager에 사진 연결

        //댓글창이 3개 이하면 댓글 리사이클러뷰 연결

        //댓글이 0개 이상이면 갯수 연결

        //조회수 연결

        //좋아요 액션

        //북마크 액션

        //dm 액션

        //댓글 액션 = 댓글 activity로 이동 + 댓글 edittext 클릭시 이동 + 댓글 버튼 클릭시 이동

        //이모티콘 액션 연결

        //댓글 작성하기 좌측에 보고있는 유저의 프로필 연결

        //옵션 버튼 클릭시 팝업 박스 표시

        //사진 더블 클릭시 좋아요 액션

        
    }

    inner class TimeLinePostViewHolder(val binding : ItemTimelinePostBinding) : RecyclerView.ViewHolder(binding.root){
        fun onBind(data : TimeLineDTO){
            when(data.content!!.postState){
                //애드몹 광고면
                TimeLineDTO.POST_STATE_ADMOB.toString() ->{
                    binding.itemTimelinePostConstNoticeBar.visibility = View.VISIBLE
                }
                //삭제된 상태면
                TimeLineDTO.POST_STATE_DELETE.toString() ->{

                }
                //페이스북 오디언스면
                TimeLineDTO.POST_STATE_FACEBOOK_AUDIANCE.toString() ->{
                    binding.itemTimelinePostConstNoticeBar.visibility = View.VISIBLE
                }
                //친구 전용이면
                TimeLineDTO.POST_STATE_ONLYFRIENDS.toString() ->{

                }
                //비공개 글이면
                TimeLineDTO.POST_STATE_PRIVATE.toString() ->{

                }
                //전체 공개글이면
                TimeLineDTO.POST_STATE_PUBLIC.toString() ->{

                }
            }

            //친구가 아니면 댓글 창 꺼주기

            //친구면 댓글창 켜주기

            //댓글이 3개 이하면 댓글 미리 보기 리사이클러뷰 켜기

            //댓글이 0개면 댓글 텍스트 끄기
            binding.itemtimelinepost = data
        }
    }

}