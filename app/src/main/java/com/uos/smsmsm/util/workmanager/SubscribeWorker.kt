package com.uos.smsmsm.util.workmanager

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.uos.smsmsm.data.ContentDTO
import com.uos.smsmsm.repository.BackgroundRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class BackgroundWorker(context: Context, worker : WorkerParameters) : Worker(context,worker){

    private val repository = BackgroundRepository()
    private val mainScope = CoroutineScope(Dispatchers.Main)

    override fun doWork(): Result {

        val workState = inputData.getInt("WORK_STATE",1)
        val destinationUid = inputData.getString("WORK_DESTINATION_UID").toString()
        val subscribeUidList = inputData.getStringArray("WORK_SUBSCRIBE_UID_LIST")

        var postThumbnailId = inputData.getString("WORK_POST_UID")
        var postThumbnailTimestamp = inputData.getString("WORK_POST_TIMESTAMP")!!.toLong()
        //copy user contents collection copy & paste in MySubscribeContentsUidList
        when(workState) {
            BackgroundWorker.WORK_COPY_PASTE_CONTENTS -> {

                mainScope.launch {
                    repository.copyUserContents(uid = destinationUid).collect {

                        repository.pasteUserContentsMyContainer(it).collect{

                        }
                    }
                }
            }
            BackgroundWorker.WORK_MYSUBSCRIBE_CONTAINER_UPDATE ->{
                mainScope.launch {
                    //해당 유저를 구독하고 있는 목록 가져오기
                    repository.getSubscribeUserList(uid = destinationUid).collect {
                        println("끄아아아아앜 ${it.toString()}")
                        if (it != null){
                            var thumbnail = ContentDTO.PostThumbnail()
                            thumbnail.uid = postThumbnailId
                            thumbnail.timestamp = postThumbnailTimestamp
                            println("끄아아아아아아아아앙아ㅏㅇ아앜 postThumbnailId $postThumbnailId postThumbnailTimestamp $postThumbnailTimestamp")
                            repository.addContentInSubscribeUserContainer(thumbnail,it).collect {
                                println("끼에에에엙 $it")

                            }
                        }
                    }
                }
            }
            BackgroundWorker.WORK_DELETE_CONTENTS ->{

            }
        }

        return Result.success()
    }



    //how use this
    /*
        var data22 : MutableMap<String,Any> = HashMap()

        data22.put("WORK_STATE" , BackgroundWorker.WORK_COPY_PASTE_CONTENTS)
        data22.put("WORK_UID" , FirebaseAuth.getInstance().uid.toString())

        val inputData = Data.Builder().putAll(data22).build()

        val uploadManager : WorkRequest = OneTimeWorkRequestBuilder<BackgroundWorker>().setInputData(inputData).build()
        WorkManager.getInstance(binding.root.context).enqueue(uploadManager)
     */

    companion object{
        const val WORK_COPY_PASTE_CONTENTS = 1001
        const val WORK_DELETE_CONTENTS = 1002
        const val WORK_MYSUBSCRIBE_CONTAINER_UPDATE = 1003
    }
}