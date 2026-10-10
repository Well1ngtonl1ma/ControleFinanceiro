package com.example.controlefinanceiro

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Expense(
    val id: Long,
    val title: String,
    val category: String,
    val amount: Double,
    val date: String,
    val description: String,
    var isPaid: Boolean
) : Parcelable
