package com.uos.smsmsm.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import com.uos.smsmsm.data.UserDTO
import com.uos.smsmsm.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

// 사용자 로그인 / Setting 등 사용자 정보 관련 ViewModel
class UserUtilViewModel @ViewModelInject constructor() : ViewModel(){

    var currentUser : MutableLiveData<UserDTO> = MutableLiveData()
    var currentDestinationUser : MutableLiveData<UserDTO> = MutableLiveData()

    var checkFriends = MutableLiveData<Boolean>()

    val userRepository  = UserRepository()

    val auth = FirebaseAuth.getInstance()

    fun checkFriend(destinationUid: String){
        viewModelScope.launch(Dispatchers.IO){
            userRepository.isFriend(auth.currentUser!!.uid, destinationUid).collect{

                checkFriends.postValue(it)
            }
        }
    }

    fun initUser(){

    }

    fun initDestinationUser(destinationUid : String){
        viewModelScope.launch(Dispatchers.IO){
            userRepository.getUser(destinationUid).collect {
                currentUser
            }
        }
    }

}