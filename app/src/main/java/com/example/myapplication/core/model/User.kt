package com.example.myapplication.core.model

import com.example.myapplication.core.enum.Roles

data class User(
    val userRole: Roles,
    val loginData: ConfidentialDataModel,
    val userInfo: UnconfidentialDataModel
)